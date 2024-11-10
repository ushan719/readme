class StackADT<T> {
    int maxSize;
    Object[] stackArray;
    int top;

    public StackADT(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1; // Initialize the top of the stack to -1 (empty)
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(T data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + data);
        } else {
            stackArray[++top] = data;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        } else {
			/*
            T data = (T) stackArray[top];
            top--;
            return data;
			*/
			return (T) stackArray[top--];
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return (T) stackArray[top];
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

public class StackADTArrayGeneric {
    public static void main(String[] args) {
        StackADT<Integer> stack = new StackADT<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display(); // Output: Stack: 1 2 3

        System.out.println("Peek: " + stack.peek()); // Output: Peek: 3

        stack.pop();
        stack.pop();

        stack.display(); // Output: Stack: 1
    }
}
