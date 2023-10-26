package misc;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo{
    public static void main(String[] args) {
        Queue<Person> queue = new LinkedList<>();

        // Enqueue elements
        queue.add(new Person("John", 20));
        queue.add(new Person("Jill", 32));
        queue.add(new Person("Kelly", 62));

        System.out.println("Queue elements: " + queue );  

        // Dequeue operation
        Person dequeuedItem = queue.poll();
        System.out.println("Dequeued item: " + dequeuedItem);  

        System.out.println("Queue elements after dequeue: " + queue);  

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);  

        // Get the size of the queue
        int size = queue.size();
        System.out.println("Queue size: " + size);  

        Person dequeuedItem1 = queue.poll();
        System.out.println("Dequeued item: " + dequeuedItem1);  

        Person dequeuedItem2 = queue.poll();
        System.out.println("Dequeued item: " + dequeuedItem2);  


        isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);  
    }
}