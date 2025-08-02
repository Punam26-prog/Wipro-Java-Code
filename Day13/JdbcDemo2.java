package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String pwd = "Punam@2610";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found");
            e.printStackTrace();
            return;
        }

        try (Connection con = DriverManager.getConnection(url, userName, pwd);
             Statement st = con.createStatement()) {

            // Create table if not exists
            String user = "CREATE TABLE IF NOT EXISTS users1(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), number INT)";
            st.executeUpdate(user);
            System.out.println("Table users1 is ready in MySQL");

            // Insert data using batch
            String val = "INSERT INTO users1(name,number) VALUES(?,?)";
            try (PreparedStatement ps = con.prepareStatement(val)) {
                ps.setString(1, "sai");
                ps.setInt(2, 7671);
                ps.addBatch();

                ps.setString(1, "aryan");
                ps.setInt(2, 1234);
                ps.addBatch();

                int[] arr = ps.executeBatch();
                System.out.println("Inserted rows: " + arr.length);
            }

            // Select and display data
            String query = "SELECT * FROM users1";
            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int number = rs.getInt(3);
                    System.out.println("ID: " + id + " | Name: " + name + " | Number: " + number);
                }
            }

        } catch (SQLException e) {
            System.out.println("Data operation failed");
            e.printStackTrace();
        }
    }
}
