package bank.management.system;

import java.sql.*;

//	Register the driver
//	create connection
//	create statement
//	execute query
//	close connection

public class Conn {
	
	Connection c;
	Statement s;
	public Conn() {
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
			s = c.createStatement();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
