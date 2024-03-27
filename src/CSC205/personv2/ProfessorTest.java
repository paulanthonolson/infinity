package personv2;

public class ProfessorTest {
	public static void main(String[] args) {
		Professor prof1;
		Professor prof2;
		Professor prof3;
		String testName1 = "Smith, Robin";
		String testPhone1 = "623-935-8000";
		String testID1 = "E12345678";
		String testDepartment1 = "IT";
		String testName2 = "Smith, Pat";
		String testID2 = "E98765432";
		String testDepartment2 = "Admin";
		int failed = 0;

		// Test constructor that requires only name and ID, omitting GPA
		prof1 = new Professor(testName1, testPhone1, testID1, testDepartment1);
		if (!prof1.getName().equals(testName1)) {
			System.out.println("prof1 constructor name expected " + testName1 + " got " + prof1.getName());
			failed++;
		}
		if (!prof1.getPhone().equals(testPhone1)) {
			System.out.println("prof1 constructor phone expected " + testPhone1 + " got " + prof1.getPhone());
			failed++;
		}
		if (!prof1.getEmployeeID().equals(testID1)) {
			System.out.println("prof1 constructor ID expected " + testID1 + " got " + prof1.getEmployeeID());
			failed++;
		}
		if (!prof1.getDepartment().equals(testDepartment1)) {
			System.out.println("prof1 constructor department expected " + testDepartment1 + " got "
					+ prof1.getDepartment());
			failed++;

		}

		prof2 = new Professor(testName1, testPhone1, testID1, testDepartment1);
		if (!prof2.getName().equals(testName1)) {
			System.out.println("prof2 constructor name expected " + testName1 + " got " + prof2.getName());
			failed++;
		}
		if (!prof2.getEmployeeID().equals(testID1)) {
			System.out.println("prof2 constructor ID expected " + testID1 + " got " + prof2.getEmployeeID());
			failed++;
		}
		if (!prof2.getDepartment().equals(testDepartment1)) {
			System.out.println(
					"prof2 constructor department expected " + testDepartment1 + " got "
							+ prof2.getDepartment());
			failed++;
		}

		prof2.setName(testName2);
		if (!prof2.getName().equals(testName2)) {
			System.out.println("prof2 setName expected " + testName2 + " got " + prof2.getName());
			failed++;
		}

		prof2.setPhone(null);
		if (prof2.getPhone() != null) {
			System.out.println("prof2 setPhone expected null got " + prof2.getPhone());
			failed++;
		}

		prof2.setEmployeeID(testID2);
		if (!prof2.getEmployeeID().equals(testID2)) {
			System.out.println("prof2 setName expected " + testID2 + " got " + prof2.getEmployeeID());
			failed++;
		}

		prof2.setDepartment(testDepartment2);
		if (!prof2.getDepartment().equals(testDepartment2)) {
			System.out.println(
					"prof2 setDepartment expected " + testDepartment2 + " got " + prof2.getDepartment());
			failed++;
		}

		System.out.println("prof2 toString returns " + prof2);

		System.out.println("Creating prof3 with all invalid data");
		prof3 = new Professor("Lizzo", "601-448-9535", null, "none");
		System.out.println(prof3);

		System.out.println(failed + " tests failed");
	}
}
