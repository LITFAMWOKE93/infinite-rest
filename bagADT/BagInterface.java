package bagADT;

public interface BagInterface<T> {


    // Get number of bag entries
    // @return the int number of entries
    public int getSize();


    // Check for empty and return boolean value
    public boolean isEmpty();




    //Add to bag, boolean return for success
    public boolean add(T newEntry);


    //remove unspecified entry, or return null
    public T remove();

    //remove on occurence of a specified entry, if possible
    public boolean remove(T entry);

    // Remove all from bag
    public void clear();

    //Count number of given entry.
    
    public int getFrequencyOf(T entry);

    // Test for contents
    public boolean contains(T entry);

    // Retrieves all entries in the bag and sends to new array
    public T[] toArray();






    
}
