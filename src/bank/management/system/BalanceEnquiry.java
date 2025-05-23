package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnumber;
	
	public BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		 Conn c = new Conn();
		 int balance = 0;
	        try {
	            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
	          
	            while (rs.next()) {
	                String type = rs.getString("type").trim(); // Remove leading/trailing spaces
	                int transactionAmount = Integer.parseInt(rs.getString("amount").trim());
	                
	                //System.out.println("Transaction Type: " + type + ", Amount: " + transactionAmount);
	                
	                if (type.equalsIgnoreCase("Deposit")) {
	                    balance += transactionAmount;
	                } else if (type.equalsIgnoreCase("Withdrawl")) {
	                    balance -= transactionAmount;
	                }
	            }
	        }catch(Exception e){
	        	System.out.println(e);
	        }
	        
	        JLabel text = new JLabel("Your current account balance is Rs "+ balance);
	        text.setForeground(Color.WHITE);
	        text.setBounds(170,300,400,30);
	        image.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}

	public static void main(String[] args) {

		new BalanceEnquiry("");
	}

}
