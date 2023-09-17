package bagADT;


import java.util.Arrays;




public class ShoppingCart<T> implements BagInterface<T> {

    private final T[] myBag;
    private int numberOfProducts;
    // Cannot be negative
    private static final int DEFAULT_CAPACITY = 10;


    // Constructor(s)
    @SuppressWarnings("unchecked")
    public ShoppingCart() {
        T[]tempBag = (T[]) new ShoppingItem[DEFAULT_CAPACITY];
        this.myBag = tempBag;
        this.numberOfProducts = 0;
    }


    /** Core Methods: 
     * Add, Remove, toArray, IsFull */



     public boolean add(T newEntry) {
        if (!isArrayFull()) {
            myBag[numberOfProducts] = newEntry;
            numberOfProducts++;
            return true;
        } else {
            
            return false;
        }
    }

    private boolean isArrayFull() {
        return numberOfProducts >= myBag.length;
    }


    public T remove() {

        //STUB
        return null;
    }

    public boolean remove(T entry) {

        //STUB
        return false;
    }


    @Override
    // Create a copy of Array instead of type casting
    // Not needed for fixed-size array but will be useful later for dynamically size arrays
    public T[] toArray() {
        // Create a new array of the same type and size as myBag
        T[] newArray = Arrays.copyOf(myBag, numberOfProducts);
        return newArray;
    }


    public boolean isEmpty() {
        return numberOfProducts == 0;

    }


    public int getSize() {
        return numberOfProducts;
    }

    public void clear() {
        //STUB
    }

    public int getFrequencyOf(T entry) {
        int sum = 0;

        for (T item : myBag ) {
            if (item != null && item.equals(entry)) {
                sum++;
            }
        }
        
        return sum;
    }

    public boolean contains(T entry) {

        for (T item : myBag) {
            if (item != null && item.equals(entry)) {
                return true;
            }
        }
               
                return false;

    }

    
}
