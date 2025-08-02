package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;
//1.We need to import a package
//2 load and register the driver - com.mysql.jdbc.driver
//3 establish the connection
//4 create the statements
//5 execute the query
//6 process results
//7 close the connection

public class JdbcDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc"; 
        String userName = "root";                      
        String pwd = "Punam@2610";                     
        String query = "SELECT * FROM sample";          

        try {
       
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);          
                String name = rs.getString(2);  
                String email = rs.getString(3); 
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

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