package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class PinChange extends JFrame implements ActionListener{

	
	JPasswordField newpinText , repinText;
	JButton close, changePin;
	String cardnumber, pinnumber;
	PinChange(String cardnumber, String pinnumber)
	{
		this.cardnumber=cardnumber;
		this.pinnumber=pinnumber;
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
		
		JLabel l1 = new JLabel(" Enter new PIN : ");
		l1.setBounds(140,275,140,30);
		l1.setForeground(Color.black);
		l1.setBackground(Color.gray);
		l1.setFont(new Font("System", Font.BOLD, 16));
		image.add(l1);
		
		newpinText = new JPasswordField();
		newpinText.setBounds(300,275,180,30);
		newpinText.setForeground(Color.black);
		newpinText.setBackground(Color.white);
		newpinText.setFont(new Font("System", Font.BOLD, 16));
		image.add(newpinText);
		
		JLabel l2 = new JLabel(" Re-Enter new PIN :");
		l2.setBounds(140,315,200,30);
		l2.setForeground(Color.black);
		l2.setBackground(Color.gray);
		l2.setFont(new Font("System", Font.BOLD, 16));
		image.add(l2);
		
		repinText = new JPasswordField();
		repinText.setBounds(300,315,180,30);
		repinText.setForeground(Color.black);
		repinText.setBackground(Color.white);
		repinText.setFont(new Font("System", Font.BOLD, 16));
		image.add(repinText);
		
		changePin = new JButton("<< Change PIN");
		changePin.setBounds(300,350,180,30);
		changePin.setForeground(Color.black);
		changePin.setBackground(Color.gray);
		changePin.setFont(new Font("System", Font.BOLD, 16));
		changePin.addActionListener(this);
		image.add(changePin);	
		

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
		if(ae.getSource() == changePin)
		{
			try
			{
				String npin = newpinText.getText();
				String repin = repinText.getText();
				
				
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter New Pin");
					return;
				}
				if(repin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Re-Enter New pin");
					return;
				}
				if(!npin.equals(repin))
				{
					JOptionPane.showMessageDialog(null,"Enterd Pin Dosent Match!!");
					return;
				}
				Conn conn = new Conn();
				String query1 = ("update login set pin = '"+repin+"' where pin = '"+pinnumber+"' ");
				
				conn.s.executeUpdate(query1);
				JOptionPane.showMessageDialog(null,"Pin Changed Succesfully");
				new Transactions(cardnumber,repin).setVisible(true);
				setVisible(false);
					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else if(ae.getSource() == close)
		{
			setVisible(false);
			new Transactions(cardnumber,pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		
		new PinChange("","");

	}

}
