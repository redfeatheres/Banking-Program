import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("***************");
            System.out.println("\nMENU");
            System.out.println("***************");
            System.out.println("1. Create user");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show balance");
            System.out.println("5. List all users");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = scanner.nextDouble();
                    scanner.nextLine();
                    if (service.createUser(name, bal)) {
                        System.out.println("User created.");
                    } else {
                        System.out.println("User already exists.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (service.deposit(name, amount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("User not found or invalid amount.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (service.withdraw(name, amount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("User not found, invalid amount, or insufficient funds.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    User user = service.getUser(name);
                    if (user != null) {
                        System.out.println("Balance of " + name + ": " + user.getBalance());
                    } else {
                        System.out.println("User not found.");
                    }
                }
                case 5 -> {
                    System.out.println("All users:");
                    for (User u : service.getAllUsers().values()) {
                        System.out.println(u.getName() + " - " + u.getBalance());
                    }
                }
                case 6 -> {
                    running = false;
                    System.out.println("See you");
                }
                default -> System.out.println("Invalid option.");
            }
        }

        service.saveUsers();
        scanner.close();
    }
}