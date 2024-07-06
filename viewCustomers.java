package ATM;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class viewCustomers extends JFrame implements ActionListener{

	JTable table;
	JButton add, search, print , update, cancel;
	Choice cardCombo;
	viewCustomers()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		search = new JButton("Search");
		search.setFont(new Font("Raleway", Font.PLAIN, 15));
		search.setForeground(Color.black);
		search.setBounds(60,60,100,20);
		search.addActionListener(this);
		add(search);
		
		JLabel h = new JLabel("Search By Card Number : ");
		h.setFont(new Font("Raleway", Font.PLAIN, 15));
		h.setForeground(Color.black);
		h.setBounds(60,20,180,20);
		add(h);
			
		String varNos[] = {""};
		cardCombo = new Choice();
		cardCombo.setBounds(240,20,150,20);
		cardCombo.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(cardCombo);
		
		add = new JButton("Add");
		add.setFont(new Font("Raleway", Font.PLAIN, 15));		
		add.setForeground(Color.black);
		add.setBounds(200,60,100,20);
		add.addActionListener(this);
		add(add);
		
		update = new JButton("Update");
		update.setFont(new Font("Raleway", Font.PLAIN, 15));
		update.setForeground(Color.black);
		update.setBounds(340,60,100,20);
		update.addActionListener(this);
		add(update);
		
		print = new JButton("Print");
		print.setFont(new Font("Raleway", Font.PLAIN, 15));
		print.setForeground(Color.black);
		print.setBounds(480,60,100,20);
		print.addActionListener(this);
		add(print);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Raleway", Font.PLAIN, 15));
		cancel.setForeground(Color.black);
		cancel.setBounds(620,60,100,20);
		cancel.addActionListener(this);
		add(cancel);
		
		try
		{
			Conn c = new Conn(); 
			ResultSet rs = c.s.executeQuery("Select * from signup");
			while(rs.next())
			{
				cardCombo.add(rs.getString("cardnumber"));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		table = new JTable();
		
		try
		{
			Conn c = new Conn(); 
			ResultSet rs = c.s.executeQuery("Select * from signup");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,100,1500,600);
		add(jsp);
		
		setSize(1500,700);
		setLocation(20,50);
		setVisible(true);
		
	}

public static void main(String[] args)
{
	new viewCustomers();
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == cancel )
	{
		try
		{
			Conn c = new Conn(); 
			ResultSet rs = c.s.executeQuery("Select * from signup");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		
	}
	else if(e.getSource() == search )
	{
		String query = "Select * from signup where cardnumber = '"+cardCombo.getSelectedItem()+"' ";
		try {
			Conn c = new Conn();
			ResultSet rs= c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception ae)
		{
			System.out.println(ae);
		}
	}
	else if(e.getSource() == print )
	{
		try {
			table.print();
		}catch(Exception ae) {
			System.out.println(ae);
		}
	}
	else if(e.getSource() == add )
	{
		//setVisible(false);
		new SignupOne().setVisible(true);
	}
	else if(e.getSource() == update )
	{
		setVisible(false);
		new SignupOne().setVisible(true);
	}
	
	
}
}