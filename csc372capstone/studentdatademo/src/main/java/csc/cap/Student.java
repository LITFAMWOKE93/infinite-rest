package csc.cap;

public class Student {
    // Private members
    private String name;
    private String address;
    private double GPA;

    // CONSTRUCTORS
    public Student() {
        this.name = "John Smith";
        this.address = "123 Street str";
        this.GPA = 3.5;

    }

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;


    }

     // Setters
     public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    // Override toString() method
    @Override
    public String toString() {
        return
                name +
                ", " + address + 
                ", " + GPA 
                ;
    }

    
}
