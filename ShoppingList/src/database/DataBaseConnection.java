package database;

import java.sql.*; 

public class DataBaseConnection {
	
	static Connection connection;
    static String host = "192.168.0.15"; 
    static String port = "3306"; 
    static String user = "scqian"; 
    static String password = "Chengkun321";
    static String database = "INVENTORY"; 
	
	public DataBaseConnection() {
		connection = null;
		OpenConnection();
	}
	
	private void OpenConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			
			connection = DriverManager.getConnection
					( "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&" + "password=" + password);
			
		} catch (SQLException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
        catch (ClassNotFoundException e) { 
            System.out.println("Connection Failed");
            e.printStackTrace(); 
        }
	}
	
	public static void closeConnection() throws SQLException {
		connection.close();
	}
	
	
	//Allows Execution of a Query
	public ResultSet executeQuery(String command) throws SQLException{
		if(connection == null) System.out.println("Connection failed");
		Statement stmt = connection.createStatement();
		ResultSet rs = null;
		if (command.startsWith("SELECT")) {
			rs = stmt.executeQuery(command);
		}
		else if (command.startsWith("UPDATE")||command.startsWith("INSERT")||
			command.startsWith("DELETE")) {
			stmt.executeUpdate(command, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
		}
		else {
			stmt.execute(command, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
		}
		return rs;
	}
}
