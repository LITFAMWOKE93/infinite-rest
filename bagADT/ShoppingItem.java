package bagADT;

public class ShoppingItem {

    private int customerID;
    private String productName;

    private String price;

    public ShoppingItem() {
        this.customerID = 1234;
        this.productName = "product_generic";
        this.price = "$20.00";
    }

    public ShoppingItem(int customerID, String productName, String price) {
        this.customerID = customerID;
        this.productName = productName;
        this.price = price;
    }

    // Setters and Getters
    public int getCustomerID() {
        return customerID;
    }


    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    
    public String getProductName() {
        return productName;
    }

    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    public String getPrice() {
        return price;
    }

    
    public void setPrice(String price) {
        this.price = price;
    }
    
}
