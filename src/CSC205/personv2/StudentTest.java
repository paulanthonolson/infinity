package personv2;

public class StudentTest {
    public static void main(String[] args) {
        Student stu1;
        Student stu2;
        Student stu3;
        String testName1 = "Smith, Robin";
        String testPhone1 = "602-555-1212";
        String testID1 = "32345678";
        double testGpa1 = 0;
        String testName2 = "Smith, Pat";
        String testID2 = "39876543";
        double testGpa2 = 4.0;
        int failed = 0;

        stu1 = new Student(testName1, testPhone1, testID1, testGpa1);
        if (!stu1.getName().equals(testName1)) {
            System.out.println("stu1 constructor name expected " + testName1 + " got " + stu1.getName());
            failed++;
        }
        if (!stu1.getPhone().equals(testPhone1)) {
            System.out.println("stu1 constructor name expected " + testName1 + " got " + stu1.getName());
            failed++;

        }
        if (!stu1.getStudentID().equals(testID1)) {
            System.out.println("stu1 constructor ID expected " + testID1 + " got " + stu1.getStudentID());
            failed++;
        }
        if (stu1.getGpa() != testGpa1) {
            System.out.println("stu1 constructor GPA expected " + testGpa1 + " got " + stu1.getGpa());
            failed++;
        }

        stu2 = new Student(testName1, testPhone1, testID1, testGpa1);
        if (!stu2.getName().equals(testName1)) {
            System.out.println("stu2 constructor name expected " + testName1 + " got " + stu2.getName());
            failed++;
        }
        if (!stu2.getStudentID().equals(testID1)) {
            System.out.println("stu2 constructor ID expected " + testID1 + " got " + stu2.getStudentID());
            failed++;
        }
        if (stu2.getGpa() != testGpa1) {
            System.out.println("stu2 constructor GPA expected " + testGpa1 + " got " + stu2.getGpa());
            failed++;
        }

        // Test setters and getters
        stu2.setName(testName2);
        if (!stu2.getName().equals(testName2)) {
            System.out.println("stu2 setName expected " + testName2 + " got " + stu2.getName());
            failed++;
        }

        stu2.setPhone(null);
        if (stu2.getPhone() != null) {
            System.out.println("stu2 setPhone expected null got " + stu2.getName());
            failed++;
        }

        stu2.setStudentID(testID2);
        if (!stu2.getStudentID().equals(testID2)) {
            System.out.println("stu2 setName expected " + testID2 + " got " + stu2.getStudentID());
            failed++;
        }

        stu2.setGpa(testGpa2);
        if (stu2.getGpa() != testGpa2) {
            System.out.println("stu2 setGpa expected " + testGpa2 + " got " + stu2.getGpa());
            failed++;
        }

        System.out.println("stu2 toString returns " + stu2);

        System.out.println("Creating stu3 with all invalid data");
        stu3 = new Student(",", "", null, 5);
        System.out.println("stu3 toString returns " + stu3);

        System.out.println(failed + " tests failed");
    }
}
