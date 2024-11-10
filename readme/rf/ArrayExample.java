public class ArrayExample {
    public static boolean isSortedAscending(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return true; // An array with 0 or 1 element is considered sorted
        }
        for (int i = 0; i < n - 1; ) {
            if (arr[i] > arr[i + 1]) {
                return false; // Array is not sorted in ascending order
            }
            i++; // Increment the index
        }
        return true; // Array is sorted in ascending order
    }

    public static void main(String[] args) {
		// Declare and initialize an array of integers
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};

        System.out.println("Array 1 is sorted in ascending order: " + isSortedAscending(arr1));
        System.out.println("Array 2 is sorted in ascending order: " + isSortedAscending(arr2));
    }
}





