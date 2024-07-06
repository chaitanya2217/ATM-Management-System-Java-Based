package ATM;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

	
	JButton close,depositbtn;
	String pinnumber,cardnumber;
	JTextField depositText;
	Deposit(String cardnumber,String pinnumber)
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
		
		JLabel note = new JLabel("Please Enter Deposit Ammount");
		note.setBounds(145,210,300,30);
		note.setFont(new Font("System", Font.BOLD, 18));
		image.add(note);
		JLabel ano = new JLabel("Account No : "+cardnumber);
		ano.setBounds(150,235,290,30);
		ano.setFont(new Font("System", Font.BOLD, 16));
		image.add(ano);
		
		depositText  = new JTextField();
		depositText.setBounds(180,275,180,30);
		depositText.setForeground(Color.black);
		depositText.setBackground(Color.white);
		depositText.setFont(new Font("System", Font.BOLD, 16));
		image.add(depositText);
		
		depositbtn = new JButton("<< Deposit");
		depositbtn.setBounds(300,350,180,30);
		depositbtn.setForeground(Color.black);
		depositbtn.setBackground(Color.gray);
		depositbtn.setFont(new Font("System", Font.BOLD, 16));
		depositbtn.addActionListener(this);
		image.add(depositbtn);	
		
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
		
		if(ae.getSource() == depositbtn)
		{
			   
			String number = depositText.getText();
			Date date = new Date();
			if(depositText.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Deposit Amount ");
				//setVisible(false);
			}
			else  if(depositText.getText().length() !=0)
			{
				try 
				{
					Conn conn = new Conn();
					String query = "insert into bank values ('"+cardnumber+"','"+pinnumber+"', '"+date+"','Deposit','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Successfully deposited Rs :"+number);
					setVisible(false);
					new Transactions(cardnumber,pinnumber).setVisible(true);
					}
				catch(Exception e)
				{
				System.out.println(e);
				}
			}
		}	
		else if(ae.getSource()== close)
		{				
			setVisible(false);
			new Transactions(cardnumber,pinnumber).setVisible(true);
		}
	
	}




	public static void main(String[] args) {
		
		new Deposit("","");

	}

}
