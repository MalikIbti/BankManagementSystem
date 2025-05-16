package bank.management.system;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame {

	public MiniStatement(String pinnumber) {

		setTitle("Mini Statement");

		setLayout(null);

		JLabel mini = new JLabel();
		// text.setForeground(Color.WHITE);
		// text.setBounds(170, 300, 400, 30);
		add(mini);

		JLabel bank = new JLabel("Indian Bank");
		// text.setForeground(Color.WHITE);
		bank.setBounds(150, 20, 100, 20);
		add(bank);

		JLabel card = new JLabel();
		//mini.setForeground(Color.WHITE);
		card.setBounds(20, 80, 300, 20);
		
		add(card);
		
		JLabel balance = new JLabel();
		//mini.setForeground(Color.WHITE);
		balance.setBounds(20, 400, 320, 20);
		add(balance);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12) );
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
			
				String type = rs.getString("type").trim(); // Remove leading/trailing spaces
                int transactionAmount = Integer.parseInt(rs.getString("amount").trim());
                
                System.out.println("Transaction Type: " + type + ", Amount: " + transactionAmount);
                
                if (type.equalsIgnoreCase("Deposit")) {
                    bal += transactionAmount;
                } else if (type.equalsIgnoreCase("Withdrawl")) {
                    bal -= transactionAmount;
                }
			}
			balance.setText("Your current account balance is Rs: " +bal);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		mini.setBounds(20,140,400,200);

		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		// setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {

		new MiniStatement("");

	}

}
