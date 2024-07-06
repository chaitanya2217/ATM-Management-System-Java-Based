package ATM;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
	
	JButton next;
	long random;
	JTextField nameText,contact,emailText,pinText, stateText,addressText,cityText;
	JDateChooser dateChooser;
	JRadioButton male,female, maried,unmaried;
	JComboBox comboIncome, comboReligion ,comboEducation, comboOccupation  ;
	JRadioButton yes, no, yes1, no1;
	JTextField panText,adharText;

	JButton submit,close;
	JRadioButton savingAcc,creditAcc, salaryAcc, loanDebitAcc;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	String formno, accountType,cardnumber, pinnumber, facility;
	
	
	SignupOne()
	{
		setLayout(null);
		Random ran = new Random();
		random = Math.abs((ran.nextLong()  % 9000L)+ 1000L);
		
		JLabel formno  = new JLabel("APPLICATION FORM NO : "+ random);
		formno.setFont(new Font("Raleway", Font.BOLD, 28));
		formno.setBounds(420,20,600,40);
		add(formno);
		
		JLabel personDetails = new JLabel("Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 24));
		personDetails.setBounds(150,85,300,30);
		add(personDetails);
		
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway", Font.PLAIN, 20));
		name.setBounds(50,140,100,30);
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
		
		
		
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway", Font.PLAIN, 20));
		address.setBounds(50,400,150,30);
		add(address);		
		addressText = new JTextField();
		addressText.setFont(new Font("Raleway", Font.PLAIN, 18));
		addressText.setBounds(200,400,200,30);
		add(addressText);
					
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway", Font.PLAIN, 20));
		state.setBounds(50,460,150,30);
		add(state);		
		stateText = new JTextField();
		stateText.setFont(new Font("Raleway", Font.PLAIN, 18));
		stateText.setBounds(200,460,200,30);
		add(stateText);
		
		
		JLabel pincode = new JLabel("Pincode :");
		pincode.setFont(new Font("Raleway", Font.PLAIN, 20));
		pincode.setBounds(50,510,150,30);
		add(pincode);		
		pinText = new JTextField();
		pinText.setFont(new Font("Raleway", Font.PLAIN, 18));
		pinText.setBounds(200,510,200,30);
		add(pinText);
			
		
		
		JLabel personDetails1 = new JLabel("Additional Details");
		personDetails1.setFont(new Font("Raleway", Font.BOLD, 24));
		personDetails1.setBounds(515,85,300,30);
		add(personDetails1);
		
		
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway", Font.PLAIN, 20));
		religion.setBounds(450,140,100,30);
		add(religion);	
		
		String varreligion[] = {"Hindu","Muslim","Shikh","Parsi"};
		comboReligion = new JComboBox(varreligion);
		comboReligion.setBounds(580,140,200,30);
		comboReligion.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(comboReligion);			
		
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway", Font.PLAIN, 20));
		income.setBounds(450,190,100,30);
		add(income);
		String varIncome[] = {"Null","<150000","<250000","<500000","<750000","<1000000"};
		comboIncome = new JComboBox(varIncome);
		comboIncome.setBounds(580,190,200,30);
		comboIncome.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(comboIncome);
		
		
		
		JLabel education = new JLabel("Educational ");
		education.setFont(new Font("Raleway", Font.PLAIN, 20));
		education.setBounds(450,255,150,30);
		add(education);		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway", Font.PLAIN, 20));
		qualification.setBounds(450,285,150,30);
		add(qualification);
		String varEducation[] = {"HSC","SSC","Graduate","Post-Graduate","M-Phil","PHD"};
		comboEducation = new JComboBox(varEducation);
		comboEducation.setBounds(580,265,200,30);
		comboEducation.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(comboEducation);
		
		
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway", Font.PLAIN, 20));
		occupation.setBounds(450,340,150,30);
		add(occupation);	
		String varOccupation[] = {"Student","Salaried","Self-Employed","Bussiness","Retaired","other"};
		comboOccupation = new JComboBox(varOccupation);
		comboOccupation.setFont(new Font("Raleway", Font.PLAIN, 18));
		comboOccupation.setBounds(580,340,200,30);
		add(comboOccupation);
		
		
		
		JLabel pan = new JLabel("Pan No :");
		pan.setFont(new Font("Raleway", Font.PLAIN, 20));
		pan.setBounds(450,400,150,30);
		add(pan);
		panText = new JTextField();
		panText.setFont(new Font("Raleway", Font.PLAIN, 18));
		panText.setBounds(580,400,200,30);
		add(panText);
		

		JLabel adhar = new JLabel("Adhar No :");
		adhar.setFont(new Font("Raleway", Font.PLAIN, 20));
		adhar.setBounds(450,460,150,30);
		add(adhar);
		adharText = new JTextField();
		adharText.setFont(new Font("Raleway", Font.PLAIN, 18));
		adharText.setBounds(580,460,200,30);
		add(adharText);
		
		
		
		JLabel seniorCitizen = new JLabel("Senior Citizen :");
		seniorCitizen.setFont(new Font("Raleway", Font.PLAIN, 20));
		seniorCitizen.setBounds(450,510,150,30);
		add(seniorCitizen);	
		yes = new JRadioButton("Yes");
		yes.setFont(new Font("Raleway", Font.PLAIN, 15));
		yes.setBackground(Color.white);
		yes.setBounds(600,510,100,30);
		add(yes);
		no = new JRadioButton("No");
		no.setFont(new Font("Raleway", Font.PLAIN, 15));
		no.setBackground(Color.white);
		no.setBounds(700,510,100,30);
		add(no);
		ButtonGroup gendergroup1 = new ButtonGroup();
		gendergroup1.add(yes);
		gendergroup1.add(no);
		
		
			
		
		
		personDetails1 = new JLabel("Account Details");
		personDetails1.setFont(new Font("Raleway", Font.BOLD, 24));
		personDetails1.setBounds(950,85,300,30);
		add(personDetails1);
		
		
		JLabel acType = new JLabel("Account Type :");
		acType.setFont(new Font("Raleway", Font.PLAIN, 20));
		acType.setBounds(830,140,150,30);
		add(acType);	
		
		savingAcc = new JRadioButton("Saving Account");
		savingAcc.setFont(new Font("Raleway", Font.PLAIN, 16));
		savingAcc.setBackground(Color.white);
		savingAcc.setBounds(980,140,150,30);
		add(savingAcc);
		creditAcc = new JRadioButton("Credit Account");
		creditAcc.setFont(new Font("Raleway", Font.PLAIN, 16));
		creditAcc.setBackground(Color.white);
		creditAcc.setBounds(1130,140,150,30);
		add(creditAcc);
		salaryAcc = new JRadioButton("Salary Account");
		salaryAcc.setFont(new Font("Raleway", Font.PLAIN, 16));
		salaryAcc.setBackground(Color.white);
		salaryAcc.setBounds(980,180,150,30);
		add(salaryAcc);
		loanDebitAcc = new JRadioButton("Loan Account");
		loanDebitAcc.setFont(new Font("Raleway", Font.PLAIN, 16));
		loanDebitAcc.setBackground(Color.white);
		loanDebitAcc.setBounds(1130,180,200,30);
		add(loanDebitAcc);

		ButtonGroup accGroup = new ButtonGroup();
		accGroup.add(savingAcc);
		accGroup.add(creditAcc);
		accGroup.add(salaryAcc);
		accGroup.add(loanDebitAcc);
		
		
		JLabel card = new JLabel("Card No :");
		card.setFont(new Font("Raleway", Font.PLAIN, 20));
		card.setBounds(830,230,150,30);
		add(card);	
		
		JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-2217");
		cnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
		cnumber.setBounds(1000,230,250,30);
		add(cnumber);	
		
		JLabel hint1 = new JLabel("Your 16 Digit card no.");
		hint1.setFont(new Font("Raleway", Font.PLAIN, 14));
		hint1.setBounds(830,250,250,30);
		add(hint1);	
		
		

		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Raleway", Font.PLAIN, 20));
		pin.setBounds(830,300,150,30);
		add(pin);
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
		pnumber.setBounds(1000,300,100,30);
		add(pnumber);	
		
		JLabel hint2 = new JLabel("Your 4 Digit Pin");
		hint2.setFont(new Font("Raleway", Font.PLAIN, 14));
		hint2.setBounds(830,320,250,30);
		add(hint2);	
		
		
		JLabel service = new JLabel("Services Required :");
		service.setFont(new Font("Raleway", Font.PLAIN, 20));
		service.setBounds(830,380,200,30);
		add(service);
		
		JLabel hint3 = new JLabel("Select Options");
		hint3.setFont(new Font("Raleway", Font.PLAIN, 14));
		hint3.setBounds(830,400,250,30);
		add(hint3);	
		
		c1 = new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway", Font.PLAIN, 16));
		c1.setBackground(Color.white);
		c1.setBounds(1050,380,150,30);
		add(c1);	
		c2 = new JCheckBox("Credit Card");
		c2.setFont(new Font("Raleway", Font.PLAIN, 16));
		c2.setBackground(Color.white);
		c2.setBounds(1050,380,200,30);
		add(c2);	
		c3 = new JCheckBox("SMS & Email Alerts");
		c3.setFont(new Font("Raleway", Font.PLAIN, 16));
		c3.setBackground(Color.white);
		c3.setBounds(1050,410,190,30);
		add(c3);	
		c4 = new JCheckBox("Net Banking");
		c4.setFont(new Font("Raleway", Font.PLAIN, 16));
		c4.setBackground(Color.white);
		c4.setBounds(1050,440,150,30);
		add(c4);
		c5 = new JCheckBox("Check Book");
		c5.setFont(new Font("Raleway", Font.PLAIN, 16));
		c5.setBackground(Color.white);
		c5.setBounds(1050,470,150,30);
		add(c5);
		c6= new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway", Font.PLAIN, 16));
		c6.setBackground(Color.white);
		c6.setBounds(1050,500,150,30);
		add(c6);	
		
		

		c7= new JCheckBox("I hereby declares tha the above entered details are correct to best of my knowledge ");
		c7.setFont(new Font("Raleway", Font.PLAIN, 14));
		c7.setBackground(Color.white);
		c7.setBounds(360,550,600,30);
		add(c7);	
			
		
		
		
				
		close = new JButton("Close");
		close.setFont(new Font("Raleway", Font.PLAIN, 20));
		close.setBackground(Color.BLACK);
		close.setForeground(Color.WHITE);
		close.setBounds(500,580,100,30);
		close.addActionListener(this);
		add(close);
		
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Raleway", Font.PLAIN, 20));
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(650,580,100,30);
		submit.addActionListener(this);
		add(submit);
		
		
		
		
		
	
				
		System.out.println(random);
		getContentPane().setBackground(Color.white); 
		setTitle("Sign Up new user... ICICI BANK");
		setSize(1300,670);
		setVisible(true);
		setLocation(100,50);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == close)
		{
			setVisible(false);
			new choiceLogin().setVisible(true);
		}
		else 
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
		String address = addressText.getText();		
		String state = stateText.getText();
		String pincode = pinText.getText();
		String sreligion = (String)comboReligion.getSelectedItem();
		String sincome = (String)comboIncome.getSelectedItem();
		String squalification = (String)comboEducation.getSelectedItem();
		String soccupation = (String)comboIncome.getSelectedItem();
		String span = panText.getText();
		String sadhar = adharText.getText();
		String seniorCitizen = "NA";
			if(yes.isSelected())
			{
				seniorCitizen = "Yes";
			}
			else if(no.isSelected())
			{
				seniorCitizen = "No";
			}
			if(ae.getSource() == submit)
			{
		accountType = "NA" ;
				if(savingAcc.isSelected())
					accountType = "Saving";
				else if(creditAcc.isSelected())
					accountType = "Credit";
				else if(salaryAcc.isSelected())
					accountType = "Salary";
				else if(loanDebitAcc.isSelected())
					accountType = "Loan Debit";
				
		Random random = new Random();
		cardnumber = ""+ Math.abs((random.nextLong() % 900))+ 1936L;
	
		pinnumber = ""+ Math.abs((random.nextLong() % 9000L)+  1000L);
		
		facility = "";
		if(c1.isSelected())
			facility = facility + "ATM card";

		else if(c2.isSelected())
			facility = facility + "Credit card";
		
		else if(c3.isSelected())
			facility = facility + "SMS &  Email Alerts";
		
		else if(c4.isSelected())
			facility = facility + "Net Banking";
		
		else if(c5.isSelected())
			facility = facility + "Check Book";
		
		else if(c6.isSelected())
		{	facility = facility + "E-Statemnt"; 
			}
		}		
		try
		{
			if(accountType.equals("")){
				JOptionPane.showMessageDialog(null,"Select Account Type");
			}else if (name.equals("")){
					JOptionPane.showMessageDialog(null,"name is required");
			}else if(email.equals("")){
					JOptionPane.showMessageDialog(null,"email must be required");
				}
			else {
					Conn c = new Conn();
					String query = "insert into signup values('"+formno+"','"+name+"','"+contactno+"','"+dob+"','"+gender+"','"+email+"','"+address+"',"
							+ "'"+state+"','"+pincode+"','"+sreligion+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+span+"','"+sadhar+"',"
							+ "'"+seniorCitizen+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					c.s.executeUpdate(query);
					c.s.executeUpdate(query2);
					System.out.println("Data will be Inserted");
					JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber+ "\nPin Number : "+pinnumber);
					setVisible(false);
					new Login().setVisible(true);				
				//	new SignupOne().setVisible(true);
				}
			} 
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	public static void main(String[] args) {
			new SignupOne();
	
	}

}
