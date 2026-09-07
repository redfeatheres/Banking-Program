import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DECLARE VARIABLES
        Scanner scanner = new Scanner(System.in);
        double balance;
        boolean isRunning = true;
        int choice;

        // DISPLAY MENU
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
                    showBalance();
                case 2:
                    deposit();
                case 3:
                    withdraw();
                case 4:
                    System.out.println("See you next time!");
                default:
                    System.out.println("There is no such option. '\n' XXXXXXXXXXXXX");
            }

            System.out.println("CHOOSE AN OPTION: ");
            choice = scanner.nextInt();
        }

        // showBalance

        // deposit()

        // withdraw()

        // EXIT MSG
    }
}
