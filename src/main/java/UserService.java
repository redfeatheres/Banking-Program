import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private final Map<String, User> users = new HashMap<>();
    private static final String STORAGE_FILE = "users.user";

    public UserService() {
        loadUsers();
    }

    public boolean createUser(String name, double initialBalance) {
        if(users.containsKey(name)) {
            return false;
        }
        users.put(name, new User(name, initialBalance));
        return true;
    }

    public User getUser(String name) {
        return users.get(name);
    }

    public boolean deposit(String name, double amount) {
        User user = users.get(name);
        if (user == null || amount <= 0) {
            return false;
        }
        user.deposit(amount);
        return true;
    }

    public boolean withdraw(String name, double amount) {
        User user = users.get(name);
        if(user == null || amount <= 0) {
            return false;
        }
        return user.withdraw(amount);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public void saveUsers() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STORAGE_FILE))) {
            oos.writeObject(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        File file = new File(STORAGE_FILE);
        if(!file.exists()) return;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Map<String, User> loaded = (Map<String, User>) ois.readObject();
            users.clear();
            users.putAll(loaded);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
