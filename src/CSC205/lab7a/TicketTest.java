package lab7a;

import positionallist.*;

public class TicketTest {
    public static void main(String[] args) {
        PositionalList<Ticket> list = new LinkedPositionalList<>();

        list.addOrdered(new Ticket('C', 17));
        list.addOrdered(new Ticket('C', 15));
        list.addOrdered(new Ticket('G', 10));
        list.addOrdered(new Ticket('G', 8));
        list.addOrdered(new Ticket('A', 1));
        list.addOrdered(new Ticket('A', 5));
        list.addOrdered(new Ticket('B', 2));
        list.addOrdered(new Ticket('B', 13));

        for (Ticket t : list) {
            System.out.println(t);
        }
    }

}
