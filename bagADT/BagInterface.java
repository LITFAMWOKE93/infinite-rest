package bagADT;

public interface BagInterface<MyType> {


    // Get number of bag entries
    // @return the int number of entries
    public int getSize();


    // Check for empty and return boolean value
    public boolean isEmpty();


    //Add to bag, boolean return for success
    public boolean add(MyType newEntry);


    //remove unspecified entry, or return null
    public MyType remove();

    //remove on occurence of a specified entry, if possible
    public boolean remove(MyType entry);

    // Remove all from bag
    public void clear();

    //Count number of given entry.
    
    public int getFrequencyOf(MyType entry);

    // Test for contents
    public boolean contains(MyType entry);

    // Retrieves all entries in the bag and sends to new array
    public MyType[] toArray();






    
}
