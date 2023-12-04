package csc400cap;

public class Order {

    private String lastName;
    private int orderNumber;
    private double orderTotal;

    // Constructor

    public Order(String lastName, int orderNumber, double orderTotal) {
        this.lastName = lastName;
        this.orderNumber = orderNumber;
        this.orderTotal = orderTotal;

    }

    public String getLastName() {
        return lastName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    @Override
    public String toString() {
        return "Last Name: " + lastName + " || " + "Order Number: " + orderNumber + " || " + "Order Total: $" + orderTotal;
    }



    
}
