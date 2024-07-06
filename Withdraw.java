package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener{

	
	JButton close,withdrawbtn;
	JTextField withdrawText; 
	String pinnumber,cardnumber;
	Withdraw(String cardnumber, String pinnumber)
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
		
		JLabel note = new JLabel("Please Enter Withdraw Ammount");
		note.setBounds(145,210,300,30);
		note.setFont(new Font("System", Font.BOLD, 18));
		image.add(note);
		JLabel ano = new JLabel("Account No : "+cardnumber);
		ano.setBounds(150,235,290,30);
		ano.setFont(new Font("System", Font.BOLD, 16));
		image.add(ano);
		
		withdrawText  = new JTextField();
		withdrawText.setBounds(180,275,180,30);
		withdrawText.setForeground(Color.black);
		withdrawText.setBackground(Color.white);
		withdrawText.setFont(new Font("System", Font.BOLD, 16));
		image.add(withdrawText);
		
		withdrawbtn = new JButton("<< WithDraw");
		withdrawbtn.setBounds(300,350,180,30);
		withdrawbtn.setForeground(Color.black);
		withdrawbtn.setBackground(Color.gray);
		withdrawbtn.setFont(new Font("System", Font.BOLD, 16));
		withdrawbtn.addActionListener(this);
		image.add(withdrawbtn);	
		
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
		if(ae.getSource() == withdrawbtn)
		{			   
			String number = withdrawText.getText();
			Date date = new Date();
			if(withdrawText.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Deposit Amount ");
				//setVisible(false);
			}
			else  if(withdrawText.getText().length() !=0)
			{
				try 
				{
					Conn conn = new Conn();
					String query = "insert into bank values ('"+cardnumber+"','"+pinnumber+"', '"+date+"','Withdraw','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Successfully withdraw Rs :"+number);
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
		
		new Withdraw("","");

	}

}
