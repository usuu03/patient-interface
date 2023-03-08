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
		System.out.println(db.Login("j.smith", "password2"));
	}
	
	public void testConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patients", "root", "groupa");// change to ur data base
			statement = connection.createStatement();
			// resultSet = statement.executeQuery("SELECT * FROM patients");
			// while (resultSet.next()) {
			// 	System.out.println(resultSet.getString("id") + " - " + resultSet.getString("name") + " - " + resultSet.getString("age")
			// 	+ " - " + resultSet.getString("gender") + " - " + resultSet.getString("phone") + " - " + resultSet.getString("email"));
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean Login(String username, String password) {
		try {
			resultSet = statement.executeQuery("SELECT username FROM users WHERE username = '" + username + "' AND password = '"+password+"'");
			if (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;		
		}

		return false;
		
	}
}