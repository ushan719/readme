class StackADT {
    int maxSize;
    String[] stackArray;
    int top;

    public StackADT(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new String[maxSize];
        this.top = -1; // Initialize the top of the stack to -1 (empty)
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(String data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + data);
        } else {
            stackArray[++top] = data;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        } else {
            return stackArray[top--];
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return stackArray[top];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

class QueueUsingTwoStacks {
    private StackADT stack1;
    private StackADT stack2;

    public QueueUsingTwoStacks(int maxSize) {
        stack1 = new StackADT(maxSize);
        stack2 = new StackADT(maxSize);
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public boolean isFull() {
        return stack1.isFull() || stack2.isFull();
    }

    public void enQueue(String data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(data);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public String deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        } else {
            return stack1.pop();
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            return stack1.peek();
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            stack1.display();
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks(5);

        queue.enQueue("how");
        queue.enQueue("is");
        queue.enQueue("going");

        System.out.println("Queue elements:");
        queue.display();

        System.out.println("Peek element: " + queue.peek());

        queue.deQueue();
        queue.deQueue();

        queue.display();
    }
}

