package Com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class AddAccountent extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4;
	JPasswordField pf;
	JButton bt1,bt2,bt3;
	JPanel p1,p2;
	Font f,f1;
	AddAccountent() {
		super("Accountent Section");
		setLocation(100,100);
		setSize(800,370);
		
		l1=new JLabel("Add Accountant");
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setForeground(Color.BLUE);
		
		l2=new JLabel("Name");
		l3=new JLabel("Password");
		l4=new JLabel("Email");
		l5=new JLabel("Contact");
		l6=new JLabel("Address");
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		pf=new JPasswordField();
		
		bt1=new JButton("Add Accountent");
		bt2=new JButton("Back");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		f=new Font("Arial",Font.BOLD,24);
		f1=new Font("Arial",Font.BOLD,15);
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		bt1.setFont(f1);
		bt2.setFont(f1);
		tf1.setFont(f1);
		tf2.setFont(f1);
		tf3.setFont(f1);
		tf4.setFont(f1);
		pf.setFont(f1);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(6,2,10,10));
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(pf);
		p2.add(l4);
		p2.add(tf2);
		p2.add(l5);
		p2.add(tf3);
		p2.add(l6);
		p2.add(tf4);
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1)
		{
			String name=tf1.getText();
			String pass=pf.getText();
			String email=tf2.getText();
			String mob=tf3.getText();
			String add=tf4.getText();
			try {
				Connectionn ob=new Connectionn();
				String q="insert into  accountant(name,password,email,contact,address) values('"+name+"','"+pass+"','"+email+"','"+mob+"','"+add+"')";
				int a=ob.st.executeUpdate(q);
				if(a==1)
				{
					JOptionPane.showMessageDialog(null,"Your data successfully inserted");
					this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Your data not successfully inserted");
					this.setVisible(true);
				}
			}catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource()==bt2)
		{
			new AdminSection().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args)
	{
		new AddAccountent().setVisible(true);
	}

}
