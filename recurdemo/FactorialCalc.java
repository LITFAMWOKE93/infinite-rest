package recurdemo;

public class FactorialCalc {

    // Use an input, which is essential for a recursive method
    public static long calculateFactorial(int n) {

        // Base case is need to prevent infinite recursion
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        // The recursive case is how we break the problem down into smaller sub sets.
        // Recursive case: n! = n * (n-1)!
        else {
            return n * calculateFactorial(n - 1);
        }
    }


}