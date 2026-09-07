import java.util.Scanner;

public class User {
    private double balance = 0;
    private String name = "";
    Scanner scanner = new Scanner(System.in);

    public User(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public void showBalance() {
        System.out.println(name + " balance: " + balance);
    }

    public void deposit() {
        System.out.println("Enter the amount to deposit: ");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("You deposited: " + amount);
        showBalance();
    }

    public void withDraw() {
        System.out.println("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();
        if(amount <= balance) {
            System.out.println("You withdrew: " + amount);
            balance -= amount;
            showBalance();
        } else {
            System.out.println("Not enough funds on the account.");
            showBalance();
        }
    }
}
