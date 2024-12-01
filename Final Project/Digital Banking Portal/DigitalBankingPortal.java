package project;
import java.util.ArrayList;
import java.util.Scanner;

//Main class
public class DigitalBankingPortal {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static Account userAccount = new Account("123456789", 500.00);
    private static final String ADMIN_USERNAME = "AdminTester";
    private static final String ADMIN_PASSWORD = "AdminPass123";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users.add(new User("user1", "password123"));

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
                    scanner.close();
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

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Admin login successful!");
            adminInterface();
        } else {
            User currentUser = authenticateUser(username, password);

            if (currentUser != null) {
                System.out.println("User login successful!");
                userInterface(currentUser);
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

        // Check if the username matches admin credentials
        if (newUsername.equals(ADMIN_USERNAME)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        // Check if the username is already taken
        if (usernameExists(newUsername)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            users.add(new User(newUsername, newPassword));
            System.out.println("Sign up successful! You can now log in.");
        }
    }


    private static boolean usernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                return user;
            }
        }
        return null;
    }

    private static void adminInterface() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Users");
            System.out.println("2. View All Transactions");
            System.out.println("3. Log Out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    viewAllTransactions();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userInterface(User currentUser) {
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
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    userAccount.displayBalance();
                    break;
                case 4:
                    viewTransactions();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("\n--- Registered Users ---");
            for (User user : users) {
                System.out.println("Username: " + user.getUsername());
            }
        }
    }

    private static void viewAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\n--- All Transactions ---");
            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        transactions.add(new Transaction(generateTransactionId(), "Deposit", amount));
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
        transactions.add(new Transaction(generateTransactionId(), "Withdraw", amount));
    }

    private static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }

    private static String generateTransactionId() {
        return "TXN" + (transactions.size() + 1);
    }
}
