package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private String driver = "org.postgresql.Driver";
	private String host = "jdbc:postgresql://localhost:5432/bd_java_projeto04";
	private String user = "postgres";
	private String password = "coti";
	
	public Connection getConnection() throws Exception{
		
		Class.forName(driver);
		
		return DriverManager.getConnection(host, user, password);
	}

}
