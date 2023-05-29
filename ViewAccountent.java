package Com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewAccountent extends JFrame{
	String x[]={"Name","Password","Email","Contact no","Address"};
	String y[][]=new String[20][5];
	int i=0,j=0;
	JTable t;
	Font f;
	
	ViewAccountent() {
		super("Accountant information");
		setSize(800,400);
		setLocation(1, 1);
		f=new Font("MS UI Gothic",Font.BOLD,14);
		try {
			Connectionn co = new Connectionn();
			String q="Select * from accountant";
			ResultSet res=co.st.executeQuery(q);
			while(res.next())
			{
				y[i][j++]=res.getString("name");
				y[i][j++]=res.getString("password");
				y[i][j++]=res.getString("email");
				y[i][j++]=res.getString("contact");
				y[i][j++]=res.getString("address");
				i++;
				j=0;
			}
			t=new JTable(y,x);
			t.setFont(f);
		}catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane sp=new JScrollPane(t);
		add(sp);
	}
	public static void main(String[] args)
	{
		new ViewAccountent().setVisible(true);
	}
}
