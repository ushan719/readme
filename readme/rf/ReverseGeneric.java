class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListADT<T> {
    Node<T> head;

    public LinkedListADT() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtIndex(T data, int index) {
        if (index < 1 || index > getSize()+1) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 1) {
            insertAtFront(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int c = 1; c < index - 1; c++){
            current = current.next;                
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtFront() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else {
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= getSize()) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            deleteAtFront();
            return;
        }
        Node<T> current = head;
        for (int c = 0; c < index - 1; c++){
            current = current.next;                
        }
        current.next = current.next.next;
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class ReverseGeneric<T> {
    public void reverseLinkedList(LinkedListADT<T> linkedList) {
        if (linkedList.isEmpty() || linkedList.head.next == null) {
            return; // Empty list or only one element, no need to reverse
        }

        Node<T> previous = null;
        Node<T> current = linkedList.head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        linkedList.head = previous;
    }

    public static void main(String[] args) {
        LinkedListADT<Integer> linkedList = new LinkedListADT<>();
        ReverseGeneric<Integer> r = new ReverseGeneric<>();

        // Add elements to the linked list
        linkedList.insertAtFront(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);

        // Display the original list
        System.out.print("Original list: ");
        linkedList.display(); // Output: Original list: 1 2 3 

        // Reverse the linked list
        r.reverseLinkedList(linkedList);

        // Display the reversed list
        System.out.print("Reversed list: ");
        linkedList.display(); // Output: Reversed list: 3 2 1
    }
}
