public class QueueADTArray {
    String[] queueArray;
    int front;
    int rear;
    int maxSize;

    public QueueADTArray(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new String[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void enQueue(String data) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            queueArray[++rear] = data;
        }
    }

    public String deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {			
            String data = queueArray[front];
			// Method 1 - move front
            /* front++;
            if (front > rear) {
                front = 0;
                rear = -1;
            } */            
			
			// Method 2 - move rear
			for (int i=0; i<rear; i++){
				queueArray[i] = queueArray[i+1];
			}
			queueArray[rear--] = "";
			
			return data;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {
            return queueArray[front];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueADTArray queue = new QueueADTArray(5);

        queue.enQueue("U");
        queue.enQueue("o");
        queue.enQueue("J");

        System.out.println("Queue elements:");
        queue.display();

        System.out.println("Peek element: " + queue.peek());

        queue.deQueue();
        queue.deQueue();

        queue.display();
    }
}
