package ATM;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class adminLogin extends JFrame implements ActionListener  {
	
	JButton login, signup, clear, back;
	JTextField cardText;
	JPasswordField pinText;
	
	adminLogin()
	{
		setTitle("Admin Login, ICICI Bank, Rajgurunagar ");
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
		label1.setBounds(-20,140,300,150);
		add(label1);
		
		
		

		JLabel cardNo = new JLabel("Admin No :");
		cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
		cardNo.setBounds(230,150,200,30);
		add(cardNo);
		
		cardText = new JTextField();
		cardText.setFont(new Font("Raleway", Font.PLAIN, 24));
		cardText.setBounds(400,150,200,35);
		add(cardText);
		
		JLabel pinNo = new JLabel("Pin :");
		pinNo.setFont(new Font("Raleway", Font.BOLD, 28));
		pinNo.setBounds(280,210,400,40);
		add(pinNo);
		
		pinText = new JPasswordField();
		pinText.setFont(new Font("Raleway", Font.PLAIN, 35));
		pinText.setBounds(400,210,200,35);
		add(pinText);
		
		
		back = new JButton("BACK");
		back.setBounds(210,280,80,35);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
						
		clear = new JButton("CLEAR");
		clear.setBounds(310,280,80,35);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		login = new JButton("LOG IN");
		login.setBounds(410,280,90,35);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		signup = new JButton("SIGN UP ADMIN");
		signup.setBounds(530,280,130,35);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);

		getContentPane().setBackground(Color.white);
		
		setSize(700,400);
		setVisible(true);
		setLocation(420,200);
			
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource() == clear)
		{
			cardText.setText("");
			pinText.setText("");
		}
		else if(ae.getSource() == back)
		{
			setVisible(false);
			new choiceLogin().setVisible(true);
		}
		else if(ae.getSource() == login)
		{
			Conn conn = new Conn();
			String cardnumber = cardText.getText();
			String pinnumber = pinText.getText();
			
			String query = "Select * from adminlogin where admin_id = '"+cardnumber+"' and pin = '"+pinnumber+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if (rs.next())
				{
					setVisible(false);
					new viewCustomers().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Details");				
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource() == signup)
		{
			new adminRegistration().setVisible(true);
			setVisible(false);
		}
		
	}


	public static void main(String[] args) {
		
		new adminLogin();

	}
	
	
}
