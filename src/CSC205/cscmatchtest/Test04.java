package cscmatchtest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import positionallist.*;

public class Test04 extends TestCore {
    public static void main(String[] args) {
        new Test04().runTests();
    }

    public void runTests() {
        new Test03().runTests();
        startTests();
        try {
            testMember();
        } catch (TestExit e) {
        }
        summarizeTests();
    }

    public void testMember() {
        Field intrList;
        Method addInterest = null;
        Method compareTo = null;
        Method getTopic;
        Method getLevel;

        requiredClass(memberClass);
        requiredClass(interestClass);
        intrList = requiredVariable(memberClass, "intrList", Modifier.PRIVATE,
                "positionallist.PositionalList<cscmatch.Interest>");
        addInterest = requiredMethod(memberClass, "addInterest", Modifier.PUBLIC, "cscmatch.Interest", String.class,
                int.class);
        getTopic = requiredMethod(interestClass, "getTopic", Modifier.PUBLIC, "String");
        getLevel = requiredMethod(interestClass, "getLevel", Modifier.PUBLIC, "int");
        requiredInterface(interestClass, "java.lang.Comparable<cscmatch.Interest>");
        compareTo = requiredMethod(interestClass, "compareTo", Modifier.PUBLIC, "int", interestClass.getClazz());

        try {
            Object mbr = memberClass.newInstance("Test Name", 1);
            @SuppressWarnings("unchecked")
            PositionalList<Object> i = (LinkedPositionalList<Object>) intrList.get(mbr);
            if (i == null) {
                fail("constructor failed to initialize intrList");
            }
            if (!(i instanceof PositionalList)) {
                fail("intrList is not an positionallist.PositionalList");
            }
            if (i.size() != 0) {
                fail("intrList is not empty right after construction");
            }

            String testTopic1 = "Test Topic 1";
            Object intr1 = addInterest.invoke(mbr, testTopic1, 1);
            if (i.size() != 1) {
                fail("addInterest failed to add interest 1");
            }
            if (intr1 == null || !testTopic1.equals(getTopic.invoke(intr1))) {
                fail("addInterest did not return an Interest with the correct topic");
            }
            if ((int) getLevel.invoke(intr1) != 1) {
                fail("addInterest did not return an Interest with the correct level");
            }

            Object intr3 = addInterest.invoke(mbr, "Test Topic 3", 3);
            if (i.size() != 2) {
                fail("addInterest failed to add interest 3");
            }

            Object intr2 = addInterest.invoke(mbr, "Test Topic 2", 2);
            if (i.size() != 3) {
                fail("addInterest failed to add interest 2");
            }

            if ((Integer) compareTo.invoke(intr1, intr2) <= 0 ||
                    (Integer) compareTo.invoke(intr1, intr1) != 0) {
                fail("Interest compareTo does not appear to be return the correct value");
            }

            if (i.first().getElement() != intr3 ||
                    i.after(i.first()).getElement() != intr2 ||
                    i.last().getElement() != intr1) {
                fail("addInterest is not using the required add method");
            }

            // Although this test would be fair, the reality is that nothing should do this,
            // and if it does,
            // the NullPointerException that results is still a reasonable way to handle it.
            // try {
            // addInterest.invoke(mbr, null, 1);
            // fail("addInterest should have thrown an exception for null topic");
            // } catch (InvocationTargetException e1) {
            // Throwable e2 = (Exception) e1.getCause();
            // if (e2.getClass().equals(NullPointerException.class)) {
            // fail("addInterest throws NullPointerException if topic is null, should throw
            // IllegalArgumentException");
            // } else if (!e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
            // unexpected(e2);
            // }
            // }
        } catch (Exception e) {
            unexpected(e);
        }
    }
}
