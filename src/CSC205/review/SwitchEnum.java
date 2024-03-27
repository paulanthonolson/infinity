package review;

// See IfEnum for the same logic using if/else

public class SwitchEnum {
    public static void main(String[] args) {
        Planet p;

        p = Planet.PLUTO;

        switch (p) {
            case MERCURY:
            case VENUS:
                System.out.println(p + " is between the Sun and the Earth");
                break;
            case EARTH:
                System.out.println(p + " is the Earth");
                break;
            default:
                System.out.println(p + " is not between the Sun and the Earth");
        }
    }
}
