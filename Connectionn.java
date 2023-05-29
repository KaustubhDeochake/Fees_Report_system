package Com;

import java.sql.*;

public class Connectionn {
	Connection con;
	Statement st;
	Connectionn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","kaustubh2122");
			st=con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new Connectionn();
	}
}
