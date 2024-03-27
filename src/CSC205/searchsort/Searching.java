package searchsort;

public class Searching {
    public static <T> boolean linearSearch(T[] data, int min, int max, T target) {
        boolean found = false;

        for (int index = min; !found && index <= max; index++) {
            found = data[index].equals(target);
        }

        return found;
    }

    public static <T extends Comparable<T>> boolean binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        int mid;
        int compare;

        if (min <= max) {
            mid = (min + max) / 2; // determine the midpoint
            compare = data[mid].compareTo(target);
            if (compare == 0) {
                found = true;
            } else if (compare > 0) { // data value > target, search left half
                found = binarySearch(data, min, mid - 1, target);
            } else { // data value < target, search right half
                found = binarySearch(data, mid + 1, max, target); // search right half
            }
        }

        return found;
    }
}
