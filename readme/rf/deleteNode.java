Node deleteRec(Node root, int key) {
    // Base case: tree is empty
    if (root == null) return root;

    // Recur down the tree to find the node to be deleted
    if (key < root.key)
        root.left = deleteRec(root.left, key);
    else if (key > root.key)
        root.right = deleteRec(root.right, key);
    else {
        // Node with only one child or no child
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        // Node with two children, get the smallest in the right subtree
        root.key = minValue(root.right);

        // Delete the node used
        root.right = deleteRec(root.right, root.key);
    }

    return root;
}