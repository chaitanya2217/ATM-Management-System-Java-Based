package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class balancyEnquiry extends JFrame implements ActionListener{

	
	JButton close;
	String pinnumber,cardnumber;
		
	balancyEnquiry(String cardnumber, String pinnumber)
	{
		this.pinnumber =pinnumber;
		this.cardnumber =cardnumber;		
		setLayout(null);		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons///atm_ui.png"));
		Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,850,750);
		add(image);
		
		JLabel note = new JLabel("Check Your Account Balance");
		note.setBounds(145,210,300,30);
		note.setFont(new Font("System", Font.BOLD, 18));
		image.add(note);
		
		JLabel ano = new JLabel("Account No : "+cardnumber);
		ano.setBounds(150,235,290,30);
		ano.setFont(new Font("System", Font.BOLD, 16));
		image.add(ano);
		
			
		close = new JButton("<< Close");
		close.setBounds(300,385,180,30);
		close.setForeground(Color.black);
		close.setBackground(Color.gray);
		close.setFont(new Font("System", Font.BOLD, 16));
		close.addActionListener(this);
		image.add(close);	
		
		int balance=0;
		  try
          {
          	Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
			
       		while(rs.next())
				{
					if (rs.getString("transation_type").equals("Deposit"))
					{
						balance += Integer.parseInt(rs.getString("amount"));					
					}
					else
					{
						balance -=Integer.parseInt(rs.getString("amount"));
				    }
				}	
					 
				
          }
       	   catch(Exception e)
				{
				System.out.println(e);
				}
		
				
		  JLabel l1  = new JLabel("Account Balance : "+balance);
			l1.setBounds(180,275,280,30);
			l1.setForeground(Color.black);
			l1.setBackground(Color.white);
			l1.setFont(new Font("System", Font.BOLD, 16));
			image.add(l1);
		
		
		setSize(850,750);
		setLocation(350,50);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
						
			
		if(ae.getSource()==close)
		{
			new Transactions(cardnumber,pinnumber).setVisible(true);
			setVisible(false);
		}
	
	}
	public static void main(String[] args) {
		
		new balancyEnquiry("","");

	}

}
