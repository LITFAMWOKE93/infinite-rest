package recurdemo;


public class FactorialDriver {

    public static void main(String[] args) {

        
        long facNum = FactorialCalc.calculateFactorial(5);

        System.out.println("Performing factorial operations on: ");
        System.out.println(5);

        System.out.println("Factorial of given number is: ");
        System.out.println(facNum);

        
    }
}