package ATM;

import java.awt.*;
import java.sql.* ;
import java.awt.event.*;
import javax.swing.*;

public class miniStatement extends JFrame implements ActionListener{

	JButton login, signup, clear;
	JTextField cardText;
	JPasswordField pinText;
	JLabel card, mini;
	String pinnumber,cardnumber;
		
	miniStatement(String cardnumber, String pinnumber )
	{
		this.pinnumber =pinnumber;
		this.cardnumber =cardnumber;		
	
	
		setTitle("ICICI Bank, Rajgurunagar");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
		Image i2 = i1.getImage().getScaledInstance(300,70,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(30,10,300,70);
		//label.setBounds(70,10,100,40);
		add(label);
		
		JLabel welcome = new JLabel("Welcomes You..!");
		welcome.setFont(new Font("Osward", Font.ITALIC, 30));
		welcome.setBounds(120,90,300,40);
		add(welcome);
		

		card = new JLabel();
		card.setFont(new Font("Raleway", Font.BOLD, 20));
		add(card);
		
		mini = new JLabel();
		mini.setBounds(20,200,3000,100);
		mini.setBackground(Color.BLACK);
		add(mini);
		
		clear = new JButton("Close");
		clear.setBounds(150,400,90,25);
		clear.setForeground(Color.black);
		clear.setBackground(Color.gray);
		clear.setFont(new Font("System", Font.BOLD, 16));
		clear.addActionListener(this);
		
		add(clear);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'  ");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("card_Number"));   //.substring(0, 2) + "XXXX" + rs.getString("card_Number").substring(3));
                System.out.println("hi"); 
            }
        }catch(Exception e){
        	System.out.println(e);
        }
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where cardnumber = '"+cardnumber+"' ORDER BY date Asc  ");
            
             while(rs.next())
             {
            	System.out.println("hi1");
            	mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transation_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
                
            	if(rs.getString("transation_type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            JLabel finalbalance = new JLabel("Your Acount Balance is Rs "+balance);;
     		finalbalance.setBounds(20,350,300,30);
     		finalbalance.setBackground(Color.BLACK);
     		add(finalbalance);
     		
     		
        }catch(Exception e){
        	System.out.println(e);
            e.printStackTrace();
        }
        card.setBounds(20,150,300,30);
		
      
		setSize(400,500);
		setVisible(true);
		setLocation(850,180);
	}
		
		
		public void actionPerformed(ActionEvent ae)
		{
							
				
			if(ae.getSource()==clear)
			{
				setVisible(false);
				//new Transactions(cardnumber,pinnumber).setVisible(true);
				
			}
		
		}
		
		public static void main(String[] args) {
		new miniStatement("","");
		
		

	}

		

}
