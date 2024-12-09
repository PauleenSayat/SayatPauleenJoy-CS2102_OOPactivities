
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDB {
    private String accountNumber;

    public AccountDB(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        String updateBalance = "UPDATE Accounts SET balance = balance + ? WHERE accountNumber = ?";
        String insertTransaction = "INSERT INTO Transactions (transactionType, amount, accountID) " +
                "SELECT 'Deposit', ?, accountID FROM Accounts WHERE accountNumber = ?";

        try (Connection conn = DatabaseManager.getConnection()) {
            // Update balance
            PreparedStatement update = conn.prepareStatement(updateBalance);
            update.setDouble(1, amount);
            update.setString(2, accountNumber);
            update.executeUpdate();

            // Record transaction
            PreparedStatement insert = conn.prepareStatement(insertTransaction);
            insert.setDouble(1, amount);
            insert.setString(2, accountNumber);
            insert.executeUpdate();

            System.out.println("Successfully deposited: $" + amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(double amount) {
        String updateBalance = "UPDATE Accounts SET balance = balance - ? WHERE accountNumber = ? AND balance >= ?";
        String insertTransaction = "INSERT INTO Transactions (transactionType, amount, accountID) " +
                "SELECT 'Withdraw', ?, accountID FROM Accounts WHERE accountNumber = ?";

        try (Connection conn = DatabaseManager.getConnection()) {
            // Update balance if sufficient funds
            PreparedStatement update = conn.prepareStatement(updateBalance);
            update.setDouble(1, amount);
            update.setString(2, accountNumber);
            update.setDouble(3, amount);
            int rowsAffected = update.executeUpdate();

            if (rowsAffected > 0) {
                // Record transaction
                PreparedStatement insert = conn.prepareStatement(insertTransaction);
                insert.setDouble(1, amount);
                insert.setString(2, accountNumber);
                insert.executeUpdate();

                System.out.println("Successfully withdrew: $" + amount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayBalance() {
        String query = "SELECT balance FROM Accounts WHERE accountNumber = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Current balance: $" + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
