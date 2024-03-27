// See SwitchEnum for the same logic using switch/case

package review;

public class IfEnum {
    public static void main(String[] args) {
        Planet p;

        p = Planet.PLUTO;

        if (p == Planet.PLUTO || p == Planet.VENUS) {
            System.out.println(p + " is between the Sun and the Earth");
        } else if (p == Planet.EARTH) {
            System.out.println(p + " is the Earth");
        } else {
            System.out.println(p + " is not between the Sun and the Earth");
        }
    }
}
