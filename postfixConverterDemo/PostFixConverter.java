package postfixConverterDemo;

import java.util.Stack;
import java.util.Locale;

public class PostFixConverter {

    public static String convertToPostfix(String infix) {

        infix = infix.toLowerCase(Locale.ROOT);

        Stack<Character> opStack = new Stack<>();

        StringBuilder postFix = new StringBuilder();




        while (!infix.isEmpty()) {

           char nextChar = infix.charAt(0);

           switch (nextChar) {

            // common math variables, could be rebuilt to be a list that is search for any of those values
            case 'a' : case 'b' : case 'c' : case 'x' : case 'y':
            postFix.append(nextChar);
            break;


            case '^':
            opStack.push(nextChar);
            break;

            case '+' : case '-' : case '*' : case '/' :
            // precedence of nextChar is <= pecedence of opStack.peek()
            while (!opStack.isEmpty() && getPrecedence(opStack.peek()) >= getPrecedence(nextChar))

            {
                postFix.append(opStack.peek());
                opStack.pop();
            }
            opStack.push(nextChar);
            break;

            case '(': 
            opStack.push(nextChar);
            break;

            case ')':
            char TOPerator = opStack.pop();
            while (TOPerator != '(') {
                postFix.append(TOPerator);
                TOPerator = opStack.pop();
            }
            break;

            default: break; //ignore unexpected characters
           }

           infix = infix.substring(1);
        }
        while (!opStack.isEmpty()) {
            char TOPerator = opStack.pop();
            postFix.append(TOPerator);


        }

     return postFix.toString();
    }


    protected static int getPrecedence(char operator) {

        // Create a value of precedence for the operators so they can be used to control stacking order
        switch(operator) {

            case '*' : case '/': 
            return 2;

            case '+': case '-' :
            return 1;

            default:
                return 0;
        }
    }
    
}
