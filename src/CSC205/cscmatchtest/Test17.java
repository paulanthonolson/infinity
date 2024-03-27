package cscmatchtest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test17 extends TestCore {
	public static void main(String[] args) {
		new Test17().runTests();
	}

	public void runTests() {
		new Test16().runTests();
		startTests();
		try {
			testMembership();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testMembership() {
		TestClass tc = membershipClass;
		@SuppressWarnings("unused")
		Method save = null;
		@SuppressWarnings("unused")
		Method load = null;

		requiredClass(tc);
		requiredClass(memberClass);
		requiredClass(interestClass);
		save = requiredMethod(tc, "save", Modifier.PUBLIC, "void", new String[] { "java.io.IOException" },
				String.class);
		load = requiredMethod(tc, "load", Modifier.PUBLIC + Modifier.STATIC, "cscmatch.Membership",
				new String[] { "java.io.IOException", "ClassNotFoundException" }, String.class);
		requiredInterface(tc, "java.io.Serializable");
		requiredInterface(memberClass, "java.io.Serializable");
		requiredInterface(interestClass, "java.io.Serializable");

		pass("Make sure you actually test save and load in your program");
	}
}
