class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedListADT {
    Node head;

    public CircularLinkedListADT() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void deleteAtFront() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty");
            return;
        }
        if (head.next == head) { // Only one element in the list
            head = null;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty");
            return;
        }
        if (head.next == head) { // Only one element in the list
            head = null;
        } else {
            Node current = head;
            Node previous = null;
            while (current.next != head) {
                previous = current;
                current = current.next;
            }
            previous.next = head;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedListADT circularLinkedList = new CircularLinkedListADT();

        circularLinkedList.insertAtFront(3);
        circularLinkedList.insertAtFront(2);
        circularLinkedList.insertAtFront(1);

        circularLinkedList.display(); // Output: 1 2 3

        circularLinkedList.insertAtEnd(4);
        circularLinkedList.insertAtEnd(5);

        circularLinkedList.display(); // Output: 1 2 3 4 5

        circularLinkedList.deleteAtFront();
        circularLinkedList.display(); // Output: 2 3 4 5

        circularLinkedList.deleteAtEnd();
        circularLinkedList.display(); // Output: 2 3 4
    }
}
