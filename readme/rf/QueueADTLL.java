class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueADTLL {
    Node front;
    Node rear;

    public QueueADTLL() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Or throw an exception
        } else {
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Or throw an exception
        } else {
            return front.data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueADTLL queue = new QueueADTLL();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println("Queue elements:");
        queue.display();

        System.out.println("Peek element: " + queue.peek());

        queue.deQueue();
        queue.deQueue();

        queue.display();
    }
}
