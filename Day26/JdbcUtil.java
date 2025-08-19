package Day_26;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	 private Connection connection;
	    private java.sql.Statement statement;
	    private ResultSet resultSet;

	    public void connect(String dbUrl, String user, String pass) throws ClassNotFoundException, SQLException {
	        // Load MySQL JDBC driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Establish connection
	        connection = DriverManager.getConnection(dbUrl, user, pass);
	        // Create statement
	        statement = connection.createStatement();
	    }

	    public ResultSet executeQuery(String query) throws SQLException {
	        resultSet = statement.executeQuery(query);
	        return resultSet;
	    }

	    public void close() throws SQLException {
	        if (resultSet != null) resultSet.close();
	        if (statement != null) statement.close();
	        if (connection != null) connection.close();
	    }
}
