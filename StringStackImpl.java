import java.io.PrintStream;
import java.util.NoSuchElementException;

class Node {
    private String item;
    private Node next;

    Node(String item, Node next) {
        this.item = item;
        this.next = next;

    }

    public String getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

}

public class StringStackImpl implements StringStack {

    private Node head; // Reference to the upper Node of the Stack
    private int counter; // Count of the Nodes contained int the Stack

    public StringStackImpl(int maxN) { // Constructor
        head = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return head == null;
    } // checks if stack is empty

    public void push(String item) { // pushes a new Node in the stack
        head = new Node(item, head);
        counter++;

    }

    public String pop() throws NoSuchElementException { // gets the last Node of the stack if its not empty

        if (isEmpty()) {
            System.out.println("You can't pop from an empty stack ");
            throw new NoSuchElementException();
        }

        String str = head.getItem();
        head = head.getNext();
        counter--;
        return str;
    }

    public String peek() throws NoSuchElementException { // prints the last Node of the stack without removing it

        if (isEmpty()) {
            System.out.println("Stack is Empty ");
            throw new NoSuchElementException();
        }

        String str = head.getItem();
        return str;

    }

    public void printStack(PrintStream stream) { // Prints the whole stack (if its not empty) starting from the last in
                                                 // there

        if (isEmpty()) {
            System.out.println("Stack is empty ! ");
        }

        Node t = head;
        while (t != null) {
            stream.println(t.getItem());
            t = t.getNext();
        }

    }

    public int size() {
        return counter;
    } // Prints the num of Nodes in the stack

}