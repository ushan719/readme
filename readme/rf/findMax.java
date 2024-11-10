// Recursive method to find the maximum value in the tree starting from a specific index
private Object findMax(int index) {
    // Base case: if the index is out of bounds or the node is null, return null
    if (index >= array.length || array[index] == null) return null;

    // Get the value of the current node
    Object currentMax = array[index];

    // Recursively find the maximum value in the left and right subtrees
    Object leftMax = findMax(left(index));
    Object rightMax = findMax(right(index));

    // Compare the current node's value with the maximum values found in the left and right subtrees
    if (leftMax != null && ((Comparable<Object>) leftMax).compareTo(currentMax) > 0) {
        currentMax = leftMax;
    }
    if (rightMax != null && ((Comparable<Object>) rightMax).compareTo(currentMax) > 0) {
        currentMax = rightMax;
    }

    return currentMax;  // Return the maximum value found
}

// Public method to initiate the max search starting from the root (index 1)
public Object findMax() {
    return findMax(1);  // Start the search from the root node (index 1)
}