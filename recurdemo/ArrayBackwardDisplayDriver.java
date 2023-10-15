package recurdemo;

public class ArrayBackwardDisplayDriver {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int startIndex = 2; // Start index of the portion
        int endIndex = 6;   // End index of the portion

        System.out.println("Array portion displayed backward:");
        ArrayBackwardDisplay.displayArrayBackward(array, startIndex, endIndex);
    }
    
}
