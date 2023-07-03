package connection;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connectionn {
	 static Connection conn;
	 static	DataSource ds;

	public static DataSource connectorMet() throws NamingException {
		
			Context context = new InitialContext();
			DataSource ds;
			ds = (DataSource)context.lookup("java:comp/env/jdbc/bank");
			
			return ds; 

		
		
		
	}
	public   Connection getConnection() throws NamingException {
		try {
			conn=connectorMet().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
