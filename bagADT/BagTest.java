package bagADT;
import java.util.Random;
import java.text.DecimalFormat;
import java.lang.Math;


public class BagTest {

    // Static method for generating an item object to place into cart.
    public static ShoppingItem generateItem() {


        Random rand = new Random();
        // Random Item Values
        int randomInt = rand.nextInt(100);
        double randomDouble = rand.nextDouble(300.00);

        double roundedDouble = Math.round(randomDouble / 0.50) * 0.50;

        // Curreny format
        DecimalFormat currencyFormat =  new DecimalFormat("$#,##0.00");

        String formattedDouble = currencyFormat.format(roundedDouble);


        String randomName = FoodNameGenerator.generateRandomItemName();



        ShoppingItem item = new ShoppingItem(randomInt, randomName, formattedDouble );

        return item;
    }

    // displayBag will print out the contents of the shopping cart.
    public static void displayBag(ShoppingCart<ShoppingItem> cart) {
        System.out.println("Contents of the shopping cart:");
        ShoppingItem[] items = cart.toArray();
        for (ShoppingItem item : items) {
            System.out.println("Item: " + item.getProductName() + " | Price: $" + item.getPrice());
        }
    }

    public static void testAddI(ShoppingCart<ShoppingItem> cart) {
        // Populate cart with items
        for (int i = 0; i < 8; i++) {
            ShoppingItem item = BagTest.generateItem();
            cart.add(item);

        }

    }


    public static void main(String[] args) {

        ShoppingCart<ShoppingItem> myCart = new ShoppingCart<>();

        BagTest.testAddI(myCart);
        BagTest.displayBag(myCart);






    }



    
    
}
