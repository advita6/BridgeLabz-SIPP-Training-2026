// Generic interface defining a common data-access behavior
interface Repository<T> {
    void save(T item);
    T findById(int id);
}

// Implementation for a User entity
class UserRepository implements Repository<String> {
    @Override
    public void save(String user) {
        System.out.println("Saving user: " + user);
    }

    @Override
    public String findById(int id) {
        return "User_" + id;
    }
}

public class GenericInterfaceExample {
    public static void main(String[] args) {
        Repository<String> repo = new UserRepository();
        repo.save("John Doe");
    }
}