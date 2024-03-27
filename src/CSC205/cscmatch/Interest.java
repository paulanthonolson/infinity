package cscmatch;

import java.io.Serializable;

public class Interest implements Comparable<Interest>, Serializable {
    public static final int MIN_LEVEL = 0;
    public static final int MAX_LEVEL = 10;
    private String topic;
    private int level;

    public Interest(String topic, int level) {
        setTopic(topic);
        setLevel(level);

    }

    public static String validateTopic(String topic) {
        if (topic == null) {
            return "Name may not be null";
        }
        if (topic.isBlank()) {
            return "Name may not be blank";
        }
        return null;

    }

    public static String validateLevel(int level) {
        if (level < MIN_LEVEL || level > MAX_LEVEL) {
            return "Level " + level +
                    " is invalid; please specify between " +
                    MIN_LEVEL + "-" + MAX_LEVEL;
        }
        return null;
    }

    public void setTopic(String topic) {
        String errMsg = validateTopic(topic);
        if (errMsg != null) {
            throw new IllegalArgumentException(errMsg);
        }
        this.topic = topic;
    }

    public void setLevel(int level) {
        String errMsg = validateLevel(level);
        if (errMsg != null) {
            throw new IllegalArgumentException(errMsg);
        }
        this.level = level;
    }

    public String getTopic() {
        return topic;
    }

    public int getLevel() {
        return level;
    }

    public String toString() {

        String result = "Topic: " + topic + ", Level: " + level;
        return result;
    }

    public int compareTo(Interest otherIntr) {
        int result;
        result = otherIntr.level - this.level;
        if (result == 0) {
            result = this.topic.compareTo(otherIntr.topic);
        }
        return result;
    }

}
