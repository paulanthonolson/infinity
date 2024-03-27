package personv2;

public class Student extends Person {
	private String studentID;
	private double gpa;

	public Student(String name, String phoneNumber, String studentID, double gpa) {
		// Call the constructor of our superclass (Person) to set the name and phone
		// number.
		super(name, phoneNumber);
		// If the class includes setters to change values, best practice is to call
		// the setters instead of including validation code in the constructor since the
		// same logic is needed for both.
		setStudentID(studentID);
		setGpa(gpa);
	}

	public String getStudentID() {
		return studentID;
	}

	public double getGpa() {
		return gpa;
	}

	public void setStudentID(String studentID) {
		if (studentID == null) {
			System.out.println("studentID must not be null");
			this.studentID = "***invalid***";
		} else if (studentID.length() != 8 || !studentID.startsWith("3")) {
			System.out.println("studentID must start with 3 and be 8 characters long");
			this.studentID = "***invalid***";
		} else {
			this.studentID = studentID;
		}
	}

	public void setGpa(double gpa) {
		if (gpa < 0 || gpa > 4) {
			System.out.println("GPA must be between 0-4");
			gpa = 0;
		} else {
			this.gpa = gpa;
		}
	}

	@Override
	public String toString() {
		String result;
		// super.toString() calls the toString method of Person.java that creates
		// the "Name: Pat Smith - Phone: 602-555-1212" part of the response, so we only
		// have to plug in the Student-specific piece.
		result = super.toString() + " - Student ID: " + studentID + " - GPA: " + gpa;
		return result;
	}
}
