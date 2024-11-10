public class PriorityQueueADTArray {
    int[] queueArray;
    int front;
    int rear;
    int maxSize;

    public PriorityQueueADTArray(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            // Find the appropriate position to insert in increasing order
            int insertIndex = rear;
            while (insertIndex >= front && queueArray[insertIndex] > data) {
                queueArray[insertIndex + 1] = queueArray[insertIndex];
                insertIndex--;
            }
            queueArray[insertIndex + 1] = data;
            rear++;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Or throw an exception
        } else {
            int data = queueArray[front];
            front++;
            if (front > rear) {
                front = 0;
                rear = -1;
            }
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Or throw an exception
        } else {
            return queueArray[front];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PriorityQueueADTArray queue = new PriorityQueueADTArray(5);

        queue.enQueue(3);
        queue.enQueue(1);
        queue.enQueue(4);
		queue.enQueue(9);
        queue.enQueue(2);
		
        System.out.println("Queue elements:");
        queue.display();

        System.out.println("Peek element: " + queue.peek());

        queue.deQueue();
        queue.deQueue();

        queue.display();
    }
}
