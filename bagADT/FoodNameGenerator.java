package bagADT;

import java.util.Random;

public class FoodNameGenerator {

    private static final String[] ADJECTIVES = {"Spicy", "Delicious", "Savory", "Tasty", "Gourmet", "Mouthwatering"};
    private static final String[] FOODS = {"Pizza", "Burger", "Sushi", "Pasta", "Tacos", "Salad", "Steak", "Ramen", "Curry", "Burrito"};
    private static final Random rand = new Random();

    public static String generateRandomItemName() {
        String adjective = ADJECTIVES[rand.nextInt(ADJECTIVES.length)];
        String food = FOODS[rand.nextInt(FOODS.length)];
        return adjective + " " + food;
    }
    
}
