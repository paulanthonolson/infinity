package cscmatchtest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test02 extends TestCore {
	public static void main(String[] args) {
		new Test02().runTests();
	}

	public void runTests() {
		startTests();
		try {
			testMember();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testMember() {
		TestClass tc = memberClass;
		Method validateName = null;
		Method validateYear = null;
		Method setName = null;
		Method setYear = null;
		Method getName = null;
		Method getYear = null;
		Object mbr = null;
		String testName = "Test Name";
		String testName2 = "Test Name 2";
		int testYear = 1;
		String gotName;
		int gotYear;
		String errMsg;

		requiredClass(tc);
		deniedInterface(tc, "java.lang.Comparable<cscmatch.Member>");
		Field MIN_YEAR = requiredVariable(tc, "MIN_YEAR", Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL, "int");
		Field MAX_YEAR = requiredVariable(tc, "MAX_YEAR", Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL, "int");
		requiredVariable(tc, "name", Modifier.PRIVATE, "String");
		requiredVariable(tc, "year", Modifier.PRIVATE, "int");

		try {
			if (MIN_YEAR.getInt(null) != 1) {
				fail("MIN_YEAR must be 1");
			}
			if (MAX_YEAR.getInt(null) != 5) {
				fail("MAX_YEAR must be 5");
			}
		} catch (IllegalAccessException e) {
			unexpected(e);
		}

		try {
			mbr = tc.newInstance(testName, testYear);
		} catch (InvocationTargetException e1) {
			Throwable e2 = (Exception) e1.getCause();
			if (e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
				fail("constructor did not allow name to be set to '" + testName + "' and year to be set to "
						+ testYear);
			} else {
				unexpected(e2);
			}
		} catch (Exception e) {
			unexpected(e);
		}

		try {
			tc.newInstance(new String(""), testYear);
			fail("constructor allowed name to be set to \"\"");
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

		for (int i = 0; i < 7; i++) {
			try {
				tc.newInstance(testName, i);
				if (i < 1 || i > 5) {
					fail("constructor allowed year to be set to " + i);
				}
			} catch (InvocationTargetException e1) {
				Throwable e2 = (Exception) e1.getCause();
				if (e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
					if (i >= 1 && i <= 5) {
						fail("constructor did not allow year to be set to " + i);
					}
				} else {
					unexpected(e2);
				}
			} catch (Exception e) {
				unexpected(e);
			}
		}

		try {
			validateName = requiredMethod(tc, "validateName", Modifier.PUBLIC | Modifier.STATIC, "String",
					String.class);
			validateYear = requiredMethod(tc, "validateYear", Modifier.PUBLIC | Modifier.STATIC, "String", int.class);
			setName = requiredMethod(tc, "setName", Modifier.PUBLIC, "void", String.class);
			getName = requiredMethod(tc, "getName", Modifier.PUBLIC, "String");
			setYear = requiredMethod(tc, "setYear", Modifier.PUBLIC, "void", int.class);
			getYear = requiredMethod(tc, "getYear", Modifier.PUBLIC, "int");

			errMsg = (String) validateName.invoke(null, new Object[] { null });
			if (errMsg == null) {
				fail("validateName did not provide an error for null name");
			}
			errMsg = (String) validateName.invoke(null, "");
			if (errMsg == null) {
				fail("validateName did not provide an error for \"\"");
			}
			errMsg = (String) validateName.invoke(null, testName);
			if (errMsg != null) {
				fail("validateName incorrectly provided an error for " + testName + ": " + errMsg);
			}

			errMsg = (String) validateYear.invoke(null, 0);
			if (errMsg == null) {
				fail("validateYear did not provide an error for 0");
			}
			errMsg = (String) validateYear.invoke(null, 6);
			if (errMsg == null) {
				fail("validateYear did not provide an error for 6");
			}
			errMsg = (String) validateYear.invoke(null, 1);
			if (errMsg != null) {
				fail("validateYear incorrectly provided an error for 1: " + errMsg);
			}
			errMsg = (String) validateYear.invoke(null, 5);
			if (errMsg != null) {
				fail("validateYear incorrectly provided an error for 5: " + errMsg);
			}

			gotName = (String) getName.invoke(mbr);
			gotYear = (int) getYear.invoke(mbr);

			if (!testName.equals(gotName)) {
				fail("constructed name '" + testName + "' getName '" + gotName + "'");
			}

			if (testYear != gotYear) {
				fail("constructed year '" + testYear + "' getYear '" + gotYear + "'");
			}

			testYear++;
			setName.invoke(mbr, testName2);
			setYear.invoke(mbr, testYear);

			gotName = (String) getName.invoke(mbr);
			gotYear = (int) getYear.invoke(mbr);

			if (!testName2.equals(gotName)) {
				fail("setName '" + testName2 + "' getName '" + gotName + "'");
			}

			if (testYear != gotYear) {
				fail("setYear year '" + testName + "' getYear '" + gotYear + "'");
			}

			Method toString = requiredMethod(tc, "toString", Modifier.PUBLIC, "String");
			String gotToString = ((String) toString.invoke(mbr)).replace("\n", "");
			String expectedToString = "Name: " + testName2 + ", Year: " + testYear;
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
			setName.invoke(mbr, "");
			fail("setName allowed name to be changed to \"\"");
		} catch (InvocationTargetException e1) {
			Throwable e2 = (Exception) e1.getCause();
			if (!e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
				unexpected(e2);
			}
		} catch (Exception e) {
			unexpected(e);
		}

		try {
			setYear.invoke(mbr, 0);
			fail("setYear allowed year to be changed to 0");
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
