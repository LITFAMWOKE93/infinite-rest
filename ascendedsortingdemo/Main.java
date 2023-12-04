package ascendedsortingdemo;


public class Main {

    public static void main(String[] args) {
        // Wrapper class allows use of generic types with primitive data types.
        System.out.println("Building Integer array. . .");
        Integer[] numbers = {6, 7, 3, 9, 5, 1, 2, 8, 4, 10};
        
        if (CheckSorted.isSortedAscending(numbers)) {
            System.out.println("Array: ");
            for (Integer num: numbers) {
                System.out.print(num + ",");
            }
            System.out.println("\n" + "is assorted in ascending order.");
        } else {
            System.out.println("The array is not sorted");
        }

        System.out.println("Attempting selection sort");
        SortArray.selectionSort(numbers, 10);
        

        if (CheckSorted.isSortedAscending(numbers)) {
            System.out.println("Array: ");
            for (Integer num: numbers) {
                System.out.print(num + ",");
            }
            System.out.println("\n" + "is assorted in ascending order.");
        } else {
            System.out.println("The array is not sorted");
        }
        
        


    }
    
}
