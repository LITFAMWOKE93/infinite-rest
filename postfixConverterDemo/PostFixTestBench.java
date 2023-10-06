package postfixConverterDemo;

import java.util.Scanner;



public class PostFixTestBench extends PostFixConverter {

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test getPrecedence method
        System.out.println("Enter an operator to get its precedence: ");
        char operator = scanner.next().charAt(0);
        int precedence = PostFixConverter.getPrecedence(operator);
        System.out.println("Precedence of " + operator + ": " + precedence);

        // Test convertToPostfix method
        System.out.println("Enter an infix expression to convert to postfix: ");
        scanner.nextLine(); // Consume the newline character left by nextInt() or nextChar()
        String infixExpression = scanner.nextLine();
        String postfixExpression = PostFixConverter.convertToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);

        
    }
}