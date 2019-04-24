package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.CustomerCtr;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfName;
	private JTextField txfZipCode;
	private JTextField txfCity;
	private JTextField txfAddress;
	private JTextField txfPhoneNo;
	
	private static String cprNumber;
	private static String name;
	private static String address;
	private static String zipCode;
	private static String city;
	private static String phoneNo;
	
	static UpdateCustomer frame;
	
	String[] fields = {"Name","ZipCode", "City", "Address", "Phone Number"};
	
	int[] sizesArray = {100,150,15,30,15};
	
	String myStringError = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cprNumber = args[0];
					name = args[1];
					address = args[2];
					zipCode = args[3];
					city = args[4];
					phoneNo = args[5];
					frame = new UpdateCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateCustomer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 707, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCpr = new JLabel("");
		lblCpr.setForeground(Color.WHITE);
		lblCpr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		lblCpr.setBounds(382, 36, 170, 53);
		panel.add(lblCpr);
		
		lblCpr.setText(cprNumber);
		
		JLabel lblNewLabel = new JLabel("Update customer -");
		lblNewLabel.setBounds(215, 36, 181, 53);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		
		txfName = new JTextField();
		txfName.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfName.setForeground(new Color(255, 255, 255));
		txfName.setBackground(new Color(0, 0, 51));
		txfName.setBounds(84, 210, 188, 27);
		contentPane.add(txfName);
		txfName.setColumns(10);
		txfName.setBorder(null);
		
		txfName.setText(name);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(84, 242, 190, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Name");
		label.setForeground(new Color(0, 204, 255));
		label.setFont(new Font("Verdana", Font.BOLD, 15));
		label.setBounds(84, 181, 56, 16);
		contentPane.add(label);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 204, 255));
		lblAddress.setFont(new Font("Verdana", Font.BOLD, 15));
		lblAddress.setBounds(84, 439, 78, 16);
		contentPane.add(lblAddress);
		
		txfZipCode = new JTextField();
		txfZipCode.setForeground(Color.WHITE);
		txfZipCode.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfZipCode.setColumns(10);
		txfZipCode.setBorder(null);
		txfZipCode.setBackground(new Color(0, 0, 51));
		txfZipCode.setBounds(82, 339, 188, 27);
		contentPane.add(txfZipCode);
		
		txfZipCode.setText(zipCode);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(82, 371, 190, 2);
		contentPane.add(separator_2);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setForeground(new Color(0, 204, 255));
		lblZipCode.setFont(new Font("Verdana", Font.BOLD, 15));
		lblZipCode.setBounds(84, 306, 78, 16);
		contentPane.add(lblZipCode);
		
		txfCity = new JTextField();
		txfCity.setForeground(Color.WHITE);
		txfCity.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfCity.setColumns(10);
		txfCity.setBorder(null);
		txfCity.setBackground(new Color(0, 0, 51));
		txfCity.setBounds(383, 339, 188, 27);
		contentPane.add(txfCity);
		txfCity.setText(city);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(383, 371, 190, 2);
		contentPane.add(separator_3);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(0, 204, 255));
		lblCity.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCity.setBounds(383, 306, 56, 16);
		contentPane.add(lblCity);
		
		txfAddress = new JTextField();
		txfAddress.setForeground(Color.WHITE);
		txfAddress.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfAddress.setColumns(10);
		txfAddress.setBorder(null);
		txfAddress.setBackground(new Color(0, 0, 51));
		txfAddress.setBounds(84, 468, 188, 27);
		contentPane.add(txfAddress);
		
		txfAddress.setText(address);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(84, 500, 190, 2);
		contentPane.add(separator_4);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 204, 255));
		lblPhoneNumber.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPhoneNumber.setBounds(385, 439, 133, 16);
		contentPane.add(lblPhoneNumber);
		
		txfPhoneNo = new JTextField();
		txfPhoneNo.setForeground(Color.WHITE);
		txfPhoneNo.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfPhoneNo.setColumns(10);
		txfPhoneNo.setBorder(null);
		txfPhoneNo.setBackground(new Color(0, 0, 51));
		txfPhoneNo.setBounds(385, 468, 188, 27);
		contentPane.add(txfPhoneNo);
		txfPhoneNo.setText(phoneNo);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(385, 500, 190, 2);
		contentPane.add(separator_5);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				myStringError = "";
				
				String cusName = txfName.getText();
				String cusZipCode = txfZipCode.getText();
				String cusCity = txfCity.getText();
				String cusAddress = txfAddress.getText();
				String cusPhoneNo = txfPhoneNo.getText();
				
				String[] fieldsArray = {cusName, cusZipCode, cusCity, cusAddress, cusPhoneNo};
				
				
				for(int i = 0; i < fieldsArray.length; i++)
				{
					if(fieldsArray[i].length() > sizesArray[i] && fieldsArray[i].length() < 1) {
						myStringError += "\n ► Invalid number of characters in " + fields[i] + ". \n" +
								"Maximum allowed is: " + sizesArray[i] + "\n";
					}
				
				}
				if(myStringError != "") {
					JOptionPane.showMessageDialog(null, myStringError, "Invalid fields", 1);
				} else {
					
					CustomerCtr myCustomer = new CustomerCtr();
					try {
						myCustomer.updateEmp(cusName,cprNumber,cusAddress,cusZipCode,cusCity,cusPhoneNo);
						JOptionPane.showMessageDialog(null, "Customer updated successfully", "Success", 1);
						dispose();
						ClientList.printAllCustomers();
						//ClientList.main(null);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 23));
		btnNewButton.setBackground(new Color(102, 0, 204));
		btnNewButton.setForeground(new Color(255, 255, 255));

		btnNewButton.setBounds(195, 544, 270, 36);
		contentPane.add(btnNewButton);
	}
}
