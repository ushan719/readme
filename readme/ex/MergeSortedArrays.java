import java.util.ArrayList;

public class MergeSortedArrays {
    
    public static ArrayList<Double> mergeArrays(double[] ascendingArray, double[] descendingArray) {
        ArrayList<Double> mergedArray = new ArrayList<>();
        
        int i = 0;  // Pointer for ascendingArray
        int j = descendingArray.length - 1;  // Pointer for descendingArray
        
        // Merge the arrays by comparing elements from both arrays
        while (i < ascendingArray.length && j >= 0) {
            if (ascendingArray[i] < descendingArray[j]) {
                mergedArray.add(ascendingArray[i]);
                i++;
            } else {
                mergedArray.add(descendingArray[j]);
                j--;
            }
        }
        
        // Add remaining elements from the ascending array, if any
        while (i < ascendingArray.length) {
            mergedArray.add(ascendingArray[i]);
            i++;
        }
        
        // Add remaining elements from the descending array, if any
        while (j >= 0) {
            mergedArray.add(descendingArray[j]);
            j--;
        }
        
        return mergedArray;
    }
    
    public static void main(String[] args) {
        double[] ascendingArray = {1.2, 2.3, 3.4, 4.5, 5.6};
        double[] descendingArray = {9.8, 8.7, 7.6, 6.5};
        
        ArrayList<Double> mergedArray = mergeArrays(ascendingArray, descendingArray);
        
        System.out.println("Merged Array: " + mergedArray);
    }
}
