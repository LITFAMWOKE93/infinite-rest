package csc400cap;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Display {

    // The actual data structures used to store the Order objects
    private Queue<Order> orderQueue = new LinkedList<>();
    private ArrayList<Order> ordersByName = new ArrayList<>();
    private ArrayList<Order> ordersByNumber = new ArrayList<>();


    public void addOrder(Order order) {

        //The queue is updated along with the array lists
        orderQueue.add(order);
        ordersByName.add(order);
        ordersByNumber.add(order);
        sortOrders();
        displayOrders();

    }

    private void sortOrders() {
        // Java uses an implementation of quickSort to handle comparisons
        // The method reference operator, " :: " allows the use of an instance method that is not directly called by the instanced object itself.
        Collections.sort(ordersByName, Comparator.comparing(Order::getLastName));
        Collections.sort(ordersByNumber, Comparator.comparingInt(Order::getOrderNumber));

        // Reverse is used to achieve descending sort for the ordered lists
        Collections.reverse(ordersByName);
        Collections.reverse(ordersByNumber);
    }

    public void displayOrders() {
        // Console display formatting stucture
        System.out.println("Order List Sorted by Name:");
        for (Order order : ordersByName) {
            System.out.println(order.toString());
        }

        System.out.println("------------------------------------------------------------");

        System.out.println("\nOrder List Sorted by Order Number:");
        for (Order order : ordersByNumber) {
            System.out.println(order.toString());
        }

        System.out.println("-------------------------------------------------------------");
    }
    
}
