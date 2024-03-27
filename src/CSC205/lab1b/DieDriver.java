package lab1b;

public class DieDriver {
    public static void main(String[] args) {

        Die d6 = new Die(1, 6);
        Die d10 = new Die(0, 9);

        System.out.println(d6.getValue());
        System.out.println(d10.getValue());
    }

}
