import java.util.Scanner;

public class User {
    private double balance = 0;
    private String name = "";

    public User(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public void showBalance() {
        System.out.println(name + " balance: " + balance);
    }

    public void deposit() {
        System.out.println("Enter the amount to deposit: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("You deposited: " + amount);
        showBalance();
    }

    public void withDraw() {
        
    }
}
