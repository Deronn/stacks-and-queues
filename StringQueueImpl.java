import java.io.PrintStream;
import java.util.NoSuchElementException;

class Node {
    private String item;
    private Node next; // Class Node

    public Node(String item) {

        this.item = item;
        next = null;
    }

    public String getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    } // setters and getters needed for Node

    public void setNext(Node next) {
        this.next = next;
    }
}

public class StringQueueImpl implements StringQueue {

    private Node head; // Head and tail references needed
    private Node tail;
    private int counter;

    public StringQueueImpl(int maxN) { // Constructor
        head = null;
        tail = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return head == null;
    } // check if the queue is empty

    public void put(String item) { // puts a new Node at the tail of the queue

        Node t = tail;
        tail = new Node(item);
        counter++;
        if (isEmpty()) {
            head = tail;
        } else
            t.setNext(tail);

    }

    public String get() throws NoSuchElementException { // gets the Node at the head of the Queue

        if (isEmpty()) {
            System.out.println("The Queue is Empty! "); // throws Exception if its empty
            throw new NoSuchElementException();
        }

        String str = head.getItem();
        head = head.getNext();
        counter--;
        return str;
    }

    public String peek() throws NoSuchElementException { // peeks the Node at the head without removing it

        if (isEmpty()) {
            System.out.println("The Queue is Empty! ");
            throw new NoSuchElementException();
        }

        String str = head.getItem();
        return str;

    }

    public void printQueue(PrintStream stream) { // prints the whole queue starting from the head

        if (isEmpty()) {
            System.out.println("The Queue is Empty! ");
        }

        else {
            Node t = head;
            while (t != null) {
                stream.println(t.getItem());
                t = t.getNext();

            }

        }
    }

    public int size() {
        return counter;
    } // prints the num of Nodes in the Queue

}
