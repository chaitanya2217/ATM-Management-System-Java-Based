package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class choiceLogin extends JFrame implements ActionListener {

	JButton login, custBtn, adminBtn;
	JTextField cardText;
	JPasswordField pinText;
	
	choiceLogin()
	{
		setTitle("ICICI Bank, Rajgurunagar");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
		Image i2 = i1.getImage().getScaledInstance(550,100,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(80,10,550,100);
		//label.setBounds(70,10,100,40);
		add(label);		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/admin_logo.png"));
		Image i5 = i4.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
		JLabel label1 = new JLabel(i6);
		label1.setBounds(70,140,300,150);
		add(label1);
		
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/customerIcon.png"));
		Image i12 = i11.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
		ImageIcon i13= new ImageIcon(i12);
		JLabel label2 = new JLabel(i13);
		label2.setBounds(330,140,300,150);
		add(label2);
		
		
		
		
		adminBtn = new JButton("Admin Login");
		adminBtn.setBounds(100,300,230,40);
		adminBtn.setBackground(Color.BLACK);
		adminBtn.setForeground(Color.WHITE);
		adminBtn.setFont(new Font("Osward", Font.PLAIN, 25));
		adminBtn.addActionListener(this);
		add(adminBtn);
						
		
		custBtn = new JButton("Customer Login");
		custBtn.setBounds(370,300,230,40);
		custBtn.setBackground(Color.BLACK);
		custBtn.setForeground(Color.WHITE);
		custBtn.setFont(new Font("Osward", Font.PLAIN, 25));
		custBtn.addActionListener(this);
		add(custBtn);
			
		getContentPane().setBackground(Color.white);
		
		setSize(700,400);
		setVisible(true);
		setLocation(420,200);		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource() == adminBtn)
		{
			System.out.println("admin");
			new adminLogin().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource() == custBtn)
		{
			System.out.println("customer");
			new Login().setVisible(true);
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new choiceLogin();
		
		

	}

}
