package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private final String serverName = "localhost";
    private final String dbName = "PolyOE";
    private final String portNumber = "3306";
    private final String userID = "root"; 
    private final String password = "12345"; 

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // Driver cho MySQL com.mysql.cj.jdbc.Driver (mysql-connector-j 8+)
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
        return DriverManager.getConnection(url, userID, password);
    }
    
    // Hàm main để test kết nối ngay lập tức
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
            System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
    }
}