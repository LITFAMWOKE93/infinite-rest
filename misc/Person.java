package misc;

import java.util.Arrays;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // Compare persons based on their ages
        return Integer.compare(this.age, otherPerson.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static void main(String[] args) {
        // Creating an array of Person objects
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22),
                new Person("David", 35)
        };

        // Sorting the array of Person objects based on their ages using Arrays.sort()
        Arrays.sort(people);

        // Printing the sorted array of Person objects
        System.out.println("Sorted People by Age:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

