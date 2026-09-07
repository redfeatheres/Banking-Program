import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DECLARE VARIABLES
        Map<String, User> users = new HashMap<>();
        users.put("12345", new User("John", 1000));
        users.put("0000", new User("Bob", 2000));
        users.put("321", new User("Luke", 4000));

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice;
        String password;

        // AUTHENTICATION MENU
        System.out.println("Enter your Password: ");
        password = scanner.nextLine();
        User findedUser = users.get(password);

        while (findedUser == null) {
            System.out.println("Incorrect password. " +
                    "Please enter the correct password:");
            password = scanner.nextLine();
            findedUser = users.get(password);
        }

        // DISPLAY MENU
        System.out.println("WELCOME " + findedUser.getName());
        System.out.println("_______________");
        System.out.println("BANKING PROGRAM");
        System.out.println("_______________");
        System.out.println("1. Show balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        System.out.println("CHOOSE AN OPTION: ");
        choice = scanner.nextInt();

        // GET AND PROCESS USERS CHOICE
        while (choice != 4) {
            switch (choice) {
                case 1:
                    findedUser.showBalance();
                    break;
                case 2:
                    findedUser.deposit();
                    break;
                case 3:
                    findedUser.withDraw();
                    break;
                default:
                    System.out.println("There is no such option. '\n'-----------------------");
            }
            System.out.println("CHOOSE AN OPTION: ");
            choice = scanner.nextInt();
        }
        System.out.println("See you next time!");
    }
}
