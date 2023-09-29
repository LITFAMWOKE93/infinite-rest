package misc;
import java.util.ArrayList;
import java.util.Random;

public class UniqueArrayExercise {


public static int[] generateUniqueArray(int n) {
    ArrayList<Integer> uniqueList = new ArrayList<>();

    // Create array with all values
    for (int i = 1; i <= n + 1; i ++) {
        uniqueList.add(i);
    }

    // Remove random value from array
    Random random = new Random();
    int randomIndex = random.nextInt(uniqueList.size());
    uniqueList.remove(randomIndex);

    // Convert list to array
    int[] uniqueArray = new int[uniqueList.size()];


    // Array assignment 
    for (int i = 0; i < uniqueList.size(); i ++) {
        uniqueArray[i] = uniqueList.get(i);
    }

    return uniqueArray;

}

public static int findMissingInteger(int[] array) {
    int n = array.length + 1;

    for (int i = 1; i <= n; i++) {
        boolean found = false;
        for (int num : array) {
            if (num == i) {
                found = true;
                break;
            }
        }
        if (!found) {
            return i;
        }
    }

    // Invalid input return value
    return -1;
}

    public static void main(String[] args) {

        int n = 5;
        int[] uniqueArray = generateUniqueArray(n);

        int missingNum = findMissingInteger(uniqueArray);

        if (missingNum == -1) {
            System.out.print("Invalid array input");
        } else {
            System.out.print("Missing number is: " + missingNum);
        }
        
        
        
    
}
}
