
import java.util.Scanner;

public class DigitalBankingDB {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Digital Banking Portal ---");
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    System.out.println("Thank you for using the Digital Banking Portal! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        if (username.equals("AdminTester") && password.equals("AdminPass123")) {
            System.out.println("Admin login successful!");
            adminInterface();
        } else {
            // Authenticate and retrieve accountNumber
            String accountNumber = UserDB.authenticateAndGetAccount(username, password);
            if (accountNumber != null) {
                System.out.println("User login successful!");
                userInterface(accountNumber);
            } else {
                System.out.println("Invalid credentials. Please try again or sign up.");
            }
        }
    }
    

    private static void signUp() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter a new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter a new password: ");
        String newPassword = scanner.nextLine();

        if (newUsername.equals("AdminTester")) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        if (UserDB.register(newUsername, newPassword)) {
            System.out.println("Sign up successful! You can now log in.");
        } else {
            System.out.println("Sign up failed. Username might already exist.");
        }
    }

    private static void adminInterface() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Transactions");
            System.out.println("2. Log Out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number to view transactions: ");
                    scanner.nextLine();
                    String accountNumber = scanner.nextLine();
                    TransactionDB.viewTransactions(accountNumber);
                    break;
                case 2:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userInterface(String accountNumber) {
        AccountDB account = new AccountDB(accountNumber);
    
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Log Out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    TransactionDB.viewTransactions(accountNumber);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }    
}
