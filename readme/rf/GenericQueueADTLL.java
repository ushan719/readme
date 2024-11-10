class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class GenericQueueADTLL<T> {
    Node<T> front;
    Node<T> rear;

    public GenericQueueADTLL() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null; // Or throw an exception
        } else {
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null; // Or throw an exception
        } else {
            return front.data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            Node<T> current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GenericQueueADTLL<Integer> queue = new GenericQueueADTLL<>();

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
