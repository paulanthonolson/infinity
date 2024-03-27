package cscmatchtest;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

abstract public class TestCore {
	private String facility = "";
	private int failures = 0;
	static private int activeTests = 0;
	static private int totalFailures = 0;
	static private PrintStream lastStream = null;

	final static protected TestClass cscMatchClass = new TestClass("cscmatch.CSCMatch");
	final static protected TestClass menuClass = new TestClass("cscmatch.Menu");
	final static protected TestClass membershipClass = new TestClass("cscmatch.Membership");
	final static protected TestClass memberClass = new TestClass("cscmatch.Member", String.class, int.class);
	final static protected TestClass interestClass = new TestClass("cscmatch.Interest", String.class, int.class);
	final static protected TestClass compatibilityClass = new TestClass("cscmatch.Compatibility",
			memberClass.getClazz(), memberClass.getClazz());
	final static protected TestClass illegalArgumentExceptionClass = new TestClass("java.lang.IllegalArgumentException",
			String.class);
	final static protected TestClass fileNotFoundExceptionClass = new TestClass("java.io.FileNotFoundException",
			String.class);

	abstract public void runTests();

	static {
		// During startup, reroute System.in to prevent keyboard input from locking up
		// any test
		System.setIn(new ByteArrayInputStream("".getBytes()));
	}

	public TestCore() {
		activeTests++;
	}

	public int getActiveTests() {
		return activeTests;
	}

	public void log(PrintStream stream, String prefix, String message) {
		// Work-around timing issue that can cause System.out and System.err
		// messages to be intermixed in Eclipse console.
		if (lastStream != stream) {
			if (lastStream != null) {
				lastStream.flush();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			lastStream = stream;
		}
		stream.println(prefix + " " + (facility.equals("") ? "" : facility + " : ") + message);
	}

	public void successMessage(String reason) {
		log(System.out, "+", reason);
	}

	public void errorMessage(String reason) {
		log(System.err, "-", reason);
	}

	public void pass(String reason) {
		successMessage(reason);
	}

	public void fail(String reason) {
		errorMessage(reason);
		failures++;
		totalFailures++;
		throw new TestExit();
	}

	public void unexpected(Throwable e) {
		if (!e.getClass().equals(TestExit.class)) {
			e.printStackTrace();
			fail("unexpected exception " + e.getClass() + ", please report to instructor");
		} else {
			throw new TestExit();
		}
	}

	private String className(String e) {
		return e.replaceAll("class ", "").replace("java.lang.", "");
	}

	public void startTests(String facility) {
		facility = facility.replace("test.", "");
		if (!this.facility.equals(facility)) {
			this.facility = facility;
			successMessage("start tests");
		}
	}

	public void startTests() {
		startTests(this.getClass().getName());
	}

	public void summarizeTests() {
		if (failures == 0) {
			successMessage("all tests passed");
		} else {
			errorMessage(failures + " tests failed");
		}
		activeTests--;
		if (activeTests == 0) {
			String saveFacility = facility;
			facility = "======";
			if (totalFailures == 0) {
				successMessage("all tests passed across all groups");
			} else {
				errorMessage(totalFailures + " tests failed across all groups");
			}
			facility = saveFacility;
		}
	}

	public String modifierNames(int requiredModifiers) {
		String mods = "";
		if ((requiredModifiers & Modifier.PUBLIC) != 0) {
			mods += "public ";
		}
		if ((requiredModifiers & Modifier.PRIVATE) != 0) {
			mods += "private ";
		}
		if ((requiredModifiers & Modifier.PROTECTED) != 0) {
			mods += "protected ";
		}
		if ((requiredModifiers & Modifier.STATIC) != 0) {
			mods += "static ";
		}
		if ((requiredModifiers & Modifier.FINAL) != 0) {
			mods += "final ";
		}
		mods = mods.trim();
		return mods;
	}

	public Type requiredInterface(TestClass tc, String name) {
		try {
			for (Type t : tc.getClazz().getGenericInterfaces()) {
				if (t.toString().replace("interface ", "").equals(name)) {
					return t;
				}
			}
		} catch (Exception e) {
			unexpected(e);
		}
		fail("Class " + tc.getName() + " does not implement required interface " + name);
		return null;
	}

	public void deniedInterface(TestClass tc, String name) {
		try {
			for (Type t : tc.getClazz().getGenericInterfaces()) {
				if (t.toString().replace("interface ", "").equals(name)) {
					fail("Class " + tc.getName() + " is not allowed to implement interface " + name);
				}
			}
		} catch (Exception e) {
			unexpected(e);
		}
	}

	public Field requiredVariable(TestClass tc, String name, int requiredModifiers, String type) {
		Field field = null;
		try {
			field = tc.getClazz().getDeclaredField(name);
			String fieldType = className(field.getGenericType().toString());
			if (!fieldType.equals(type)) {
				fail(tc.getName() + " variable " + name + " must be of type " + type);
			}
			int modifiers = field.getModifiers();
			if (modifiers != requiredModifiers) {
				fail(tc.getName() + " variable " + name + " must be declared as " + modifierNames(requiredModifiers));
			}
		} catch (NoSuchFieldException e) {
			fail(tc.getName() + " variable " + name + " not declared");
		}
		field.setAccessible(true);
		return field;
	}

	public Method requiredMethod(TestClass tc, String name, int requiredModifiers, String returnType,
			Class<?>... parameters) {
		return requiredMethod(tc, name, requiredModifiers, returnType, null, parameters);
	}

	public Method requiredMethod(TestClass tc, String name, int requiredModifiers, String returnType,
			String[] exceptions, Class<?>... parameters) {
		Method method = null;
		Set<String> requiredExceptions = new HashSet<>();
		Set<String> unexpectedExceptions = new HashSet<>();

		if (exceptions != null) {
			for (String s : exceptions) {
				requiredExceptions.add(className(s));
			}
		}

		try {
			method = tc.getClazz().getDeclaredMethod(name, parameters);
			if (method.getModifiers() != requiredModifiers) {
				fail(tc.getName() + " method " + method.getName() + " must be declared as "
						+ modifierNames(requiredModifiers));
			}
			String methodReturnType = className(method.getGenericReturnType().toString());
			if (!methodReturnType.equals(returnType)) {
				fail(tc.getName() + " method " + name + " must return type " + returnType);
			}
			for (Class<?> e : method.getExceptionTypes()) {
				String ename = className(e.toString());
				if (requiredExceptions.contains(ename)) {
					requiredExceptions.remove(ename);
				} else {
					// Allow IllegalArgumentException to be considered optional
					if (!ename.equals("IllegalArgumentException")) {
						unexpectedExceptions.add(ename);
					}
				}
			}
			if (requiredExceptions.size() != 0) {
				fail(tc.getName() + " method " + name + " is not declared to throw required exception "
						+ requiredExceptions);
			}
			if (unexpectedExceptions.size() != 0) {
				fail(tc.getName() + " method " + name + " is not allowed to throw exception " + unexpectedExceptions);
			}
		} catch (NoSuchMethodException e) {
			fail(tc.getName() + " method " + name + " does not exist with " + e.getMessage());
		}

		return method;
	}

	public void requiredClass(TestClass tc) {
		Class<?> clazz = tc.getClazz();

		if (clazz == null) {
			fail(tc.getName() + " required class " + tc.getName() + " not defined or invalid");
		}

		if (clazz.getModifiers() != Modifier.PUBLIC) {
			fail(tc.getName() + " required class " + tc.getName() + " must be declared as public");
		}

		if (tc.getConstructor() == null) {
			fail(tc.getName() + " required class " + tc.getName() + " missing constructor " + tc.getConstructorError());
		}
	}
}
