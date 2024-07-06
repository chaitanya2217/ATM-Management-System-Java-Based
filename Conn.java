package ATM;

import java.sql.*;

public class Conn  {
	
	Connection c;
	Statement s;
	
	public Conn()
	{
		try {
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","Tiger123");
			s = c.createStatement();		
			}
		
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}
}
