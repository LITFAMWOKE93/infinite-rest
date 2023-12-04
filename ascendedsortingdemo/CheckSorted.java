package ascendedsortingdemo;

public class CheckSorted<T extends Comparable<T>> {

    public static <T extends Comparable<? super T>> boolean isSortedAscending(T[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            // If the current element is smaller than the previous one, not sorted
            if (array[i].compareTo(array[i-1]) < 0) {
                return false;
            }
        }

        return true;
    }
    
}
