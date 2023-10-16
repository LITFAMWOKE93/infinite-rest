package selectionsortdemo;

public class Student {
    // Variables belonging to class Student
    private int rollno;
    private String name;
    private String address;

    // Constructors
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;

    }

    public Student() {
        this.rollno = 0;
        this.name = "John Smith";
        this.address = "123 Lane";
    }

    // Mutators and Acccessors

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    

    @Override
    public String toString() {
        return "Student{" +
        "Name='" + name + '\'' +
        ", Enrollment ID=" + rollno + '\'' + ", Address=" + address +
        '}';
        }
    }
    



