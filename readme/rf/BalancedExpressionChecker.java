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

public class BalancedExpressionChecker {
    public static boolean isBalanced(String expression) {
        StackADT stack = new StackADT();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(Character.toString(ch));
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing symbol
                }

                String topSymbol = stack.pop();
                if ((ch == ')' && !topSymbol.equals("(")) ||
                    (ch == ']' && !topSymbol.equals("[")) ||
                    (ch == '}' && !topSymbol.equals("{"))) {
                    return false; // Mismatched closing symbol
                }
            }
        }

        return stack.isEmpty(); // Check if the stack is empty at the end
    }

    public static void main(String[] args) {
        String expression1 = "{(a + b) * [c - d]}";
        String expression2 = "{(a + b) * [c - d]";
        String expression3 = "{(a + b) * [c - d]})";

        System.out.println(expression1 + " is balanced: " + isBalanced(expression1)); // Output: true
        System.out.println(expression2 + " is balanced: " + isBalanced(expression2)); // Output: false
        System.out.println(expression3 + " is balanced: " + isBalanced(expression3)); // Output: false
    }
}

