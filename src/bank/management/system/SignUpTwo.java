package bank.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
	
	long random;
	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion, category, income, education, occupation;
	String formno;
	
	public SignUpTwo(String formno) {
		this.formno = formno;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - pAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Others"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		JLabel fname = new JLabel("Category:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		String valCategory[] = {"General","OBC","SC","ST","Others"};
		category = new JComboBox(valCategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		
		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		

		String incomeCategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		income = new JComboBox(incomeCategory);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		String educationValue[] = {"Non graduation","Graduation","Post-Graduation","Doctorate","Others"};
		education = new JComboBox(educationValue);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		
		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 315, 200, 30);
		add(email);
		
		JLabel marital = new JLabel("Occupation:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		String occupationValue[] = {"Salaried","Self-employed","Businessman","Student","Retired","Others"};
		occupation = new JComboBox(occupationValue);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		JLabel address = new JLabel("PAN No:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		
		JLabel city = new JLabel("Aadhar No:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(syes);
		maritalgroup.add(sno);
		

		JLabel pin = new JLabel("Existing Account:");
		pin.setFont(new Font("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 590, 200, 30);
		add(pin);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		maritalgroup = new ButtonGroup();
		maritalgroup.add(eyes);
		maritalgroup.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 700, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String seniorcitizen = null;
		if(syes.isSelected()) {
			seniorcitizen = "Yes";
		}
		else if(sno.isSelected()) {
			seniorcitizen = "No";
		}
		
		String existingaccount = null;
		if(eyes.isSelected()) {
			existingaccount = "Yes";
		}
		else if(eno.isSelected()) {
			existingaccount = "No";
		}
	
	String span = pan.getText();
	String saadhar = aadhar.getText();
	
	try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query);
			
	//signupthree
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			
	} catch(Exception e) {
		System.out.println(e);
	}
		
	}


	public static void main(String[] args) {

		new SignUpTwo("");
	}

}
