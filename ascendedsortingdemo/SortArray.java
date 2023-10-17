package ascendedsortingdemo;
// Class for sorting an array of comparable objects.

public class SortArray {

    /** Sorts the first n objects in ascending order
     * @param a An array of comparable objects
     * @param n An integer > 0.
     */

    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n){
            for (int i = 0; i < n-1; i++) {
                int indexOfNextSmallest = getIndexOfSmallest(a, i, n -1);
                swap(a, i, indexOfNextSmallest);

            }              
                            
        

    }
    // Insertion sort implemented recursively for generic type.
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
        if (first < last) {
            // sort all but the last entry
            insertionSort(a, first, last -1);
            insertInOrder(a[last], a, first, last-1);
        }
    }
    // Recursive insert in Order method for generic Types
    private static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] a, int begin, int end){
        if (a[end].compareTo(anEntry) < 1) {
            a[end + 1] = anEntry;
        } else if (begin < end) {
            a[end + 1] = a[end];
            insertInOrder(anEntry, a, begin, end -1);
        } else {
            a[end + 1] = a[end];
            a[end] = anEntry;
        }
        
    }

    
    

    // Generic typing for comparable objects
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first]; // Type min is first assigned to the first index of the array
        int indexOfMin = first; // First array index starts as the lowest

        // Loop through the array, ahead of the first location and check for relational conditions
        
        for ( int index = first + 1; index <= last; index++) {
            // If the comparison to minimum returns -1(less than) than the assignment to minimum changes.
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }


    private static void swap(Object[] a, int i, int j) {
        // Temp storage, swap assignments, restore temp value to new index position. Swap completed
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
