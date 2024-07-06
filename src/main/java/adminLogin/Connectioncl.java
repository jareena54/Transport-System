package adminLogin;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectioncl {
	static Connection con=null;
	
	public static Connection getcon() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","jareena","54");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
