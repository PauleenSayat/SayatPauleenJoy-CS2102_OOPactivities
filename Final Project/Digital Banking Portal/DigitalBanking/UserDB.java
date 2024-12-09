import java.sql.*;

public class UserDB {
    public static String authenticateAndGetAccount(String username, String password) {
        String query = "SELECT Accounts.accountNumber FROM Users " +
                       "JOIN Accounts ON Users.userID = Accounts.userID " +
                       "WHERE Users.username = ? AND Users.password = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("accountNumber"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public static boolean register(String username, String password) {
        String insertUserQuery = "INSERT INTO Users (username, password) VALUES (?, ?)";
        String insertAccountQuery = "INSERT INTO Accounts (accountNumber, userID) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement userPs = conn.prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement accountPs = conn.prepareStatement(insertAccountQuery)) {

            userPs.setString(1, username);
            userPs.setString(2, password);
            int affectedRows = userPs.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("User registration failed.");
                return false;
            }

            ResultSet generatedKeys = userPs.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);

                // Generates random account number
                String accountNumber = generateAccountNumber();
                
                accountPs.setString(1, accountNumber);
                accountPs.setInt(2, userId);
                accountPs.executeUpdate();

                System.out.println("Registration successful! Your Account Number: " + accountNumber);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String generateAccountNumber() {
        int randomNumber = 100000000 + (int)(Math.random() * 900000000);
        return String.valueOf(randomNumber);
    }
}
