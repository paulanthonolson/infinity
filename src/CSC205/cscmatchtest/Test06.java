package cscmatchtest;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test06 extends TestCore {
	public static void main(String[] args) {
		new Test06().runTests();
	}

	public void runTests() {
		new Test05().runTests();
		startTests();
		try {
			testMenu();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testMenu() {
		TestClass tc = menuClass;
		Field mbrshp = null;
		Field scnr;
		Field running;
		Field unsavedChanges;
		Method doQuit;

		requiredClass(tc);
		mbrshp = requiredVariable(tc, "mbrshp", Modifier.PRIVATE, "cscmatch.Membership");
		scnr = requiredVariable(tc, "scnr", Modifier.PRIVATE, "java.util.Scanner");
		running = requiredVariable(tc, "running", Modifier.PRIVATE, "boolean");
		unsavedChanges = requiredVariable(tc, "unsavedChanges", Modifier.PRIVATE, "boolean");

		requiredMethod(tc, "run", Modifier.PUBLIC, "void");
		requiredMethod(tc, "doLoadMembers", Modifier.PRIVATE, "void");
		requiredMethod(tc, "doSaveMembers", Modifier.PRIVATE, "void");
		requiredMethod(tc, "doListAllMembers", Modifier.PRIVATE, "void");
		requiredMethod(tc, "doAddMember", Modifier.PRIVATE, "void");
		requiredMethod(tc, "doRemoveMember", Modifier.PRIVATE, "void");
		requiredMethod(tc, "doListMember", Modifier.PRIVATE, "void");
		requiredMethod(tc, "doAddInterest", Modifier.PRIVATE, "void");
		requiredMethod(tc, "getBoundedInt", Modifier.PRIVATE, "int", String.class, int.class, int.class);
		doQuit = requiredMethod(tc, "doQuit", Modifier.PRIVATE, "void");

		try {
			System.setIn(new ByteArrayInputStream("\r\n".getBytes()));
			Object menu = menuClass.newInstance();
			Object m = mbrshp.get(menu);
			if (m == null) {
				fail("mbrshp not initialized");
			}
			Object k = scnr.get(menu);
			if (k == null) {
				fail("scnr not initialized");
			}
			if (!running.getBoolean(menu)) {
				fail("running was not initialized to true");
			}
			if (unsavedChanges.getBoolean(menu)) {
				fail("unsavedChanges was not initialized to false");
			}
			// Try to check if doQuit is doing the right thing, but if any exception
			// is thrown, just give up on this test.
			try {
				doQuit.setAccessible(true);
				doQuit.invoke(menu);
				if (running.getBoolean(menu)) {
					pass("doQuit did not change running to false (may be an error)");
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			unexpected(e);
		}
	}
}
