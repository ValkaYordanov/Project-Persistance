package perssistanceProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.text.Element;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.Font;

public class mainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, -14, 650, 538);
		contentPane.add(imagePanel);
		
		JLabel imageMenu = new JLabel("");
		imageMenu.setIcon(new ImageIcon(mainMenu.class.getResource("/westernImage.jpg")));
		imagePanel.add(imageMenu);


	    
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setBounds(649, 0, 600, 524);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
	    
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setForeground(new Color(255, 255, 255));
		btnCustomers.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnCustomers.setBackground(new Color(0, 102, 204));
		btnCustomers.setBounds(117, 41, 371, 53);
		buttonPanel.add(btnCustomers);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setForeground(Color.WHITE);
		btnProducts.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnProducts.setBackground(new Color(0, 102, 204));
		btnProducts.setBounds(117, 141, 371, 53);
		buttonPanel.add(btnProducts);
		
		JButton btnSales = new JButton("Sales");
		btnSales.setForeground(Color.WHITE);
		btnSales.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnSales.setBackground(new Color(0, 102, 204));
		btnSales.setBounds(117, 246, 371, 53);
		buttonPanel.add(btnSales);
	}
}
