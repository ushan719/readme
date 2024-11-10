public class BinTree_Array {
    Object[] array;

    // Constructor
    public BinTree_Array() {
        array = new Object[128];
    }

    // Method to check if the tree is empty
    public boolean empty() {
        return (array[1] == null);
    }

    // Method to calculate the left child index of node i
    public int left(int i) {
        return 2 * i;
    }

    // Method to calculate the right child index of node i
    public int right(int i) {
        return 2 * i + 1;
    }

    // Method to calculate the parent index of node i
    public int parent(int i) {
        return i / 2;
    }

    // Method to get the cargo (value) at index i
    public Object getCargo(int i) {
        if (i < 0 || i >= array.length) return null;
        return array[i];
    }

    // Method to set the cargo (value) at index i, with simple error checking
    public void setCargo(int i, Object obj) {
        if (i < 0 || i >= array.length) return;
        array[i] = obj;
    }

    // Method to print the contents of the tree in preorder
    public void printPreorder(int i) {
        if (getCargo(i) == null) return;
        System.out.println(getCargo(i));
        printPreorder(left(i));
        printPreorder(right(i));
    }

    public static void main(String[] args) {
        // Create a new tree
        BinTree_Array tree = new BinTree_Array();

        // Set cargo (values) for the root and its children
        int root = 1;
        tree.setCargo(root, "cargo for root");
        tree.setCargo(tree.left(root), "cargo for left");
        tree.setCargo(tree.right(root), "cargo for right");

        // Print the tree in preorder
        tree.printPreorder(root);
    }
}