package personv2;

public abstract class Person {
	private String name;
	private String phone;

	public Person(String name, String phone) {
		setName(name);
		setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		if (name == null) {
			System.out.println("Name must not be null");
			this.name = "***invalid***";
		} else if (name.length() < 3) {
			System.out.println("Name must be at least 3 characters long");
			this.name = "***invalid***";
		} else if (!name.contains(",")) {
			System.out.println("Name must contain a comma");
			this.name = "***invalid***";
		} else {
			this.name = name;
		}
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public String toString() {
		String result;
		result = "Name: " + name;
		if (phone != null) {
			result += " - Phone Number: " + phone;
		}
		return result;
	}
}
