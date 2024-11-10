class StackADT {
    int maxSize;
    int[] stackArray;
    int top;

    public StackADT(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // Initialize the top of the stack to -1 (empty)
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + data);
        } else {
            stackArray[++top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
			return stackArray[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
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

public class StringReverser {
    public static void reverseString(String input) {
        int length = input.length();
        StackADT stack = new StackADT(length); // Create a stack to hold characters

        // Push each character of the input string onto the stack
        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }
		
		System.out.println(stack.peek());

        while (!stack.isEmpty()) {            
			System.out.print((char) stack.pop());
        }
    }

    public static void main(String[] args) {
        String originalString = "Hello, World!";		
        System.out.println("Original String: " + originalString);
		reverseString(originalString);        
    }
}
