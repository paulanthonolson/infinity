package cscmatchtest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test20 extends TestCore {
	private Method getName;
	private Method getScore;
	private Method getOtherMbr;
	private boolean getOtherMbrFailed = false;

	public static void main(String[] args) {
		new Test20().runTests();
	}

	public void runTests() {
		new Test19().runTests();
		startTests();
		try {
			testCompatibility();
		} catch (TestExit e) {
		}
		summarizeTests();
	}

	public void testCompatibility() {
		TestClass tc = compatibilityClass;
		Method addInterest;
		Object mbrA;
		Object mbrB;
		Object mbrC;

		requiredClass(tc);
		requiredVariable(tc, "score", Modifier.PRIVATE, "int");
		requiredVariable(tc, "otherMbr", Modifier.PRIVATE, "cscmatch.Member");
		getScore = requiredMethod(compatibilityClass, "getScore", Modifier.PUBLIC, "int");
		getOtherMbr = requiredMethod(compatibilityClass, "getOtherMbr", Modifier.PUBLIC, "cscmatch.Member");
		requiredInterface(tc, "java.lang.Comparable<cscmatch.Compatibility>");

		requiredClass(memberClass);
		requiredClass(interestClass);
		addInterest = requiredMethod(memberClass, "addInterest", Modifier.PUBLIC, "cscmatch.Interest", String.class,
				int.class);
		getName = requiredMethod(memberClass, "getName", Modifier.PUBLIC, "String");

		try {
			mbrA = memberClass.newInstance("A", 1);
			mbrB = memberClass.newInstance("B", 2);
			mbrC = memberClass.newInstance("C", 3);

			addInterest.invoke(mbrA, "T1", 2);
			addInterest.invoke(mbrA, "T2", 3);
			addInterest.invoke(mbrA, "T3", 5);

			addInterest.invoke(mbrB, "T1", 5);
			addInterest.invoke(mbrB, "T3", 3);
			addInterest.invoke(mbrB, "T4", 7);
			addInterest.invoke(mbrB, "T5", 1);
			addInterest.invoke(mbrB, "T6", 9);

			addInterest.invoke(mbrC, "T1", 5);
			addInterest.invoke(mbrC, "T2", 10);

			testScore(mbrA, mbrB, 32);
			testScore(mbrA, mbrC, 40);
			testScore(mbrB, mbrA, 26);
			testScore(mbrB, mbrC, 30);
			testScore(mbrC, mbrA, 42);
			testScore(mbrC, mbrB, 33);
		} catch (Exception e) {
			unexpected(e);
		}
	}

	public void testScore(Object my, Object other, int expected) {
		try {
			Object c = compatibilityClass.newInstance(my, other);
			Object g = getOtherMbr.invoke(c);
			if (g != other && !getOtherMbrFailed) {
				getOtherMbrFailed = true;
				if (g == null) {
					fail("getOtherMbr returned null; must  return value provided to constructor");
				} else {
					fail("getOtherMbr did not return value provided to constructor");
				}
			}
			int actual = (int) getScore.invoke(c);
			if (actual != expected) {
				fail("score from " + getName.invoke(my) + " to " + getName.invoke(other) + " expected " + expected
						+ " got " + actual);
			} else {
				pass("score from " + getName.invoke(my) + " to " + getName.invoke(other) + " correct at " + actual);
			}
		} catch (TestExit e) {
			// ignore failure exit request
		} catch (Exception e) {
			try {
				unexpected(e);
			} catch (TestExit e2) {
				// ignore failure exit request
			}
		}
	}
}
