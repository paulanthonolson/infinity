package map;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Map<String, Integer> variables = new HashMap<>();
        // Map<String, Integer> variables = new TreeMap<>();
        while (true) {
            System.out.println("Enter key or quit to stop:");
            String key = scnr.next();
            if (key.equalsIgnoreCase("quit")) {
                break;
            }
            if (variables.containsKey(key)) {
                System.out.println(key + " = " + variables.get(key));
            } else {
                System.out.println("Enter value:");
                int value = scnr.nextInt();
                variables.put(key, value);
            }
        }

        // Using Map.Entry to iterate over all elements of a Map
        for (Map.Entry<String, Integer> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}