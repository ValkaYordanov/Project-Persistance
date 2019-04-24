package gui;

import controler.ProductCtr;
import model.Product;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.Customer;
import model.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;



public class menuProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txfProductName;
	//private JTextField txfCountry;
//	private JTextField txfNameOfSupplier;
	private static menuProduct frame;
	private JTextField txtRentPrice;
	private JTextField txtPurchasePrice;
	private JTextField txtNameOfSupplier;
	private JTextField txtSalePrice;

	
	private JTextField txtCountryOfOrigin;
	
	

	String[] fields = {"Name", "CountryOfOrigin", "NameOFSupplier"};
	
	int[] sizesArray = {150, 150, 150};
	
	String myStringError = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new menuProduct();
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
	public menuProduct() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(12, 2, 273, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProducts = new JLabel("Product");
		lblProducts.setForeground(new Color(255, 255, 255));
		lblProducts.setFont(new Font("Segoe UI Emoji", Font.BOLD, 31));
		lblProducts.setBounds(37, 60, 164, 52);
		panel.add(lblProducts);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 112, 193, 25);
		panel.add(separator);
		
		JLabel westerLabel = new JLabel("Western Style Ltd");
		westerLabel.setFont(new Font("Tekton Pro Ext", Font.BOLD, 24));
		westerLabel.setBounds(387, 13, 262, 32);
		contentPane.add(westerLabel);
		
		JPanel tittlePanel = new JPanel();
		tittlePanel.setBackground(new Color(51, 102, 153));
		tittlePanel.setBounds(282, 56, 918, 105);
		contentPane.add(tittlePanel);
		tittlePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create a new product");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tekton Pro Ext", Font.BOLD, 21));
		lblTitle.setBounds(246, 35, 409, 34);
		tittlePanel.add(lblTitle);
		
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setBackground(new Color(0, 0, 51));
		fieldsPanel.setBounds(283, 161, 917, 739);
		contentPane.add(fieldsPanel);
		fieldsPanel.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnCreate.setBackground(new Color(0, 102, 204));
		btnCreate.setBounds(215, 673, 371, 53);
		fieldsPanel.add(btnCreate);
		
		JPanel productInfoPanel = new JPanel();
		productInfoPanel.setForeground(new Color(255, 255, 255));
		productInfoPanel.setBackground(new Color(0, 0, 51));
		productInfoPanel.setBounds(40, 23, 717, 643);
		fieldsPanel.add(productInfoPanel);
		
		LineBorder roundedLineBorder = new LineBorder(Color.white, 2, true);
		TitledBorder personalBorder = new TitledBorder(roundedLineBorder,"Product information");
		personalBorder.setTitleJustification(TitledBorder.LEFT);
		personalBorder.setTitlePosition(TitledBorder.TOP);
		personalBorder.setTitleColor(Color.white);
		 
		productInfoPanel.setBorder(personalBorder);
		productInfoPanel.setLayout(null);
		
		JLabel lblRentPrice = new JLabel("Rent price");
		lblRentPrice.setBounds(381, 65, 86, 20);
		productInfoPanel.add(lblRentPrice);
		lblRentPrice.setForeground(new Color(0, 204, 255));
		lblRentPrice.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblPurchasePrice = new JLabel("Purchase price");
		lblPurchasePrice.setBounds(43, 202, 163, 16);
		productInfoPanel.add(lblPurchasePrice);
		lblPurchasePrice.setForeground(new Color(0, 204, 255));
		lblPurchasePrice.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblSalesPrice = new JLabel("Sales price");
		lblSalesPrice.setBounds(43, 350, 117, 16);
		productInfoPanel.add(lblSalesPrice);
		lblSalesPrice.setForeground(new Color(0, 204, 255));
		lblSalesPrice.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblNameOfSupplier = new JLabel("Name of supplier");
		lblNameOfSupplier.setBounds(381, 202, 163, 16);
		productInfoPanel.add(lblNameOfSupplier);
		lblNameOfSupplier.setForeground(new Color(0, 204, 255));
		lblNameOfSupplier.setFont(new Font("Verdana", Font.BOLD, 15));
		
		
		JLabel lblCountryOfOrigin = new JLabel("Country of origin ");
		lblCountryOfOrigin.setBounds(43, 481, 163, 16);
		productInfoPanel.add(lblCountryOfOrigin);
		lblCountryOfOrigin.setForeground(new Color(0, 204, 255));
		lblCountryOfOrigin.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(381, 136, 282, 16);
		productInfoPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(43, 281, 282, 16);
		productInfoPanel.add(separator_3);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(381, 281, 282, 16);
		productInfoPanel.add(separator_5);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(43, 425, 282, 16);
		productInfoPanel.add(separator_7);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(43, 67, 56, 16);
		productInfoPanel.add(lblName);
		lblName.setFont(new Font("Verdana", Font.BOLD, 15));
		lblName.setForeground(new Color(0, 204, 255));
		
		JLabel lblClose = new JLabel("");
		lblClose.setIcon(new ImageIcon(menuCustomer.class.getResource("/close.png")));
		lblClose.setBounds(1156, 13, 32, 25);
		contentPane.add(lblClose);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(43, 556, 282, 16);
		productInfoPanel.add(separator_6);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(43, 136, 282, 16);
		productInfoPanel.add(separator_1);
		
		txfProductName = new JTextField();
		txfProductName.setBounds(43, 95, 282, 35);
		productInfoPanel.add(txfProductName);
		txfProductName.setForeground(Color.WHITE);
		txfProductName.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfProductName.setColumns(10);
		txfProductName.setBorder(null);
		txfProductName.setBackground(new Color(0, 0, 51));
		
		/*txfName = new JTextField();
		txfName.setBounds(43, 95, 282, 35);
		productInfoPanel.add(txfName);
		txfName.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfName.setForeground(new Color(255, 255, 255));
		txfName.setBackground(new Color(0, 0, 51));
		txfName.setColumns(10);
		txfName.setBorder(null);
		*/
		txtRentPrice = new JTextField();
		txtRentPrice.setForeground(Color.WHITE);
		txtRentPrice.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtRentPrice.setColumns(10);
		txtRentPrice.setBorder(null);
		txtRentPrice.setBackground(new Color(0, 0, 51));
		txtRentPrice.setBounds(381, 95, 282, 35);
		productInfoPanel.add(txtRentPrice);
		
		txtPurchasePrice = new JTextField();
		txtPurchasePrice.setForeground(Color.WHITE);
		txtPurchasePrice.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtPurchasePrice.setColumns(10);
		txtPurchasePrice.setBorder(null);
		txtPurchasePrice.setBackground(new Color(0, 0, 51));
		txtPurchasePrice.setBounds(43, 234, 282, 35);
		productInfoPanel.add(txtPurchasePrice);
		
		txtNameOfSupplier = new JTextField();
		txtNameOfSupplier.setForeground(Color.WHITE);
		txtNameOfSupplier.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtNameOfSupplier.setColumns(10);
		txtNameOfSupplier.setBorder(null);
		txtNameOfSupplier.setBackground(new Color(0, 0, 51));
		txtNameOfSupplier.setBounds(381, 234, 282, 35);
		productInfoPanel.add(txtNameOfSupplier);
		
		txtSalePrice = new JTextField();
		txtSalePrice.setForeground(Color.WHITE);
		txtSalePrice.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtSalePrice.setColumns(10);
		txtSalePrice.setBorder(null);
		txtSalePrice.setBackground(new Color(0, 0, 51));
		txtSalePrice.setBounds(43, 378, 282, 35);
		productInfoPanel.add(txtSalePrice);
		
	
		
		txtCountryOfOrigin = new JTextField();
		txtCountryOfOrigin.setForeground(Color.WHITE);
		txtCountryOfOrigin.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtCountryOfOrigin.setColumns(10);
		txtCountryOfOrigin.setBorder(null);
		txtCountryOfOrigin.setBackground(new Color(0, 0, 51));
		txtCountryOfOrigin.setBounds(43, 510, 282, 35);
		productInfoPanel.add(txtCountryOfOrigin);
		
		/*TitledBorder addressBorder = new TitledBorder(roundedLineBorder,"Address Information");
		addressBorder.setTitleJustification(TitledBorder.LEFT);
		addressBorder.setTitlePosition(TitledBorder.TOP);
		addressBorder.setTitleColor(Color.white);
		
		TitledBorder aditionalBorder = new TitledBorder(roundedLineBorder,"Aditional Information");
		aditionalBorder.setTitleJustification(TitledBorder.LEFT);
		aditionalBorder.setTitlePosition(TitledBorder.TOP);
		aditionalBorder.setTitleColor(Color.white);
		*/
		
		JTextPane txtError = new JTextPane();
		txtError.setForeground(Color.RED);
		txtError.setBackground(new Color(0, 51, 102));
		txtError.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		txtError.setBounds(16, 451, 245, 383);
		panel.add(txtError);
		
		JLabel lblClientList = new JLabel("Product list");
		lblClientList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ProductList.main(null);
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
		
		
		
		
		btnCreate.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				txtError.setVisible(false);
				myStringError = "";
				
				String name = txfProductName.getText();
				String country = txtCountryOfOrigin.getText();
				String nameOfSupplier = txtNameOfSupplier.getText();
				double purchasePrice=Double.parseDouble(txtPurchasePrice.getText());
				double salesPrice=Double.parseDouble(txtSalePrice.getText());
				double rentPrice=Double.parseDouble(txtRentPrice.getText());
			
			
				
				
				
				String[] fieldsArray = {name, country, nameOfSupplier};
				
				
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
							ProductCtr myProduct = new ProductCtr();
							try {
								int minStock = 10;
								myProduct.insertProduct(name, purchasePrice, salesPrice, rentPrice, country,minStock, nameOfSupplier);
								txfProductName.setText("");
								txtPurchasePrice.setText("");
								txtSalePrice.setText("");
								txtRentPrice.setText("");
								txtCountryOfOrigin.setText("");
								txtNameOfSupplier.setText("");
								JOptionPane.showMessageDialog(null, "Product added successefully", "Success", 1);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					} 
					
		}
	
);
		
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



	