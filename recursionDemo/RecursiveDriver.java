package recursionDemo;

import java.util.Scanner;
import recursionDemo.RecursiveProduct;


public class RecursiveDriver {

    // Driver program    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Please enter five integer values:");

        // Loop for assigning the scanner value to the integer array
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }



        int product = RecursiveProduct.calculateProduct(numbers, 0);
        System.out.println("Product of the numbers: " + product);
    }
}