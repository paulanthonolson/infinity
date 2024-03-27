package searchsort;

public class Sorting {
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int min;

        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }
            swap(data, min, index);
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;

            // shift larger values to the right
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }

            data[position] = key;
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        int position, scan;

        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] data) {
        // Create a shared temporary array to use across all merges
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[data.length];
        mergeSort(data, temp, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, T[] temp, int min,
            int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(data, temp, min, mid);
            mergeSort(data, temp, mid + 1, max);
            merge(data, temp, min, mid, max);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] data, T[] temp, int first, int mid,
            int last) {
        int first1 = first, last1 = mid; // endpoints of first subarray
        int first2 = mid + 1, last2 = last; // endpoints of second subarray
        int index = first1; // next index open in temp array

        // Copy smaller item from each subarray into temp until one
        // of the subarrays is exhausted
        while (first1 <= last1 && first2 <= last2) {
            if (data[first1].compareTo(data[first2]) < 0) {
                temp[index] = data[first1];
                first1++;
            } else {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }

        // Copy remaining elements from first subarray, if any
        while (first1 <= last1) {
            temp[index] = data[first1];
            first1++;
            index++;
        }

        // Copy remaining elements from second subarray, if any
        while (first2 <= last2) {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        // Copy merged data into original array
        for (index = first; index <= last; index++)
            data[index] = temp[index];
    }

    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
        if (min < max) {
            // create partitions
            int indexofpartition = partition(data, min, max);

            // sort the left partition (lower values)
            quickSort(data, min, indexofpartition - 1);

            // sort the right partition (higher values)
            quickSort(data, indexofpartition + 1, max);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
        T partitionelement;
        int left, right;
        int middle = (min + max) / 2;

        // use the middle data value as the partition element
        partitionelement = data[middle];
        // move it out of the way for now
        swap(data, middle, min);

        left = min;
        right = max;

        while (left < right) {
            // search for an element that is > the partition element
            while (left < right && data[left].compareTo(partitionelement) <= 0) {
                left++;
            }

            // search for an element that is < the partition element
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }

            // swap the elements
            if (left < right) {
                swap(data, left, right);
            }
        }

        // move the partition element into place
        swap(data, min, right);

        return right;
    }
}
