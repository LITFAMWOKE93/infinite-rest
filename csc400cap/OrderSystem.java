package csc400cap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display();
        // A purposeful infinite loop in which the main menu is always being called unless a system exit occurs. 
        while (true) {
            try {
                // Simple input menu for console application 
                System.out.println("Menu:");
                System.out.println("1. Add Order");
                System.out.println("2. Display Orders");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                // A switch case handles option selections
                switch (choice) {
                    case 1:
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.next();
                        System.out.print("Enter Order Number: ");
                        int orderNumber = scanner.nextInt();
                        System.out.print("Enter Order Total: $");
                        double orderTotal = scanner.nextDouble();

                        Order order = new Order(lastName, orderNumber, orderTotal);
                        display.addOrder(order);
                        break;
                    case 2:
                        display.displayOrders();
                        break;
                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
    }
}