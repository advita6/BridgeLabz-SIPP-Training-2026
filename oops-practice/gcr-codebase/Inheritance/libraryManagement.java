// Superclass
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

// Subclass extending Book
class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Demonstration Class
public class LibraryManagement {
    public static void main(String[] args) {
        Author authorBook = new Author(
            "Java Mastery", 
            2024, 
            "James Gosling", 
            "A pioneer of computer science and creator of the Java programming language."
        );

        authorBook.displayInfo();
    }
}