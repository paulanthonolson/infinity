package cscmatch;

import positionallist.*;

import java.io.Serializable;
import java.util.Iterator;

public class Member implements Iterable<Interest>, Serializable {

    public static final int MIN_YEAR = 1;
    public static final int MAX_YEAR = 5;
    private String name;
    private int year;
    private PositionalList<Interest> intrList;

    public Member(String name, int year) {
        setName(name);
        setYear(year);
        intrList = new LinkedPositionalList<Interest>();
    }

    public static String validateName(String name) {
        if (name == null) {
            return "Name may not be null";
        }
        if (name.isBlank()) {
            return "Name may not be blank";
        }
        return null;
    }

    public static String validateYear(int year) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            return "Year " + year +
                    " is invalid; please specify between " +
                    MIN_YEAR + "-" + MAX_YEAR;
        }
        return null;
    }

    public void setName(String name) {
        String errMsg = validateName(name);
        if (errMsg != null) {
            throw new IllegalArgumentException(errMsg);
        }
        this.name = name;
    }

    public void setYear(int year) {
        String errMsg = validateYear(year);
        if (errMsg != null) {
            throw new IllegalArgumentException(errMsg);
        }
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Interest addInterest(String topic, int level) {
        Iterator<Interest> iter = intrList.iterator();

        while (iter.hasNext()) {
            Interest interest = iter.next();

            if (interest.getTopic().equals(topic)) {
                System.out.println("Topic '" + topic + "' already exists. Replaced '" + topic + "' with duplicate.");
                iter.remove();
            }
        }

        Interest interestObj = new Interest(topic, level);
        intrList.addOrdered(interestObj);

        return interestObj;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Name: " + name + ", Year: " + year + "\n");

        Iterator<Interest> iter = intrList.iterator();
        while (iter.hasNext()) {
            Interest interest = iter.next();

            result.append("  ").append(interest.getTopic()).append(": ").append(interest.getLevel()).append("\n");
        }
        return result.toString();
    }

    public Iterator<Interest> iterator() {
        return intrList.iterator();
    }

    public Interest findInterest(String topic) {
        for (Interest iter : intrList) {
            if (iter.getTopic().equals(topic)) {
                return iter;
            }
        }
        return null;
    }

}
