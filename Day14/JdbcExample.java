package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root"; 
        String password = "Punam@2610"; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String insertQuery = "INSERT INTO students(name, age) VALUES('Alice', 22)";
            stmt.executeUpdate(insertQuery);
            System.out.println("Inserted student.");
            String selectQuery = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(selectQuery);
            System.out.println("Students:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }

            String updateQuery = "UPDATE students SET age = 23 WHERE name = 'Alice'";
            stmt.executeUpdate(updateQuery);
            System.out.println("Updated student age.");
            String deleteQuery = "DELETE FROM students WHERE name = 'Alice'";
            stmt.executeUpdate(deleteQuery);
            System.out.println("Deleted student.");
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
