package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc"; // Your DB name is jdbc
        String userName = "root";                       // MySQL username
        String pwd = "Punam@2610";                      // MySQL password
        String query = "SELECT * FROM sample";          // Table to fetch data

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, userName, pwd);

            // Create Statement
            Statement st = con.createStatement();

            // Execute Query
            ResultSet rs = st.executeQuery(query);

            // Loop through ResultSet
            while (rs.next()) {
                int id = rs.getInt(1);          // Column 1
                String name = rs.getString(2);  // Column 2
                String email = rs.getString(3); // Column 3

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // Close resources
            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
    }
}