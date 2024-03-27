package searchsort;

import java.util.Objects;

public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phone;
    private int priority;

    public Contact(String firstName, String lastName, String phone, int priority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.priority = priority;
    }

    public String toString() {
        return String.format("%d  %-24s  %s", priority, lastName + ", " + firstName, phone);
    }

    public int compareTo(Contact otherContact) {
        int result;

        result = priority - otherContact.priority;

        if (result == 0) {
            result = lastName.compareTo(otherContact.lastName);

            if (result == 0) {
                result = firstName.compareTo(otherContact.firstName);
            }
        }

        return result;
    }

    // The rest of this file demonstrates how to implement equals and hashCode.
    // It can be ignored for purposes of the Searching demos.

    // If you override equals, you should also override hashCode. Failure to
    // override both will cause inconsistent results when using the class with
    // collections that use hash tables such as LinkedHashMap.
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Contact) {
            Contact otherContact = (Contact) other;
            // Objects.equals(a, b) is equivalent to
            // (a == b) || (a != null && b != null && a.equals(b))
            result = priority == otherContact.priority &&
                    Objects.equals(lastName, otherContact.lastName) &&
                    Objects.equals(firstName, otherContact.firstName);
        }
        return result;
    }

    public int hashCode() {
        // Objects.hash provides a convenient way to compute a unique hash from a series
        // of values
        return Objects.hash(priority, lastName, firstName);
    }
}
