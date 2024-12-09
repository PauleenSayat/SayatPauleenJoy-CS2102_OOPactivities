
import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/digital_banking";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Bsu23-09920";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

