import java.util.ArrayList;

public class ArrayListExample1 {
    public static void main(String[] args) {
		// ----------------------------------------
        // Create an ArrayList of integers
		// ----------------------------------------
        // ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // Add elements to the ArrayList
        for (int i = 1; i <= 15; i++)
            arrayList.add(i*2);		
				
        // Accessing and modifying elements
        int element = arrayList.get(2);
        System.out.println("Element at index 2: " + element);

        arrayList.set(2, 9);
        System.out.println("Modified element at index 2: " + arrayList.get(2));

        // Determining the size
        int size = arrayList.size();
        System.out.println("Size of the ArrayList: " + size);

        // Removing an element
        arrayList.remove(1);
        System.out.println("Size after removing an element: " + arrayList.size());

        // Searching for an element
        int index = arrayList.indexOf(7);
        System.out.println("Index of element 7: " + index);
		
		if (arrayList.contains(8)) System.out.println("8 is exists");
		else System.out.println("8 is not exists");

        System.out.println(arrayList);
		
		// Traversing the ArrayList
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
		
		System.out.println("\n_________________________\n");
		
		// ----------------------------------------
        // Create an ArrayList that can accept objects of any type
		// ----------------------------------------
        ArrayList<Object> list = new ArrayList<>();

        // Add objects of different types to the ArrayList
        list.add("Hello");
        list.add(42);
        list.add(3.14);
        list.add(true);
		list.add('c');

		System.out.println(list);
		
        // Accessing objects from the ArrayList
        Object obj1 = list.get(0);
        System.out.println("Element at index 0: " + obj1);

		list.set(1, 1000);
        System.out.println("Element at index 1: " + list.get(1));

		// Traversing the ArrayList
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
