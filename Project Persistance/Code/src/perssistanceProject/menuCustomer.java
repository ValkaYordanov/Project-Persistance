package perssistanceProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class menuCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField txfName;
	private JTextField txfCpr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCustomer frame = new menuCustomer();
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
	public menuCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 373, 852);
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
		
		JLabel lblCreateCustomer = new JLabel("Create Customer");
		lblCreateCustomer.setForeground(Color.WHITE);
		lblCreateCustomer.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
		lblCreateCustomer.setBounds(65, 234, 210, 52);
		panel.add(lblCreateCustomer);
		
		
		JLabel lblListAllCustomers = new JLabel("List Customer");
		lblListAllCustomers.setForeground(Color.WHITE);
		lblListAllCustomers.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
		lblListAllCustomers.setBounds(65, 309, 174, 52);
		panel.add(lblListAllCustomers);
		
		JLabel lblDeleteCustomer = new JLabel("Delete Customer");
		lblDeleteCustomer.setForeground(Color.WHITE);
		lblDeleteCustomer.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
		lblDeleteCustomer.setBounds(65, 386, 210, 52);
		panel.add(lblDeleteCustomer);
		
		JLabel plus = new JLabel("");
		plus.setIcon(new ImageIcon(menuCustomer.class.getResource("/plus.png")));
		plus.setBounds(16, 244, 36, 28);
		panel.add(plus);
		
		JLabel list = new JLabel("");
		list.setIcon(new ImageIcon(menuCustomer.class.getResource("/list.png")));
		list.setBounds(19, 322, 24, 22);
		panel.add(list);
		
		JLabel remove = new JLabel("");
		remove.setIcon(new ImageIcon(menuCustomer.class.getResource("/remove.png")));
		remove.setBounds(16, 398, 33, 23);
		panel.add(remove);
		
		JLabel westerLabel = new JLabel("Western Style Ltd");
		westerLabel.setFont(new Font("Tekton Pro Ext", Font.BOLD, 24));
		westerLabel.setBounds(387, 13, 262, 32);
		contentPane.add(westerLabel);
		
		JPanel tittlePanel = new JPanel();
		tittlePanel.setBackground(new Color(51, 102, 153));
		tittlePanel.setBounds(373, 56, 809, 105);
		contentPane.add(tittlePanel);
		tittlePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create a new customer");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tekton Pro Ext", Font.BOLD, 21));
		lblTitle.setBounds(246, 35, 409, 34);
		tittlePanel.add(lblTitle);
		
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setBackground(new Color(0, 0, 51));
		fieldsPanel.setBounds(373, 161, 809, 693);
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
		
		lblCreateCustomer.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				lblTitle.setText("Create a new customer");
			}
		});
		lblListAllCustomers.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				lblTitle.setText("Customers list");
			}
		});
		lblDeleteCustomer.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				lblTitle.setText("Delete Customer");
			}
		});
		
	}
}
