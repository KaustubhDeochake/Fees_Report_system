package Com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class DueFee extends JFrame{
	String x[]= {"Roll No","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact"};
	String y[][]=new String[20][12];
	int i=0,j=0;
	JTable t;
	Font f,f1;
	DueFee()
	{
		super("Due Fees Student");
		setSize(1300,1400);
		setLocation(1,1);
		f=new Font("MS UI Gothic",Font.BOLD,15);
		try {
			Connectionn obj = new Connectionn();
			String q="select * from add_student where due>0";
			ResultSet res=obj.st.executeQuery(q);
			while(res.next()) {
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
	//public void actionPerformed(ActionEvent e)
	//{
		
	//}
	public static void main(String[] args)
	{
		new DueFee().setVisible(true);
	}
}
