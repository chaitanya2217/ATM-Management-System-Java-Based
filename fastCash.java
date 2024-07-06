package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;

public class fastCash extends JFrame implements ActionListener{

	
	JButton deposit,withdraw,fastcash,changepin,close,ministatement,balance   ;
	String cardnumber, pinnumber;
	fastCash(String cardnumber, String pinnumber)
	{
		this.cardnumber=cardnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons///atm_ui.png"));
		Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,850,750);
		add(image);
		
		JLabel note = new JLabel("Please Select Amount ");
		note.setBounds(165,210,290,30);
		note.setFont(new Font("System", Font.BOLD, 18));
		image.add(note);
		JLabel ano = new JLabel("Account No : "+cardnumber);
		ano.setBounds(150,235,290,30);
		ano.setFont(new Font("System", Font.BOLD, 16));
		image.add(ano);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(90,275,140,30);
		deposit.setForeground(Color.black);
		deposit.setBackground(Color.gray);
		deposit.setFont(new Font("System", Font.BOLD, 16));
		deposit.addActionListener(this);
		image.add(deposit);
		
		ministatement = new JButton("Rs 200");
		ministatement.setBounds(300,275,180,30);
		ministatement.setForeground(Color.black);
		ministatement.setBackground(Color.gray);
		ministatement.setFont(new Font("System", Font.BOLD, 16));
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		withdraw = new JButton("Rs 500");
		withdraw.setBounds(90,315,140,30);
		withdraw.setForeground(Color.black);
		withdraw.setBackground(Color.gray);
		withdraw.setFont(new Font("System", Font.BOLD, 16));
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		balance = new JButton("Rs 1000");
		balance.setBounds(300,315,180,30);
		balance.setForeground(Color.black);
		balance.setBackground(Color.gray);
		balance.setFont(new Font("System", Font.BOLD, 16));
		balance.addActionListener(this);
		image.add(balance);
		
		fastcash = new JButton("Rs 5000");
		fastcash.setBounds(90,350,140,30);
		fastcash.setForeground(Color.black);
		fastcash.setBackground(Color.gray);
		fastcash.setFont(new Font("System", Font.BOLD, 16));
		fastcash.addActionListener(this);
		image.add(fastcash);	
		
		changepin = new JButton("Rs 10000");
		changepin.setBounds(300,350,180,30);
		changepin.setForeground(Color.black);
		changepin.setBackground(Color.gray);
		changepin.setFont(new Font("System", Font.BOLD, 16));
		changepin.addActionListener(this);
		image.add(changepin);	
		

		close = new JButton("<< Close");
		close.setBounds(300,385,180,30);
		close.setForeground(Color.black);
		close.setBackground(Color.gray);
		close.setFont(new Font("System", Font.BOLD, 16));
		close.addActionListener(this);
		image.add(close);	
		
		
		
		setSize(850,750);
		setLocation(350,50);
		setUndecorated(true);
		setVisible(true);
	}
	
	


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== close)
			{				
				setVisible(false);
				new Transactions(cardnumber,pinnumber).setVisible(true);
			}
		else
		{			   
			   String amount = ((JButton)ae.getSource()).getText().substring(3); 
	            Conn c = new Conn();
	            try
	            {
	            	ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
	            	int balance = 0;
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
					
					if(ae.getSource() != close && balance < Integer.parseInt(amount) )
					{
						JOptionPane.showMessageDialog(null,"Unable to Withdraw Rs : "+amount+"\nInsuffiecient Balance ");
						return;						
					}
					
					if(ae.getSource()== close)
					{
						setVisible(false);
					}
					else
					{
						Date date = new Date();					
						c.s.executeUpdate("insert into bank values('"+cardnumber+"','"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')");
						JOptionPane.showMessageDialog(null,"Debited Succesfully Rs : "+amount );
						setVisible(false);
						new Transactions(cardnumber,pinnumber).setVisible(true);
					}
	            }
				
			catch(Exception e)
			{
				System.out.println(e);	
				  e.printStackTrace();
			}		
		}
	}
		public static void main(String[] args) {
		
		new fastCash("","");

	}

}
