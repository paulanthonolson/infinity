package cscmatchtest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import positionallist.*;

public class Test05 extends TestCore {
    public static void main(String[] args) {
        new Test05().runTests();
    }

    public void runTests() {
        new Test04().runTests();
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
        Field mbrList = null;
        Method getName;
        Method getYear;

        requiredClass(tc);
        mbrList = requiredVariable(tc, "mbrList", Modifier.PRIVATE, "positionallist.PositionalList<cscmatch.Member>");
        addMember = requiredMethod(tc, "addMember", Modifier.PUBLIC, "cscmatch.Member", String.class, int.class);
        getName = requiredMethod(memberClass, "getName", Modifier.PUBLIC, "String");
        getYear = requiredMethod(memberClass, "getYear", Modifier.PUBLIC, "int");

        try {
            Object mbrshp = membershipClass.newInstance();
            @SuppressWarnings("unchecked")
            PositionalList<Object> m = (LinkedPositionalList<Object>) mbrList.get(mbrshp);
            if (m == null) {
                fail("constructor failed to initialize mbrList");
            }
            if (!(m instanceof PositionalList)) {
                fail("mbrList is not an positionallist.PositionalList");
            }
            if (m.size() != 0) {
                fail("mbrList is not empty right after construction");
            }
            String testName1 = "Test Name 1";
            Object mbr = null;
            try {
                mbr = addMember.invoke(mbrshp, testName1, 1);
            } catch (InvocationTargetException e1) {
                Throwable e2 = (Exception) e1.getCause();
                if (e2.getClass().equals(illegalArgumentExceptionClass.getClazz())) {
                    fail("addMember is using the wrong PositionalList add method");
                }
                unexpected(e2);
            }
            if (mbr == null || !testName1.equals(getName.invoke(mbr))) {
                fail("addMember did not return a Member with the correct name");
            }
            if ((int) getYear.invoke(mbr) != 1) {
                fail("addMember did not return a Member with the correct year");
            }
            if (m.size() != 1) {
                fail("addMember failed to add member 1");
            }
            mbr = addMember.invoke(mbrshp, "Test Name 2", 2);
            if (m.size() != 2) {
                fail("addMember failed to add member 2");
            }
            if (m.last().getElement() != mbr) {
                fail("addMember is not adding members to the list in the order specified in the requirements");
            }
        } catch (Exception e) {
            unexpected(e);
        }
    }
}
