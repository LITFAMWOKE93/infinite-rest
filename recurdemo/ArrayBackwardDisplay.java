package recurdemo;

public class ArrayBackwardDisplay {

    // Recursive method to display a portion of the array backward
    public static void displayArrayBackward(int[] arr, int startIndex, int endIndex) {
        // Base case: if startIndex is greater than endIndex, return
        if (startIndex > endIndex) {
            return;
        } else {
            // Recursive case: display the element at endIndex, then recursively call
            // the method with updated endIndex (moving towards the start of the portion)
            System.out.print(arr[endIndex] + " ");
            displayArrayBackward(arr, startIndex, endIndex - 1);
        }
    }
    
}



