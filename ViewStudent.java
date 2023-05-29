package Com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewStudent extends JFrame{
	String x[]={"Roll no","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact no"};
	String y[][]=new String[20][12];
	int i=0,j=0;
	JTable t;
	Font f;
	
	ViewStudent() {
		super("Student information");
		setSize(1300,400);
		setLocation(1, 1);
		f=new Font("MS UI Gothic",Font.BOLD,14);
		try {
			Connectionn co = new Connectionn();
			String q="Select * from add_student";
			ResultSet res=co.st.executeQuery(q);
			while(res.next())
			{
				y[i][j++]=res.getString("rollno");
				y[i][j++]=res.getString("name");
				y[i][j++]=res.getString("email");
				y[i][j++]=res.getString("course");
				y[i][j++]=res.getString("fee");
				y[i][j++]=res.getString("paid");
				y[i][j++]=res.getString("due");
				y[i][j++]=res.getString("address");
				y[i][j++]=res.getString("city");
				y[i][j++]=res.getString("state");
				y[i][j++]=res.getString("country");
				y[i][j++]=res.getString("contact");
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
		new ViewStudent().setVisible(true);
	}

}
