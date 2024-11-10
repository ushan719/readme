class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularQueue {
    Node rear;
    int size;

    public CircularQueue() {
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = newNode;
        } else {
            newNode.next = rear.next;
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Or throw an exception
        } else if (size == 1) {
            int data = rear.data;
            rear = null;
            size--;
            return data;
        } else {
            int data = rear.next.data;
            rear.next = rear.next.next;
            size--;
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Or throw an exception
        } else {
            return rear.next.data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            Node current = rear.next;
            System.out.print("Queue: ");
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != rear.next);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
		queue.enQueue(4);

        System.out.println("Queue elements:");
        queue.display();

        System.out.println("Peek element: " + queue.peek());

        queue.deQueue();
        queue.deQueue();
		
        queue.display();
		queue.enQueue(8);
        queue.enQueue(9);
		queue.enQueue(5);
        queue.enQueue(6);
		queue.display();
		
    }
}
