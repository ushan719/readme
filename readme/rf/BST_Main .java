class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key
    Node insertRec(Node root, int key) {

        // <<< Complete this portion >>>

        return root;
    }

    // Search for a key
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search for a key
    boolean searchRec(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key)
            return root != null;

        // Key is greater than root's key, search the right subtree
        if (key > root.key)
            return searchRec(root.right, key);

        // Key is smaller than root's key, search the left subtree
        return searchRec(root.left, key);
    }

    // Delete a key from
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key
    Node deleteRec(Node root, int key) {

        // <<< Complete this portion >>>

        return root;
    }

    // Get the minimum value in a tree rooted at 'node'
    int minValue(Node node) {

        // <<< Complete this portion >>>

        return node.key;

    }

    // Print the BST in inorder traversal
    void inorder() {
        inorderRec(root);
    }

    // Recursive function to perform inorder traversal of the BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main class to test the Binary Search Tree
public class BST_Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting keys into the BST
        bst.insert(5);
        bst.insert(12);
        bst.insert(21);
        bst.insert(2);
        bst.insert(19);
        bst.insert(1);
        bst.insert(25);
        bst.insert(9);
        bst.insert(3);

        // Print the inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();
        System.out.println();

        // Search for a key
        int searchKey = 21;
        if (bst.search(searchKey))
            System.out.println("Key " + searchKey + " found in the BST.");
        else
            System.out.println("Key " + searchKey + " not found in the BST.");

        // Delete a key from the BST
        bst.deleteKey(9);
        System.out.println("Inorder traversal after deleting 9:");
        bst.inorder();
        System.out.println();

        bst.deleteKey(12);
        System.out.println("Inorder traversal after deleting 12:");
        bst.inorder();
        System.out.println();
    }
}
}

