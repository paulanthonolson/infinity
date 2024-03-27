package cscmatchtest;

import java.lang.reflect.Modifier;

public class Test07 extends TestCore {
	public static void main(String[] args) {
		new Test07().runTests();
	}

	public void runTests() {
		new Test06().runTests();
		startTests();
		try {
			testCSCMatch();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testCSCMatch() {
		TestClass tc = cscMatchClass;

		requiredClass(tc);
		requiredMethod(cscMatchClass, "main", Modifier.PUBLIC | Modifier.STATIC, "void", String[].class);
	}
}
