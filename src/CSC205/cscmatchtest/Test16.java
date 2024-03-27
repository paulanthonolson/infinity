package cscmatchtest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

public class Test16 extends TestCore {
	public static void main(String[] args) {
		new Test16().runTests();
	}

	public void runTests() {
		new Test13().runTests();
		startTests();
		try {
			testMembership();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testMembership() {
		TestClass tc = memberClass;
		Method addInterest = null;
		Method iterator;
		Method getTopic;
		Method getLevel;

		requiredClass(tc);
		addInterest = requiredMethod(tc, "addInterest", Modifier.PUBLIC, "cscmatch.Interest", String.class, int.class);
		iterator = requiredMethod(tc, "iterator", Modifier.PUBLIC, "java.util.Iterator<cscmatch.Interest>");
		getTopic = requiredMethod(interestClass, "getTopic", Modifier.PUBLIC, "String");
		getLevel = requiredMethod(interestClass, "getLevel", Modifier.PUBLIC, "int");

		try {
			Object mbr = memberClass.newInstance("Test Name", 1);
			addInterest.invoke(mbr, "Gaming", 3);
			addInterest.invoke(mbr, "Java", 2);
			addInterest.invoke(mbr, "Java", 4);
			addInterest.invoke(mbr, "Java", 6);

			@SuppressWarnings("unchecked")
			Iterator<Object> q = (Iterator<Object>) iterator.invoke(mbr);
			int i = 0;
			boolean java2 = false;
			boolean java4 = false;
			boolean java6 = false;
			int gaming = 0;

			while (q.hasNext()) {
				Object o = q.next();
				i++;
				String topic = (String) getTopic.invoke(o);
				if (topic.equals("Gaming")) {
					gaming = i;
				} else if (topic.equals("Java")) {
					int level = (int) getLevel.invoke(o);
					if (level == 2) {
						java2 = true;
					} else if (level == 4) {
						java4 = true;
					} else if (level == 6) {
						java6 = true;
					} else {
						fail("Interest returned Java level that wasn't 2, 4, or 6: " + level);
					}
				} else {
					fail("Interest returned topic that wasn't Java: " + topic);
				}
			}

			if (java2 && java4 && java6) {
				fail("Interest returned Java at 2, 4, and 6 instead of just 6");
			}

			if (i > 2) {
				fail("Interest returned " + i + " values instead of just 2");
			}

			if (!java6) {
				fail("Interest did not return Java at 6");
			}

			if (gaming != 2) {
				fail("Interest returned Gaming at position " + gaming + ", should be at 2");
			}
		} catch (Exception e) {
			unexpected(e);
		}
	}
}
