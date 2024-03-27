package cscmatchtest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test03 extends TestCore {
	public static void main(String[] args) {
		new Test03().runTests();
	}

	public void runTests() {
		new Test02().runTests();
		startTests();
		try {
			testInterest();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testInterest() {
		TestClass tc = interestClass;
		Method validateTopic;
		Method validateLevel;
		Method setTopic = null;
		Method setLevel = null;
		Method getTopic = null;
		Method getLevel = null;
		Object intr = null;
		String testTopic = "Test Topic";
		String testTopic2 = "Test topic2";
		int testLevel = 1;
		String gotTopic;
		int gotLevel;
		String errMsg;

		requiredClass(tc);
		Field MIN_LEVEL = requiredVariable(tc, "MIN_LEVEL", Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL, "int");
		Field MAX_LEVEL = requiredVariable(tc, "MAX_LEVEL", Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL, "int");
		requiredVariable(tc, "topic", Modifier.PRIVATE, "String");
		requiredVariable(tc, "level", Modifier.PRIVATE, "int");
		requiredMethod(tc, "setTopic", Modifier.PUBLIC, "void", String.class);
		requiredMethod(tc, "setLevel", Modifier.PUBLIC, "void", int.class);
		requiredMethod(tc, "getTopic", Modifier.PUBLIC, "String");
		requiredMethod(tc, "getLevel", Modifier.PUBLIC, "int");
		requiredMethod(tc, "toString", Modifier.PUBLIC, "String");

		try {
			if (MIN_LEVEL.getInt(null) != 0) {
				fail("MIN_LEVEL must be 0");
			}
			if (MAX_LEVEL.getInt(null) != 10) {
				fail("MAX_LEVEL must be 10");
			}
		} catch (IllegalAccessException e) {
			unexpected(e);
		}

		try {
			intr = tc.newInstance(testTopic, testLevel);
		} catch (InvocationTargetException e1) {
			Throwable e2 = (Exception) e1.getCause();
			if (e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
				fail("constructor did not allow topic to be set to '" + testTopic + "' and level to be set to "
						+ testLevel);
			} else {
				unexpected(e2);
			}
		} catch (Exception e) {
			unexpected(e);
		}

		try {
			tc.newInstance(new String(""), testLevel);
			fail("constructor allowed topic to be set to \"\"");
		} catch (InvocationTargetException e1) {
			Throwable e2 = (Exception) e1.getCause();
			if (e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
				// Setting name to "" was blocked
			} else {
				unexpected(e2);
			}
		} catch (Exception e) {
			unexpected(e);
		}

		for (int i = -1; i < 12; i++) {
			try {
				tc.newInstance(testTopic, i);
				if (i < 0 || i > 10) {
					fail("constructor allowed level to be set to " + i);
				}
			} catch (InvocationTargetException e1) {
				Throwable e2 = (Exception) e1.getCause();
				if (e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
					if (i >= 0 && i <= 10) {
						fail("constructor did not allow level to be set to " + i);
					}
				} else {
					unexpected(e2);
				}
			} catch (Exception e) {
				unexpected(e);
			}
		}

		try {
			validateTopic = requiredMethod(tc, "validateTopic", Modifier.PUBLIC | Modifier.STATIC, "String",
					String.class);
			validateLevel = requiredMethod(tc, "validateLevel", Modifier.PUBLIC | Modifier.STATIC, "String", int.class);
			setTopic = requiredMethod(tc, "setTopic", Modifier.PUBLIC, "void", String.class);
			getTopic = requiredMethod(tc, "getTopic", Modifier.PUBLIC, "String");
			setLevel = requiredMethod(tc, "setLevel", Modifier.PUBLIC, "void", int.class);
			getLevel = requiredMethod(tc, "getLevel", Modifier.PUBLIC, "int");

			errMsg = (String) validateTopic.invoke(null, new Object[] { null });
			if (errMsg == null) {
				fail("validateTopic did not provide an error for null topic");
			}
			errMsg = (String) validateTopic.invoke(null, "");
			if (errMsg == null) {
				fail("validateTopic did not provide an error for \"\"");
			}
			errMsg = (String) validateTopic.invoke(null, testTopic);
			if (errMsg != null) {
				fail("validateTopic incorrectly provided an error for " + testLevel + ": " + errMsg);
			}

			errMsg = (String) validateLevel.invoke(null, -1);
			if (errMsg == null) {
				fail("validateLevel did not provide an error for -1");
			}
			errMsg = (String) validateLevel.invoke(null, 11);
			if (errMsg == null) {
				fail("validateLevel did not provide an error for 11");
			}
			errMsg = (String) validateLevel.invoke(null, 0);
			if (errMsg != null) {
				fail("validateLevel incorrectly provided an error for 0: " + errMsg);
			}
			errMsg = (String) validateLevel.invoke(null, 10);
			if (errMsg != null) {
				fail("validateLevel incorrectly provided an error for 10: " + errMsg);
			}

			gotTopic = (String) getTopic.invoke(intr);
			gotLevel = (int) getLevel.invoke(intr);

			if (!testTopic.equals(gotTopic)) {
				fail("constructed name '" + testTopic + "' getTopic '" + gotTopic + "'");
			}

			if (testLevel != gotLevel) {
				fail("constructed level '" + testLevel + "' getLevel '" + gotLevel + "'");
			}

			testLevel++;
			setTopic.invoke(intr, testTopic2);
			setLevel.invoke(intr, testLevel);

			gotTopic = (String) getTopic.invoke(intr);
			gotLevel = (int) getLevel.invoke(intr);

			if (!testTopic2.equals(gotTopic)) {
				fail("setTopic '" + testTopic2 + "' getTopic '" + gotTopic + "'");
			}

			if (testLevel != gotLevel) {
				fail("setLevel level '" + testTopic + "' getLevel '" + gotLevel + "'");
			}

			Method toString = requiredMethod(tc, "toString", Modifier.PUBLIC, "String");
			String gotToString = (String) toString.invoke(intr);
			String expectedToString = "Topic: " + testTopic2 + ", Level: " + testLevel;
			if (!gotToString.equals(expectedToString)) {
				String wrongDash = null;
				if (gotToString.indexOf('\u2013') >= 0) {
					wrongDash = "en dash";
				}
				if (gotToString.indexOf('\u2014') >= 0) {
					wrongDash = "em dash";
				}
				if (wrongDash != null) {
					fail("toString has an " + wrongDash
							+ " instead of a hyphen; edit the method, delete what looks like -, and replace it with -");
				}
				fail("toString expected '" + expectedToString + "' got '" + gotToString + "'");
			}

		} catch (Exception e) {
			unexpected(e);
		}

		try {
			setTopic.invoke(intr, "");
			fail("setTopic allowed name to be changed to \"\"");
		} catch (InvocationTargetException e1) {
			Throwable e2 = (Exception) e1.getCause();
			if (!e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
				unexpected(e2);
			}
		} catch (Exception e) {
			unexpected(e);
		}

		try {
			setLevel.invoke(intr, -1);
			fail("setLevel allowed level to be changed to -1");
		} catch (InvocationTargetException e1) {
			Throwable e2 = (Exception) e1.getCause();
			if (!e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
				unexpected(e2);
			}
		} catch (Exception e) {
			unexpected(e);
		}
	}
}
