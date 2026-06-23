public class Person {
    private String name;
    private int age;

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    public Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}