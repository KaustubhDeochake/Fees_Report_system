package Com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener {
	JLabel l1;
	JButton bt1,bt2,bt3;
	JPanel p1;
	Font f,f1;
	AdminSection() {
		super("Admin Section");
		setLocation(100,100);
		setSize(400,270);
		
		l1=new JLabel("Admin Section");
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setForeground(Color.BLUE);
		
		bt1=new JButton("Add Accountent");
		bt2=new JButton("View Accountent");
		bt3=new JButton("Logout Admin");
		
		f=new Font("Arial",Font.BOLD,24);
		f1=new Font("Arial",Font.BOLD,15);
		
		l1.setFont(f);
		bt1.setFont(f1);
		bt2.setFont(f1);
		bt3.setFont(f1);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(4,1,10,10));
		p1.add(l1);
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"Center");

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1)
		{
			new AddAccountent().setVisible(true);
		}
		if(e.getSource()==bt2)
		{
			new ViewAccountent().setVisible(true);
		}
		if(e.getSource()==bt3)
		{
			this.setVisible(false);
			new Index().setVisible(true);
		}
			
			
				
	}
	public static void main(String[] args)
	{
		new AdminSection().setVisible(true);
	}
}
