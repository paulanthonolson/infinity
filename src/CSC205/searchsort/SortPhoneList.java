package searchsort;

public class SortPhoneList {
    public static void main(String[] args) {
        Contact[] friends = new Contact[7];

        friends[0] = new Contact("John", "Smith", "610-555-7384", 9);
        friends[1] = new Contact("Sarah", "Barnes", "215-555-3827", 9);
        friends[2] = new Contact("Mark", "Riley", "733-555-2969", 1);
        friends[3] = new Contact("Laura", "Getz", "663-555-3984", 1);
        friends[4] = new Contact("Larry", "Smith", "464-555-3489", 9);
        friends[5] = new Contact("Frank", "Phelps", "322-555-2284", 1);
        friends[6] = new Contact("Marsha", "Grant", "243-555-2837", 5);

        Sorting.mergeSort(friends);

        for (Contact friend : friends)
            System.out.println(friend);
    }
}
