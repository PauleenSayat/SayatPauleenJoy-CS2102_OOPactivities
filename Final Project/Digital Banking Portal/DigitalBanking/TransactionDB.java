
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDB {
    public static void viewTransactions(String accountNumber) {
        String query = "SELECT transactionID, transactionType, amount, timestamp FROM Transactions " +
                       "WHERE accountID = (SELECT accountID FROM Accounts WHERE accountNumber = ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Transaction History ---");
            while (rs.next()) {
                System.out.println("Transaction ID: " + rs.getInt("transactionID") +
                                   ", Type: " + rs.getString("transactionType") +
                                   ", Amount: $" + rs.getDouble("amount") +
                                   ", Timestamp: " + rs.getTimestamp("timestamp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
