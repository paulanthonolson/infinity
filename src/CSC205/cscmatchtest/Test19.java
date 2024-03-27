package cscmatchtest;

import java.io.InvalidClassException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

public class Test19 extends TestCore {
    public static void main(String[] args) {
        new Test19().runTests();
    }

    public void runTests() {
        new Test17().runTests();
        startTests();
        try {
            testMembership();
        } catch (TestExit e) {
        }
        summarizeTests();
    }

    public void testMembership() {
        String filename = "TestData.csc";
        TestClass tc = membershipClass;
        Method load;
        Method memberIterator;
        Method interestIterator;
        Method getName;
        Method getYear;
        Method getTopic;
        Method getLevel;

        requiredClass(tc);
        requiredClass(memberClass);
        requiredClass(interestClass);
        getName = requiredMethod(memberClass, "getName", Modifier.PUBLIC, "String");
        getYear = requiredMethod(memberClass, "getYear", Modifier.PUBLIC, "int");
        getTopic = requiredMethod(interestClass, "getTopic", Modifier.PUBLIC, "String");
        getLevel = requiredMethod(interestClass, "getLevel", Modifier.PUBLIC, "int");

        load = requiredMethod(tc, "load", Modifier.PUBLIC + Modifier.STATIC, "cscmatch.Membership",
                new String[] { "java.io.IOException", "ClassNotFoundException" }, String.class);
        memberIterator = requiredMethod(tc, "iterator", Modifier.PUBLIC, "java.util.Iterator<cscmatch.Member>");
        interestIterator = requiredMethod(memberClass, "iterator", Modifier.PUBLIC,
                "java.util.Iterator<cscmatch.Interest>");

        try {
            Object mbrshp = load.invoke(null, filename);
            @SuppressWarnings("unchecked")
            Iterator<Object> q1 = (Iterator<Object>) memberIterator.invoke(mbrshp);
            int mcount = 0;
            int icount = 0;
            while (q1.hasNext()) {
                Object mbr = q1.next();
                mcount++;
                System.out.print(getName.invoke(mbr) + ":" + getYear.invoke(mbr));
                @SuppressWarnings("unchecked")
                Iterator<Object> q2 = (Iterator<Object>) interestIterator.invoke(mbr);
                while (q2.hasNext()) {
                    Object intr = q2.next();
                    System.out.printf(" %s:%2d", getTopic.invoke(intr), getLevel.invoke(intr));
                    icount++;
                }
                System.out.println();
            }
            if (mcount != 7 || icount != 20) {
                fail("Expected 7 members and 20 interests, loaded " + mcount + " members and " + icount + " interests");
            }
        } catch (TestExit e) {
            throw e;
        } catch (Exception e1) {
            Throwable e2 = (Exception) e1.getCause();
            if (e2.getClass().equals(fileNotFoundExceptionClass.getClazz())) {
                fail("Unable to load file: " + e2.getMessage());
            } else if (e2.getClass().equals(InvalidClassException.class)) {
                fail("TestData.csc appears to have been created using an earlier version of one of your classes: "
                        + e2.getMessage());
            } else {
                unexpected(e2);
            }
        }
        pass("Data loaded and printed successfully but was not verified");
    }
}
