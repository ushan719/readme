import java.util.ArrayList;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class StudentListOperations {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        // Add three students to the studentList
        studentList.add(new Student("John Doe", 18, 85.5));
        studentList.add(new Student("Jane Smith", 17, 92.0));
        studentList.add(new Student("Michael Johnson", 19, 78.3));

        // Print the details of all students
        System.out.println("Details of all students:");
        for (Student student : studentList) {
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
        }

        // Update the grade of "John Doe" to 90.2
        for (Student student : studentList) {
            if (student.getName().equals("John Doe")) {
                student.setGrade(90.2);
                break;
            }
        }

        // Remove "Jane Smith" from the studentList
        Student janeSmith = null;
        for (Student student : studentList) {
            if (student.getName().equals("Jane Smith")) {
                janeSmith = student;
                break;
            }
        }
        studentList.remove(janeSmith);

        // Print the details of all students after the modifications
        System.out.println("\nDetails of all students after modifications:");
        for (Student student : studentList) {
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
        }
    }
}
