class ArrayADT {
    int[] array;
    int size;
    
    public ArrayADT(int capacity) {
        array = new int[capacity];
        size = 0;
    }
    
	public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == array.length;
    }
	
	public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return array[index];
    }
    
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        array[index] = value;
    }
    
    public int getSize() {
        return size;
    }
	
    public void insert(int index, int value) {		
        if (index < 0 || index > array.length-1) {
			System.out.println("Index is out of range");
            //throw new IndexOutOfBoundsException("Index is out of range");
        }
		else if(isFull()){
			System.out.println("Array is full");
		}		
		else{
			// Shift elements to the right to make space for the new value
			for (int i = size - 1; i >= index; i--) {
				array[i + 1] = array[i];
			}
			array[index] = value;
			size++;
			System.out.println(value+ " inserted at "+ index);
		}        
    }

	public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
		else if(isEmpty()){
			System.out.println("Array is empty");
		}
		else{
			// Shift elements to the left to remove the element at the given index
			for (int i = index; i < size - 1; i++) {
				array[i] = array[i + 1];
			}
			array[size-1] = 0;
			size--;
		}
    }
    
    public int search(int value) {
		if(isEmpty()){
			System.out.println("Array is empty");
			return -1; 
		}
		else{
			for (int i = 0; i < size; i++) {
				if (array[i] == value) {
					return i;
				}
			}
			return -1;  // Value not found
		}        
    }
    
    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
	
	/*
	private void resizeArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    } */
	
    public static void main(String[] args) {
        ArrayADT arr = new ArrayADT(5);
        
        // Inserting elements
        arr.insert(0, 5);
        arr.insert(1, 2);
        arr.insert(2, 7);
        arr.insert(3, 3);
		arr.insert(4, 2);
		//arr.insert(4, 2);
		arr.insert(5, 2);
		
		// Accessing and modifying elements
        System.out.println("Element at index 2: " + arr.get(2));
        arr.set(2, 9);
        System.out.println("Modified element at index 2: " + arr.get(2));
        
        // Determining the size
        System.out.println("Size of the array: " + arr.getSize());
        
        // Deleting an element
		arr.delete(1);
        System.out.println("Size after deleting an element: " + arr.getSize());
		        
        // Searching for an element
        int index = arr.search(7);
        System.out.println("Index of element 7: " + index);
        
        // Traversing the array
        arr.traverse();               
    }
}