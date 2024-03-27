package searchsort;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class SortPhoneList2 {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        double duration1, duration2, duration3, duration4, duration5, duration6; // Duration in milliseconds
        final double NANO_TO_MS = 1.0 / 1_000_000.0;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many contacts? ");
        int numContacts = keyboard.nextInt();
        keyboard.close();

        Contact[] friends = new Contact[numContacts];

        for (int i = 0; i < numContacts; i++)
            friends[i] = new Contact(getFirstName(), getLastName(), getPhoneNumber(), getPriority());

        Contact[] friends1 = Arrays.copyOf(friends, friends.length);
        Contact[] friends2 = Arrays.copyOf(friends, friends.length);
        Contact[] friends3 = Arrays.copyOf(friends, friends.length);
        Contact[] friends4 = Arrays.copyOf(friends, friends.length);
        Contact[] friends5 = Arrays.copyOf(friends, friends.length);
        Contact[] friends6 = Arrays.copyOf(friends, friends.length);

        startTime = System.nanoTime();
        Sorting.selectionSort(friends1);
        endTime = System.nanoTime();
        duration1 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds

        startTime = System.nanoTime();
        Sorting.insertionSort(friends2);
        endTime = System.nanoTime();
        duration2 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds

        startTime = System.nanoTime();
        Sorting.bubbleSort(friends3);
        endTime = System.nanoTime();
        duration3 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds

        startTime = System.nanoTime();
        Sorting.mergeSort(friends4);
        endTime = System.nanoTime();
        duration4 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds

        startTime = System.nanoTime();
        Sorting.quickSort(friends5);
        endTime = System.nanoTime();
        duration5 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds

        startTime = System.nanoTime();
        Arrays.sort(friends6);
        endTime = System.nanoTime();
        duration6 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds

        if (friends1.length <= 100) {
            System.out.println("Sorted List\n===========\n");
            for (Contact friend1 : friends1)
                System.out.println(friend1);
        }
        // Print results
        System.out.println("\nTiming Results\n==============\n");
        System.out.printf("Selection Sort: %11.2fms\n", duration1);
        System.out.printf("Insertion Sort: %11.2fms\n", duration2);
        System.out.printf("Bubble Sort   : %11.2fms\n", duration3);
        System.out.printf("Merge Sort    : %11.2fms\n", duration4);
        System.out.printf("Quick Sort    : %11.2fms\n", duration5);
        System.out.printf("Arrays.sort() : %11.2fms\n", duration6);
    }

    // Pick a specific seed for the random number generator
    // to get consistent results for given number of contacts.
    static Random randGen = new Random(0);

    private static String getFirstName() {
        return firstNames[randGen.nextInt(firstNames.length)];
    }

    private static String getLastName() {
        return lastNames[randGen.nextInt(lastNames.length)];
    }

    private static String getPhoneNumber() {
        return String.format("(%03d) %03d-%04d", randGen.nextInt(800) + 200, randGen.nextInt(800) + 200,
                randGen.nextInt(10000));
    }

    private static int getPriority() {
        return randGen.nextInt(10);
    }

    // Top 250 first names at EMCC in Spring 2019 order by most to least popular
    private static String[] firstNames = { "Michael", "Jessica", "Maria", "David", "Daniel", "Jennifer", "Christopher",
            "Ashley", "Jose", "Anthony", "Joshua", "Stephanie", "Matthew", "Elizabeth", "Alexis", "Joseph", "Jacob",
            "Melissa", "Samantha", "Robert", "Amanda", "Sarah", "Jonathan", "Andrew", "Vanessa", "James", "John",
            "Jesus", "Nicole", "Brandon", "Michelle", "Nicholas", "Andrea", "Ryan", "Emily", "Luis", "Victoria",
            "Alyssa", "Juan", "Kevin", "Taylor", "Christian", "Eric", "Tyler", "Carlos", "Kimberly", "William",
            "Brianna", "Justin", "Brittany", "Alexander", "Cynthia", "Danielle", "Aaron", "Jordan", "Diana",
            "Christina", "Jason", "Steven", "Angel", "Megan", "Rebecca", "Zachary", "Crystal", "Monica", "Rachel",
            "Amber", "Brian", "Jasmine", "Karen", "Patricia", "Kyle", "Angelica", "Richard", "Laura", "Kayla",
            "Heather", "Gabriel", "Ana", "Angela", "Adrian", "Jorge", "Lisa", "Brenda", "Hannah", "Amy", "Lauren",
            "Alexandra", "Miguel", "Tiffany", "Veronica", "Mark", "Natalie", "Austin", "Jacqueline", "Sandra", "Adam",
            "Guadalupe", "Alicia", "Marissa", "Madison", "Nathan", "Sara", "Benjamin", "Thomas", "Timothy", "Francisco",
            "Gabriela", "Leslie", "Victor", "Bryan", "Samuel", "Erika", "Mary", "Kelly", "Adriana", "Jesse",
            "Alejandro", "Antonio", "Sean", "Nancy", "Ricardo", "Alex", "Paul", "Daisy", "Denise", "Valerie",
            "Cassandra", "Alejandra", "Courtney", "Jeremy", "Oscar", "Manuel", "Sabrina", "Charles", "Claudia",
            "Destiny", "Karina", "Erica", "Karla", "Anna", "Briana", "Eduardo", "Rosa", "Bianca", "Katherine", "Javier",
            "Kenneth", "Shannon", "Susan", "Cody", "Olivia", "Isaac", "Abigail", "Desiree", "Jeffrey", "Jamie", "Jared",
            "Joel", "April", "Morgan", "Jazmin", "Julie", "Linda", "Marcus", "Mariah", "Martin", "Sergio", "Christine",
            "Gregory", "Julia", "Mario", "Omar", "Fernando", "Mayra", "Dominique", "Ivan", "Andres", "Kaitlyn",
            "Roberto", "Scott", "Sierra", "Daniela", "Isaiah", "Patrick", "Priscilla", "Cindy", "Dylan", "Jocelyn",
            "Savannah", "Yesenia", "Breanna", "Cesar", "Emma", "Erin", "Edgar", "Gabriella", "Ariana", "Chelsea",
            "Erik", "Monique", "Stephen", "Cristina", "Hector", "Ruben", "Deborah", "Jaime", "Kristen", "Wendy",
            "Brooke", "Isabel", "Cameron", "Sydney", "Devin", "Evelyn", "Haley", "Sonia", "Edward", "Martha",
            "Alexandria", "Alma", "Derek", "Nathaniel", "Raul", "Frank", "Gloria", "Joanna", "Logan", "Sophia",
            "Teresa", "Vincent", "Raymond", "Shelby", "Alan", "Alondra", "Barbara", "Gabrielle", "Hailey", "Mia",
            "Shawn", "Xavier", "Elijah", "Ethan", "Valeria", "Lindsey", "Melanie", "Blanca", "Carmen", "Esmeralda",
            "Julian" };

    // Top 250 last names at EMCC in Spring 2019 order by most to least popular
    private static String[] lastNames = { "Garcia", "Hernandez", "Lopez", "Martinez", "Rodriguez", "Gonzalez", "Smith",
            "Johnson", "Perez", "Sanchez", "Ramirez", "Williams", "Brown", "Chavez", "Jones", "Flores", "Torres",
            "Gutierrez", "Davis", "Ruiz", "Morales", "Nguyen", "Ortiz", "Miller", "Moreno", "Gomez", "Reyes", "Diaz",
            "Mendoza", "Rivera", "Gonzales", "Alvarez", "Wilson", "Anderson", "Castillo", "Jimenez", "Romero", "Taylor",
            "Herrera", "Valdez", "Ortega", "Thomas", "Moore", "Thompson", "Castro", "Ramos", "Medina", "Soto", "Cruz",
            "Clark", "Espinoza", "Vargas", "Salazar", "Vasquez", "Aguilar", "Harris", "Jackson", "Munoz", "Marquez",
            "Valenzuela", "White", "Mitchell", "Fernandez", "Robinson", "Avila", "Martin", "Sandoval", "Mendez", "Tran",
            "Guzman", "Rios", "Scott", "Nunez", "Green", "Wright", "Estrada", "Acosta", "Lewis", "Hill", "Vazquez",
            "Young", "Lee", "Carrillo", "Hall", "Walker", "Baker", "Contreras", "Rivas", "Robles", "Adams", "Dominguez",
            "Padilla", "Vega", "Delgado", "Navarro", "Nelson", "Allen", "Figueroa", "Stewart", "Alvarado", "Silva",
            "Valencia", "Felix", "Guerrero", "Molina", "Rojas", "Phillips", "Howard", "King", "Orozco", "Pena", "James",
            "Rogers", "Villa", "Aguirre", "Castaneda", "Edwards", "Cervantes", "Cordova", "Campbell", "Campos",
            "Collins", "Enriquez", "Le", "Ochoa", "Watson", "Beltran", "Hughes", "Montoya", "Solis", "Luna", "Carter",
            "Cook", "Bailey", "Gray", "Madrid", "Parra", "Ross", "Arroyo", "Franco", "Macias", "Mejia", "Russell",
            "Gallegos", "Sanders", "Turner", "Ayala", "Garza", "Brooks", "Maldonado", "Zamora", "Cabrera", "Parker",
            "Price", "Reed", "Roberts", "Jenkins", "Jordan", "Lara", "Long", "Meza", "Cox", "Duran", "Evans", "Juarez",
            "Trujillo", "Villalobos", "Alexander", "Bell", "Murphy", "Richardson", "Tapia", "Camacho", "Coleman",
            "Perry", "Ponce", "Cole", "Hunt", "Ibarra", "Leon", "Nava", "Calderon", "Foster", "Mercado", "Miranda",
            "Rosales", "Santos", "Serrano", "Stevens", "Cano", "Escobedo", "Lugo", "Marshall", "Murillo", "Quintero",
            "Roman", "Cooper", "Ellis", "Henderson", "Henry", "Webb", "Barajas", "Duarte", "Galindo", "Gamez", "Morris",
            "Pacheco", "Peterson", "Pina", "West", "Rocha", "Singh", "Wood", "Barraza", "Carroll", "Cisneros", "Graham",
            "Rangel", "Salas", "Barrera", "Bryant", "Butler", "Carrasco", "Fuentes", "Porter", "Powell", "Santiago",
            "Wallace", "Ward", "Washington", "Armstrong", "Barnes", "Cardenas", "Carranza", "Corona", "Magana",
            "McDonald", "Morgan", "Olivas", "Olson", "Velazquez", "Wheeler", "Bennett", "Cortez", "Holmes", "Montes",
            "Nevarez", "Patterson", "Simpson", "Wells" };
}
