import java.io.PrintStream;
import java.util.NoSuchElementException;

class Node {
    private String item;
    private Node next;

    public Node(String item) { // Class Node

        this.item = item;
        next = null;
    }

    public String getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    } // getters and setters needed below

    public void setNext(Node next) {
        this.next = next;
    }
}

public class StringQueueWithOnePointer implements StringQueue {

    private Node tail; // One reference tail only needed in this implementation
    private int counter;

    public StringQueueWithOnePointer(int maxN) { // Constructor
        tail = null;
        counter = 0;

    }

    public boolean isEmpty() {
        return tail == null;
    } // same check

    public void put(String item) { // puts a new Node as the new tail of the circular list
                                   
        if (isEmpty()) {
            tail = new Node(item); // If queue is empty the circular list will have only 1 Node
            counter++;
            tail.setNext(tail);

        }

        else {
            Node t = tail;
            tail = new Node(item);
            counter++;
            tail.setNext(t.getNext());
            t.setNext(tail);
        }

    }

    public String get() throws NoSuchElementException { // gets the oldest Node of the queue(if its not empty)
                                                        
        if (isEmpty()) {
            System.out.println(" The Queue is Empty! ");
            throw new NoSuchElementException();
        }

        if (tail.getNext() == tail) { // if the queue has only 1 node it becomes an empty list

            String str = tail.getItem();
            counter--;
            tail = null;
            return str;
        }

        String str = tail.getNext().getItem(); // else the oldest Node( next of tail) is deleted
        tail.setNext(tail.getNext().getNext());
        counter--;
        return str;

    }

    public String peek() throws NoSuchElementException { // peeks and prints the oldest Node in the queue(next of tail)

        if (isEmpty()) {
            System.out.println(" The Queue is Empty! ");
            throw new NoSuchElementException();
        }

        String str = tail.getNext().getItem();
        return str;

    }

    public void printQueue(PrintStream stream) { // prints the whole queue(if its not empty) using a do while loop
                                                 // starting from the oldest Node to the last one
        if (isEmpty()) {
            System.out.println(" The Queue is Empty! ");
        }

        else {
            Node t = tail;

            do {
                t = t.getNext();
                stream.println(t.getItem());
            } while (t != tail);

        }

    }

    public int size() {
        return counter;
    } // prints the same way the num of Nodes in the Queue in time O(1)

}