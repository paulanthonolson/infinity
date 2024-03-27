package cscmatchtest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

public class Test13 extends TestCore {
    public static void main(String[] args) {
        new Test13().runTests();
    }

    public void runTests() {
        new Test09().runTests();
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
        Method findInterest;

        requiredClass(tc);
        addInterest = requiredMethod(tc, "addInterest", Modifier.PUBLIC, "cscmatch.Interest", String.class, int.class);
        iterator = requiredMethod(tc, "iterator", Modifier.PUBLIC, "java.util.Iterator<cscmatch.Interest>");
        findInterest = requiredMethod(tc, "findInterest", Modifier.PUBLIC, "cscmatch.Interest", String.class);
        requiredInterface(tc, "java.lang.Iterable<cscmatch.Interest>");

        try {
            Object mbr = memberClass.newInstance("Test Name", 1);
            addInterest.invoke(mbr, "I1", 1);
            addInterest.invoke(mbr, "I2", 2);
            addInterest.invoke(mbr, "I3", 3);

            String expected;
            String actual;

            @SuppressWarnings("unchecked")
            Iterator<Object> q = (Iterator<Object>) iterator.invoke(mbr);
            int i = 3;
            while (q.hasNext()) {
                Object o = q.next();
                expected = "Topic: I" + i + ", Level: " + i;
                i--;
                actual = o.toString();
                if (!expected.equals(actual)) {
                    fail("Member iterator pass " + i + " expected '" + expected + "' actual '" + actual + "'");
                }
            }

            Object intr = findInterest.invoke(mbr, "I2");
            if (intr == null) {
                fail("findInterest failed to locate I2");
            }

            intr = findInterest.invoke(mbr, "I9");
            if (intr != null) {
                fail("findInterest located non-existent I9");
            }

            expected = "Name: Test Name, Year: 1\n  I3: 3\n  I2: 2\n  I1: 1\n";
            actual = mbr.toString();
            if (!expected.equals(actual)) {
                fail("Member toString expected\n" + expected + "actual\n" + actual);
            }

        } catch (Exception e) {
            unexpected(e);
        }
    }
}
