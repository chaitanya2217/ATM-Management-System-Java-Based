package ATM;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class adminRegistration extends JFrame implements ActionListener{
	
	JButton next;
	long random;
	JTextField nameText,contact,emailText,panText,adharText;
	JDateChooser dateChooser, hiredate;
	JRadioButton male,female;
	JComboBox comboDept, comboEducation, comboOccupation  ;
	JRadioButton yes, no, yes1, no1;
	

	JButton submit, close;
	
	String formno, accountType,cardnumber, pinnumber, facility;
	
	
	adminRegistration()
	{
		setLayout(null);
		Random ran = new Random();
		random = Math.abs((ran.nextLong()  % 9000L)+ 1000L);
		
		JLabel formno  = new JLabel("ADMIN APPLICATION FORM NO : "+ random);
		formno.setFont(new Font("Raleway", Font.BOLD, 28));
		formno.setBounds(170,20,600,40);
		add(formno);
		
		JLabel personDetails = new JLabel("Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 24));
		personDetails.setBounds(150,85,300,30);
		add(personDetails);
		
		JLabel name = new JLabel("Admin Name :");
		name.setFont(new Font("Raleway", Font.PLAIN, 20));
		name.setBounds(50,140,150,30);
		add(name);		
		nameText = new JTextField();
		nameText.setFont(new Font("Raleway", Font.PLAIN, 18));
		nameText.setBounds(200,140,200,30);
		add(nameText);
		
		
		JLabel contactNo = new JLabel("Contact No :");
		contactNo.setFont(new Font("Raleway", Font.PLAIN, 20));
		contactNo.setBounds(50,190,150,30);
		add(contactNo);		
		contact = new JTextField();
		contact.setFont(new Font("Raleway", Font.PLAIN, 18));
		contact.setBounds(200,190,200,30);
		add(contact);
 
		JLabel dob = new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway", Font.PLAIN, 20));
		dob.setBounds(50,240,150,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(200,240,200,30);
		dateChooser.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(dateChooser); 
		
				
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway", Font.PLAIN, 20));
		gender.setBounds(50,290,150,30);
		add(gender);
		male = new JRadioButton("Male");
		male.setFont(new Font("Raleway", Font.PLAIN, 15));
		male.setBackground(Color.white);
		male.setBounds(200,290,100,30);
		add(male);
		female = new JRadioButton("Female");
		female.setFont(new Font("Raleway", Font.PLAIN, 15));
		female.setBackground(Color.white);
		female.setBounds(300,290,100,30);
		add(female);
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
				
		
		JLabel email = new JLabel("Email Id :");
		email.setFont(new Font("Raleway", Font.PLAIN, 20));
		email.setBounds(50,340,150,30);
		add(email);		
		emailText = new JTextField();
		emailText.setFont(new Font("Raleway", Font.PLAIN, 18));
		emailText.setBounds(200,340,200,30);
		add(emailText);
		
		
		
		JLabel adhar = new JLabel("Adhar No :");
		adhar.setFont(new Font("Raleway", Font.PLAIN, 20));
		adhar.setBounds(50,400,150,30);
		add(adhar);
		adharText = new JTextField();
		adharText.setFont(new Font("Raleway", Font.PLAIN, 18));
		adharText.setBounds(200,400,200,30);
		add(adharText);
		
		
		JLabel pan = new JLabel("Pan No :");
		pan.setFont(new Font("Raleway", Font.PLAIN, 20));
		pan.setBounds(50,460,150,30);
		add(pan);
		panText = new JTextField();
		panText.setFont(new Font("Raleway", Font.PLAIN, 18));
		panText.setBounds(200,460,200,30);
		add(panText);
		

		
		
		JLabel personDetails1 = new JLabel("Admin Details");
		personDetails1.setFont(new Font("Raleway", Font.BOLD, 24));
		personDetails1.setBounds(535,85,300,30);
		add(personDetails1);
		
		
		JLabel religion = new JLabel("Hire Date :");
		religion.setFont(new Font("Raleway", Font.PLAIN, 20));
		religion.setBounds(450,140,100,30);
		add(religion);	
		
		
		hiredate = new JDateChooser();
		hiredate.setBounds(580,140,200,30);
		hiredate.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(hiredate);			
		
		JLabel income = new JLabel("Deparment:");
		income.setFont(new Font("Raleway", Font.PLAIN, 20));
		income.setBounds(450,190,110,30);
		add(income);
		String vardept[] = {"Director","Branch Manager","Genral Manager","Sr.Admin"};
		comboDept = new JComboBox(vardept);
		comboDept.setBounds(580,190,200,30);
		comboDept.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(comboDept);
		
		
		
		
				
		
	
		
		JLabel card = new JLabel("Admin No :");
		card.setFont(new Font("Raleway", Font.PLAIN, 20));
		card.setBounds(450,250,150,30);
		add(card);	
		
		JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-2217");
		cnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
		cnumber.setBounds(580,250,250,30);
		add(cnumber);	
		
		JLabel hint1 = new JLabel("Your 16 Digit card no.");
		hint1.setFont(new Font("Raleway", Font.PLAIN, 14));
		hint1.setBounds(450,280,250,30);
		add(hint1);	
		
		

		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Raleway", Font.PLAIN, 20));
		pin.setBounds(450,340,150,30);
		add(pin);
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
		pnumber.setBounds(580,340,100,30);
		add(pnumber);	
		
		JLabel hint2 = new JLabel("Your 4 Digit Pin");
		hint2.setFont(new Font("Raleway", Font.PLAIN, 14));
		hint2.setBounds(450,360,250,30);
		add(hint2);	
		

				
		submit = new JButton("Submit");
		submit.setFont(new Font("Raleway", Font.PLAIN, 20));
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(650,450,100,30);
		submit.addActionListener(this);
		add(submit);
		
		close = new JButton("Close");
		close.setFont(new Font("Raleway", Font.PLAIN, 20));
		close.setBackground(Color.BLACK);
		close.setForeground(Color.WHITE);
		close.setBounds(500,450,100,30);
		close.addActionListener(this);
		add(close);
		
		
		
		
		
	
				
		System.out.println(random);
		getContentPane().setBackground(Color.white); 
		setTitle("Sign Up new user... ICICI BANK");
		setSize(850,550);
		setVisible(true);
		setLocation(350,120);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==close)
		{
			new choiceLogin().setVisible(true);
			setVisible(false);
		 
		}
		
		else if(ae.getSource()==submit)
		{
		String formno = "" +random;
		String name = nameText.getText();
		String contactno = contact.getText();		
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
			if(male.isSelected())
			{
				gender = "Male";
			}
			else if(female.isSelected())
			{
				gender = "Female";
			}
		
		String email = emailText.getText();
		String span = panText.getText();
		String sadhar = adharText.getText();
		String hiredate = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		
		String deparment = (String)comboDept.getSelectedItem();
		Random random = new Random();
		cardnumber = ""+ Math.abs((random.nextLong() % 900))+ 1936L;
	
		pinnumber = ""+ Math.abs((random.nextLong() % 9000L)+  1000L);

		try
		{
			if (name.equals(""))
				{
					JOptionPane.showMessageDialog(null,"name is required");
				}
			else if(email.equals(""))
				{
					JOptionPane.showMessageDialog(null,"email must be required");
				}
			else
				{
					Conn c = new Conn();
					String query = "insert into adminRegistration values('"+formno+"','"+name+"','"+contactno+"','"+dob+"','"+gender+"','"+email+"',"
							+ "'"+span+"','"+sadhar+"','"+hiredate+"', '"+deparment+"' ,'"+cardnumber+"','"+pinnumber+"')";

					
					String query2 = "insert into adminlogin values('"+formno+"','"+cardnumber+"','"+pinnumber+"', '"+deparment+"')";
					c.s.executeUpdate(query);
					c.s.executeUpdate(query2);
					System.out.println("Data will be Inserted");
					setVisible(false);
					new Login().setVisible(true);
						
				
					new adminLogin().setVisible(true);
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}

	public static void main(String[] args) {
			new adminRegistration();
	
	}
	

}
