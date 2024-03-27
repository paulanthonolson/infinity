package review;

import java.util.Scanner;

// Warning: This program has a bug. Can you find and fix it?

public class WhileSwitchTrafficLight {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String color;
        String action;

        do {
            System.out.print("Enter a traffic light color, red to stop: ");
            color = scnr.nextLine();

            switch (color) {
                case "green":
                    action = "go";
                    break;
                case "red":
                    action = "stop";
                    break;
                case "yellow":
                    action = "go very very fast";
                    break;
                default:
                    action = "you need an eye exam";
            }
            System.out.println(color + " light " + action);
        } while (color != "red");

        scnr.close();
    }

}
