package lab7a;

import positionallist.*;

public class BookTest {
    // These are the test titles
    // L'Enfant
    // Les Nessman: My Time at WKRP
    // Les Misérables
    // Der Vorleser
    // A Wrinkle in Time

    public static void main(String[] args) {
        PositionalList<Book> list = new LinkedPositionalList<>();

        // Create list.addOrdered(new Book(...)) statements here for each book.

        for (Book b : list) {
            System.out.println(b);
        }
    }

}
