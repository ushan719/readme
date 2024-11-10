import java.util.ArrayList;

public class ArrayListExample2 {
    public static void main(String[] args) {
        // Create an ArrayList of custom objects
        ArrayList<Person> personList = new ArrayList<>();

        // Create some Person objects
        Person person1 = new Person("John", 25);
        Person person2 = new Person("Alice", 30);
        Person person3 = new Person("Bob", 35);

        // Add objects to the ArrayList
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        // Accessing and modifying objects
        Person retrievedPerson = personList.get(1);
        System.out.println("Person at index 1: " + retrievedPerson.getName() + ", " + retrievedPerson.getAge());

        Person newPerson = new Person("Mike", 40);
        personList.set(1, newPerson);
        System.out.println("Modified person at index 1: " + personList.get(1).getName() + ", " + personList.get(1).getAge());

        // Determining the size
        int size = personList.size();
        System.out.println("Size of the ArrayList: " + size);

        // Removing an object
        personList.remove(0);
        System.out.println("Size after removing an object: " + personList.size());

		// Traversing the ArrayList
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getName() + ", " + personList.get(i).getAge());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
