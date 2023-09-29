package misc;

public class Bisection {
    static final double EPSILON = 0.000001; // Tolerance for accuracy
    
    // Function 1: 1000 * n^2
    static double function1(double n) {
        return 1000 * n * n;
    }
    
    // Function 2: 2^n
    static double function2(double n) {
        return Math.pow(2, n);
    }
    
    // Bisection method implementation
    static double bisection(double a, double b) {
        if (function1(a) - function2(a) > 0 || function1(b) - function2(b) > 0) {
            System.out.println("Invalid initial points.");
            return Double.NaN;
        }
        
        double c = a;
        while ((b - a) >= EPSILON) {
            // Find middle point
            c = (a + b) / 2;
            
            // If the root is found or the approximation is within the tolerance
            if (Math.abs(function1(c) - function2(c)) < EPSILON) {
                break;
            } else if ((function1(c) - function2(c)) * (function1(a) - function2(a)) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return c;
    }
    
    public static void main(String[] args) {
        double a = -1; // Initial point 'a'
        double b = 1; // Initial point 'b' (adjust based on expected range)
        
        double root = bisection(a, b);
        if (!Double.isNaN(root)) {
            System.out.println("Intersection point is approximately: " + root);
        }
    }
}