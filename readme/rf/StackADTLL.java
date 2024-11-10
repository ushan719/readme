class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class StackADT {
    Node top;

    public StackADT() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            String data = top.data;
            top = top.next;
            return data;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return top.data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class StackADTLL {
    public static void main(String[] args) {
        StackADT stack = new StackADT();

        stack.push("Java");
        stack.push("Python");
        stack.push("C++");

        System.out.println("Stack elements:");
        stack.display(); // Output: C++ Python Java

        System.out.println("Peek element: " + stack.peek()); // Output: Peek element: C++
        System.out.println("Popped element: " + stack.pop()); // Output: Popped element: C++
        
        System.out.println("Stack elements after pop:");
        stack.display(); // Output: Python Java
    }
}
