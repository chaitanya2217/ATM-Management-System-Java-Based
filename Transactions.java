package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

	
	JButton deposit,withdraw,fastcash,changepin,close,ministatement,balance   ;
	String cardnumber, pinnumber;
	Transactions(String cardnumber, String pinnumber)
	{
		this.cardnumber=cardnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons///atm_ui.png"));
		Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,850,750);
		add(image);
		
		JLabel note = new JLabel("Please Select Your Transaction ");
		note.setBounds(145,210,290,30);
		note.setFont(new Font("System", Font.BOLD, 18));
		image.add(note);
		JLabel ano = new JLabel("Account No : "+cardnumber);
		ano.setBounds(150,235,290,30);
		ano.setFont(new Font("System", Font.BOLD, 16));
		image.add(ano);
		
		deposit = new JButton("Deposit >>");
		deposit.setBounds(90,275,140,30);
		deposit.setForeground(Color.black);
		deposit.setBackground(Color.gray);
		deposit.setFont(new Font("System", Font.BOLD, 16));
		deposit.addActionListener(this);
		image.add(deposit);
		
		ministatement = new JButton("<< Mini Statement");
		ministatement.setBounds(300,275,180,30);
		ministatement.setForeground(Color.black);
		ministatement.setBackground(Color.gray);
		ministatement.setFont(new Font("System", Font.BOLD, 16));
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		withdraw = new JButton("Withdraw >>");
		withdraw.setBounds(90,315,140,30);
		withdraw.setForeground(Color.black);
		withdraw.setBackground(Color.gray);
		withdraw.setFont(new Font("System", Font.BOLD, 16));
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		balance = new JButton("<< Balance Check");
		balance.setBounds(300,315,180,30);
		balance.setForeground(Color.black);
		balance.setBackground(Color.gray);
		balance.setFont(new Font("System", Font.BOLD, 16));
		balance.addActionListener(this);
		image.add(balance);
		
		fastcash = new JButton("Fast Cash >>");
		fastcash.setBounds(90,350,140,30);
		fastcash.setForeground(Color.black);
		fastcash.setBackground(Color.gray);
		fastcash.setFont(new Font("System", Font.BOLD, 16));
		fastcash.addActionListener(this);
		image.add(fastcash);	
		
		changepin = new JButton("<< Change Pin");
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
		if(ae.getSource() == withdraw )
		{
			new Withdraw(cardnumber, pinnumber).setVisible(true);
			setVisible(false);
			
		}
		else if(ae.getSource() == deposit)
		{
			new Deposit(cardnumber, pinnumber).setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource() == fastcash)
		{
			new fastCash(cardnumber, pinnumber).setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource() == changepin)
		{
			new PinChange(cardnumber, pinnumber).setVisible(true);
			setVisible(false);		
		}
		else if(ae.getSource() == balance)
		{
			new balancyEnquiry(cardnumber, pinnumber).setVisible(true);
			setVisible(false);		
		}
		else if(ae.getSource() == ministatement)
		{
			new miniStatement(cardnumber,pinnumber).setVisible(true);
					
		}	else if(ae.getSource()== close)
		{	
			setVisible(false);
			new Login().setVisible(true);
			
			
		}

		
	}
	public static void main(String[] args) {
		
		new Transactions("","");

	}

}
