package cscmatchtest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

public class Test09 extends TestCore {
	public static void main(String[] args) {
		new Test09().runTests();
	}

	public void runTests() {
		new Test07().runTests();
		startTests();
		try {
			testMembership();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testMembership() {
		TestClass tc = membershipClass;
		Method addMember = null;
		Method iterator;
		Method findMember;

		requiredClass(tc);
		addMember = requiredMethod(tc, "addMember", Modifier.PUBLIC, "cscmatch.Member", String.class, int.class);
		iterator = requiredMethod(tc, "iterator", Modifier.PUBLIC, "java.util.Iterator<cscmatch.Member>");
		findMember = requiredMethod(tc, "findMember", Modifier.PUBLIC, "cscmatch.Member", String.class);
		requiredInterface(tc, "java.lang.Iterable<cscmatch.Member>");

		try {
			Object mbrshp = membershipClass.newInstance();
			Object mbr;
			addMember.invoke(mbrshp, "N1", 1);
			addMember.invoke(mbrshp, "N2", 2);
			addMember.invoke(mbrshp, "N3", 3);

			String expected;
			String actual;

			@SuppressWarnings("unchecked")
			Iterator<Object> iter = (Iterator<Object>) iterator.invoke(mbrshp);
			int i = 0;
			while (iter.hasNext()) {
				Object o = iter.next();
				i++;
				expected = "Name: N" + i + ", Year: " + i;
				actual = o.toString().replace("\n", "");
				if (!expected.equals(actual)) {
					fail("Membership iterator pass " + i + " expected '" + expected + "' actual '" + actual + "'");
				}
			}

			mbr = findMember.invoke(mbrshp, "N2");
			if (mbr == null) {
				fail("findMember failed to locate N2");
			}

			mbr = findMember.invoke(mbrshp, "N9");
			if (mbr != null) {
				fail("findMember located non-existent N9");
			}

			expected = "N1\nN2\nN3\n";
			actual = mbrshp.toString();
			if (!expected.equals(actual)) {
				fail("Membership toString expected\n" + expected + "actual\n" + actual);
			}
		} catch (Exception e) {
			unexpected(e);
		}
	}
}
