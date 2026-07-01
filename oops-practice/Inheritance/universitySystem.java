// Base Class
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

// Subclass
class Student extends Person {
    private final String studentId; // final attribute
    private double gpa;

    public Student(String name, String studentId, double gpa) {
        super(name); // Chaining constructor of Person
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
    }
}

// Subclass extending Student
class GradStudent extends Student {
    private String thesisTitle;

    public GradStudent(String name, String studentId, double gpa, String thesisTitle) {
        super(name, studentId, gpa); // Chaining constructor of Student
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: \"" + thesisTitle + "\"";
    }
}

// Demonstration Class
public class UniversitySystem {
    public static void main(String[] args) {
        GradStudent grad = new GradStudent("Advita", "STU101", 3.9, "AI Optimization in Cloud Architectures");

        // Display details using overridden toString() methods
        System.out.println(grad);

        // Demonstrating IS-A Relationship using instanceof
        System.out.println("\n--- IS-A Relationship Verification ---");
        System.out.println("Is grad a GradStudent? " + (grad instanceof GradStudent));
        System.out.println("Is grad a Student? " + (grad instanceof Student));
        System.out.println("Is grad a Person? " + (grad instanceof Person));
    }
}