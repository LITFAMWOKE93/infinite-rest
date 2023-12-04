package selectionsortdemo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> studentArray = new ArrayList<>();
        // Populating the array
        studentArray.add(new Student(122, "Alice", "123 Main St"));
        studentArray.add(new Student(152, "Bob", "456 Elm St"));
        studentArray.add(new Student(104, "Beth", "789 Oak St"));
        studentArray.add(new Student(867, "Jackie", "768 Oak St"));
        studentArray.add(new Student(768, "Zoe", "935 Washington St"));
        studentArray.add(new Student(456, "Sam", "034 Jefferson St"));
        studentArray.add(new Student(833, "Max", "832 Lamb St"));
        studentArray.add(new Student(220, "Jeff", "888 Beggar St"));
        studentArray.add(new Student(176, "Karley", "564 Elfish St"));
        studentArray.add(new Student(111, "Helga", "778 Cat St"));
        
        // Sort using name comparisons and their string values
        SelectionSort.sort(studentArray, new NameCompare());
        System.out.println("Students sorted by name:");
        for (Student student : studentArray ) {
            System.out.println(student);
            
        }

        // Sort using roll comparisons with int values
        SelectionSort.sort(studentArray, new RollCompare());
        System.out.println("Students sorted by roll number:");
        for (Student student : studentArray ) {
            System.out.println(student);
            
        }




    }
    
}
