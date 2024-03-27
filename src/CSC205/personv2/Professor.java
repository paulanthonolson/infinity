package personv2;

public class Professor extends Person {
    private String employeeID;
    private String department;

    public Professor(String name, String phoneNumber, String employeeID, String department) {
        super(name, phoneNumber);
        setEmployeeID(employeeID);
        setDepartment(department);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeID(String employeeID) {
        if (employeeID == null) {
            System.out.println("employeeID must not be null");
            this.employeeID = "***invalid***";
        } else if (employeeID.length() != 9 || !employeeID.startsWith("E")) {
            System.out.println("employeeID must be 9 characters long and start with E");
            this.employeeID = "***invalid***";
        } else {
            this.employeeID = employeeID;
        }
    }

    public void setDepartment(String department) {
        if (department == null) {
            System.out.println("department must not be null");
            this.department = "***invalid***";
        } else if (department.equals("") || department.equalsIgnoreCase("None")) {
            System.out.println("department must not be blank or any form of the word None");
            this.department = "***invalid***";
        } else {
            this.department = department;
        }
    }

    @Override
    public String toString() {
        String result;
        // super.toString() calls the toString method of Person.java that creates
        // the "Name: Pat Smith" part of the response, so we only have to plug in the
        // Professor-specific piece.
        result = super.toString() + " - Employee ID " + employeeID + " - Department - " + department;
        return result;
    }
}
