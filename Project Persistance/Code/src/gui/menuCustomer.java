package gui;

import controler.CustomerCtr;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;



public class menuCustomer extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txfName;
	private JTextField txfCpr;
	private JTextField txfAddress;
	private JTextField txfZipCode;
	private JTextField txfCity;
	private JTextField txfPhoneNo;
	private static menuCustomer frame;
	
	String[] fields = {"CPR", "Name","ZipCode", "City", "Address", "Phone Number"};
	
	int[] sizesArray = {11,100,150,15,30,15};
	
	String myStringError = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new menuCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public boolean checkCpr(String myString) {
		if(myString.matches("[0-9]{6}-[0-9]{4}")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Create the frame.
	 */
	public menuCustomer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setType(Type.UTILITY);
		setResizable(true);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(menuCustomer.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JLabel westerLabel = new JLabel("Western Style Ltd");
		westerLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
		westerLabel.setBounds(387, 13, 262, 32);
		contentPane.add(westerLabel);
		
		JPanel tittlePanel = new JPanel();
		tittlePanel.setBackground(new Color(51, 102, 153));
		tittlePanel.setBounds(373, 56, 827, 105);
		contentPane.add(tittlePanel);
		tittlePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create a new customer");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 21));
		lblTitle.setBounds(295, 33, 302, 34);
		tittlePanel.add(lblTitle);
		
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setBackground(new Color(0, 0, 51));
		fieldsPanel.setBounds(373, 161, 827, 739);
		contentPane.add(fieldsPanel);
		fieldsPanel.setLayout(null);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Verdana", Font.BOLD, 15));
		lblName.setForeground(new Color(0, 204, 255));
		lblName.setBounds(80, 77, 56, 16);
		fieldsPanel.add(lblName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(80, 140, 282, 16);
		fieldsPanel.add(separator_1);
		
		txfName = new JTextField();
		txfName.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfName.setForeground(new Color(255, 255, 255));
		txfName.setBackground(new Color(0, 0, 51));
		txfName.setBounds(80, 103, 282, 35);
		fieldsPanel.add(txfName);
		txfName.setColumns(10);
		txfName.setBorder(null);
		
		
		// ONE OF THE FUCKING BEAUTIFUL INPUT BOX WITH A LABEL; A SEPARATOR AND AN INPUT BOX
		JLabel lblCpr = new JLabel("CPR");
		lblCpr.setForeground(new Color(0, 204, 255));
		lblCpr.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCpr.setBounds(440, 78, 56, 16);
		fieldsPanel.add(lblCpr);
		
		txfCpr = new JTextField();
		txfCpr.setForeground(Color.WHITE);
		txfCpr.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfCpr.setColumns(10);
		txfCpr.setBorder(null);
		txfCpr.setBackground(new Color(0, 0, 51));
		txfCpr.setBounds(440, 104, 282, 35);
		fieldsPanel.add(txfCpr);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(440, 141, 282, 16);
		fieldsPanel.add(separator_2);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnCreate.setBackground(new Color(0, 102, 204));
		btnCreate.setBounds(215, 673, 371, 53);
		fieldsPanel.add(btnCreate);
		
		JPanel personInfoPanel = new JPanel();
		personInfoPanel.setForeground(new Color(255, 255, 255));
		personInfoPanel.setBackground(new Color(0, 0, 51));
		personInfoPanel.setBounds(40, 23, 717, 167);
		fieldsPanel.add(personInfoPanel);
		
		LineBorder roundedLineBorder = new LineBorder(Color.white, 2, true);
		TitledBorder personalBorder = new TitledBorder(roundedLineBorder,"Personal Information");
		personalBorder.setTitleJustification(TitledBorder.LEFT);
		personalBorder.setTitlePosition(TitledBorder.TOP);
		personalBorder.setTitleColor(Color.white);
		 
		personInfoPanel.setBorder(personalBorder);
		personInfoPanel.setLayout(null);
		
		JPanel AddressInformation = new JPanel();
		AddressInformation.setLayout(null);
		AddressInformation.setForeground(Color.WHITE);
		AddressInformation.setBackground(new Color(0, 0, 51));
		AddressInformation.setBounds(40, 235, 717, 266);
		fieldsPanel.add(AddressInformation);
		
		TitledBorder addressBorder = new TitledBorder(roundedLineBorder,"Address Information");
		addressBorder.setTitleJustification(TitledBorder.LEFT);
		addressBorder.setTitlePosition(TitledBorder.TOP);
		addressBorder.setTitleColor(Color.white);
		
		AddressInformation.setBorder(addressBorder);
		
		txfCity = new JTextField();
		txfCity.setBounds(398, 73, 282, 35);
		AddressInformation.add(txfCity);
		txfCity.setForeground(Color.WHITE);
		txfCity.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfCity.setColumns(10);
		txfCity.setBorder(null);
		txfCity.setBackground(new Color(0, 0, 51));
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(398, 110, 282, 16);
		AddressInformation.add(separator_5);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(398, 47, 56, 16);
		AddressInformation.add(lblCity);
		lblCity.setForeground(new Color(0, 204, 255));
		lblCity.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(40, 218, 282, 16);
		AddressInformation.add(separator_3);
		
		txfAddress = new JTextField();
		txfAddress.setBounds(40, 181, 282, 35);
		AddressInformation.add(txfAddress);
		txfAddress.setForeground(Color.WHITE);
		txfAddress.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfAddress.setColumns(10);
		txfAddress.setBorder(null);
		txfAddress.setBackground(new Color(0, 0, 51));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(40, 155, 83, 16);
		AddressInformation.add(lblAddress);
		lblAddress.setForeground(new Color(0, 204, 255));
		lblAddress.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblZipcode = new JLabel("Zipcode");
		lblZipcode.setBounds(40, 47, 282, 16);
		AddressInformation.add(lblZipcode);
		lblZipcode.setForeground(new Color(0, 204, 255));
		lblZipcode.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(40, 110, 282, 16);
		AddressInformation.add(separator_4);
		
		txfZipCode = new JTextField();
		txfZipCode.setBounds(40, 73, 282, 35);
		AddressInformation.add(txfZipCode);
		txfZipCode.setForeground(Color.WHITE);
		txfZipCode.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfZipCode.setColumns(10);
		txfZipCode.setBorder(null);
		txfZipCode.setBackground(new Color(0, 0, 51));
		
		JPanel aditionalPanel = new JPanel();
		aditionalPanel.setBackground(new Color(0, 0, 51));
		aditionalPanel.setBounds(40, 522, 722, 138);
		fieldsPanel.add(aditionalPanel);
		aditionalPanel.setLayout(null);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(41, 109, 282, 16);
		aditionalPanel.add(separator_6);
		
		txfPhoneNo = new JTextField();
		txfPhoneNo.setBounds(41, 72, 282, 35);

		txfPhoneNo.setForeground(Color.WHITE);
		txfPhoneNo.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfPhoneNo.setColumns(10);
		txfPhoneNo.setBorder(null);
		txfPhoneNo.setBackground(new Color(0, 0, 51));
		aditionalPanel.add(txfPhoneNo);
		
		TitledBorder aditionalBorder = new TitledBorder(roundedLineBorder,"Aditional Information");
		aditionalBorder.setTitleJustification(TitledBorder.LEFT);
		aditionalBorder.setTitlePosition(TitledBorder.TOP);
		aditionalBorder.setTitleColor(Color.white);
		
		aditionalPanel.setBorder(aditionalBorder);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(41, 46, 146, 16);
		aditionalPanel.add(lblPhoneNumber);
		lblPhoneNumber.setForeground(new Color(0, 204, 255));
		lblPhoneNumber.setFont(new Font("Verdana", Font.BOLD, 15));


		
		
		JLabel lblClose = new JLabel("");
		lblClose.setIcon(new ImageIcon(menuCustomer.class.getResource("/close.png")));
		lblClose.setBounds(1156, 13, 32, 25);
		contentPane.add(lblClose);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 373, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setForeground(new Color(255, 255, 255));
		lblCustomers.setFont(new Font("Segoe UI Emoji", Font.BOLD, 31));
		lblCustomers.setBounds(65, 52, 164, 52);
		panel.add(lblCustomers);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 112, 276, 25);
		panel.add(separator);
		
			
				JTextPane txtError = new JTextPane();
				txtError.setForeground(Color.RED);
				txtError.setBackground(new Color(0, 51, 102));
				txtError.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
				txtError.setBounds(16, 451, 327, 383);
				panel.add(txtError);
				
				JLabel lblClientList = new JLabel("Client list");
				lblClientList.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ClientList.main(null);
					}
				});
				lblClientList.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28));
				lblClientList.setForeground(Color.WHITE);
				lblClientList.setBounds(76, 194, 164, 73);
				panel.add(lblClientList);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(menuCustomer.class.getResource("/list.png")));
				label.setBounds(37, 212, 27, 32);
				panel.add(label);
		
		
		
		
		// ####################################################################################
		
		txfCpr.addKeyListener(new KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {

				if(e.getKeyCode() != e.VK_BACK_SPACE) {
					String text = txfCpr.getText();
					if(text.length() == 6) {
						txfCpr.setText(text + "-");
					}
					if(text.length() > 10) {
						Robot robot;
						try {
							robot = new Robot();
							robot.keyPress(KeyEvent.VK_BACK_SPACE);
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
	      });
		btnCreate.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtError.setVisible(false);
				myStringError = "";
				
				String cusCpr = txfCpr.getText();
				String cusName = txfName.getText();
				String cusZipCode = txfZipCode.getText();
				String cusCity = txfCity.getText();
				String cusAddress = txfAddress.getText();
				String cusPhoneNo = txfPhoneNo.getText();
				
				String[] fieldsArray = {cusCpr, cusName, cusZipCode, cusCity, cusAddress, cusPhoneNo};
				
				
				for(int i = 0; i < fieldsArray.length; i++)
				{
					if(fieldsArray[i].length() > sizesArray[i]) {
						myStringError += "\n ► Invalid number of characters in " + fields[i] + ". \n" +
								"Maximum allowed is: " + sizesArray[i] + "\n";
					}
				
				}
				if(myStringError != "") {
					txtError.setText(myStringError);
					txtError.setVisible(true);
				} else {
					if(checkCpr(cusCpr) == true) {
						if(cusName.equals("")) {
							myStringError += "\n ► The name can't be empty";
							txtError.setText(myStringError);
							txtError.setVisible(true);
							
						} else {
							CustomerCtr myCustomer = new CustomerCtr();
							try {
								myCustomer.insertCustomer(cusName, cusCpr, cusAddress, cusZipCode, cusCity, cusPhoneNo);
								txfCpr.setText("");
								txfName.setText("");
								txfZipCode.setText("");
								txfCity.setText("");
								txfAddress.setText("");
								txfPhoneNo.setText("");
								JOptionPane.showMessageDialog(null, "Customer added successefully", "Success", 1);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					} else {
						myStringError += "\n ► Invalid CPR format";
						txtError.setText(myStringError);
						txtError.setVisible(true);
					}
					
				}
			}
		});
		
		lblClose.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(frame == null) {
					System.out.println("Frame is null");
				} else {
					frame.dispose();
				}
				
			}
		});
		
	}
}


