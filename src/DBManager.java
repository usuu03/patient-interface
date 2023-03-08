import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public static void main(String[] args) {
        
		DBManager db = new DBManager();		
		db.testConnection();
	}
	
	private void testConnection() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "Rasengan6!");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM patients");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " - " + resultSet.getString("name") + " - " + resultSet.getString("age")
				+ " - " + resultSet.getString("gender") + " - " + resultSet.getString("phone") + " - " + resultSet.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}