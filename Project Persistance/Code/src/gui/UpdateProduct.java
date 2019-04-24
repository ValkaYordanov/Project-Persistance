package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.ProductCtr;
import model.Product;

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

public class UpdateProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfName;
	private JTextField txfPurchasePrice;
	private JTextField txfSalesPrice;
	private JTextField txfRentPrice;
	private JTextField txfCountryOfOrigin;
	private JTextField txfNameOfSupplier;
	

	private static String id;
	private static int prodId;
	private static String name;
	private static double purchasePrice;
	private static double salesPrice;
	private static double rentPrice;
	private static String country;
	private static String nameOfSupplier;
	

	
	static UpdateProduct frame;
	
	String[] fields = {"Name","CountryOfOrigin", "NameOfSupplier"};
	
	int[] sizesArray = {150,150,150};
	
	String myStringError = "";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					id=args[0];
					frame = new UpdateProduct();
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
	public UpdateProduct() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 791);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 787, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		lblName.setBounds(382, 36, 170, 53);
		panel.add(lblName);
		//lblName.setText(name);
		
		JLabel lblNewLabel = new JLabel("Update Product -");
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
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(84, 240, 190, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Name");
		label.setForeground(new Color(0, 204, 255));
		label.setFont(new Font("Verdana", Font.BOLD, 15));
		label.setBounds(84, 180, 56, 16);
		contentPane.add(label);
		
		JLabel lblRentPrice = new JLabel("Rent Price");
		lblRentPrice.setForeground(new Color(0, 204, 255));
		lblRentPrice.setFont(new Font("Verdana", Font.BOLD, 15));
		lblRentPrice.setBounds(436, 181, 148, 16);
		contentPane.add(lblRentPrice);
		
		txfPurchasePrice = new JTextField();
		txfPurchasePrice.setForeground(Color.WHITE);
		txfPurchasePrice.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfPurchasePrice.setColumns(10);
		txfPurchasePrice.setBorder(null);
		txfPurchasePrice.setBackground(new Color(0, 0, 51));
		txfPurchasePrice.setBounds(82, 335, 188, 27);
		contentPane.add(txfPurchasePrice);
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(82, 365, 190, 2);
		contentPane.add(separator_2);
		
		JLabel lblPurchasePrice = new JLabel("Purchase Price");
		lblPurchasePrice.setForeground(new Color(0, 204, 255));
		lblPurchasePrice.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPurchasePrice.setBounds(84, 305, 148, 16);
		contentPane.add(lblPurchasePrice);
		
		txfSalesPrice = new JTextField();
		txfSalesPrice.setForeground(Color.WHITE);
		txfSalesPrice.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfSalesPrice.setColumns(10);
		txfSalesPrice.setBorder(null);
		txfSalesPrice.setBackground(new Color(0, 0, 51));
		txfSalesPrice.setBounds(84, 460, 188, 27);
		contentPane.add(txfSalesPrice);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(84, 490, 190, 2);
		contentPane.add(separator_3);
		
		JLabel lblSalesPrice = new JLabel("Sales Price");
		lblSalesPrice.setForeground(new Color(0, 204, 255));
		lblSalesPrice.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSalesPrice.setBounds(84, 430, 135, 16);
		contentPane.add(lblSalesPrice);
		
		txfRentPrice = new JTextField();
		txfRentPrice.setForeground(Color.WHITE);
		txfRentPrice.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfRentPrice.setColumns(10);
		txfRentPrice.setBorder(null);
		txfRentPrice.setBackground(new Color(0, 0, 51));
		txfRentPrice.setBounds(436, 210, 188, 27);
		contentPane.add(txfRentPrice);
		
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(434, 240, 190, 2);
		contentPane.add(separator_4);
		
		JLabel lblCountryOfOrigin = new JLabel("Country of origin");
		lblCountryOfOrigin.setForeground(new Color(0, 204, 255));
		lblCountryOfOrigin.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCountryOfOrigin.setBounds(84, 555, 164, 16);
		contentPane.add(lblCountryOfOrigin);
		
		txfCountryOfOrigin = new JTextField();
		txfCountryOfOrigin.setForeground(Color.WHITE);
		txfCountryOfOrigin.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfCountryOfOrigin.setColumns(10);
		txfCountryOfOrigin.setBorder(null);
		txfCountryOfOrigin.setBackground(new Color(0, 0, 51));
		txfCountryOfOrigin.setBounds(84, 585, 188, 27);
		contentPane.add(txfCountryOfOrigin);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(84, 615, 190, 2);
		contentPane.add(separator_5);
		
		JLabel lblNameOfSupplier = new JLabel("Name of supplier");
		lblNameOfSupplier.setForeground(new Color(0, 204, 255));
		lblNameOfSupplier.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNameOfSupplier.setBounds(434, 305, 164, 16);
		contentPane.add(lblNameOfSupplier);
		
		txfNameOfSupplier = new JTextField();
		txfNameOfSupplier.setText((String) null);
		txfNameOfSupplier.setForeground(Color.WHITE);
		txfNameOfSupplier.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		txfNameOfSupplier.setColumns(10);
		txfNameOfSupplier.setBorder(null);
		txfNameOfSupplier.setBackground(new Color(0, 0, 51));
		txfNameOfSupplier.setBounds(434, 335, 188, 27);
		contentPane.add(txfNameOfSupplier);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(434, 365, 190, 2);
		contentPane.add(separator_1);
		
		ProductCtr myProduct=new ProductCtr();
		Product prod=myProduct.findById(id);
		name=prod.getName();
		purchasePrice=prod.getPurchasePrice();
		salesPrice=prod.getSalesPrice();
		rentPrice=prod.getRentPrice();
		country=prod.getCountryOfOrigin();
		nameOfSupplier=prod.getNameOfSupplier();
		
		lblName.setText(name);
		
		String sPurchasePrice = String.valueOf(purchasePrice);
		String sSalesPrice = String.valueOf(salesPrice);
		String sRentPrice = String.valueOf(rentPrice);
		
		txfName.setText(name);
		txfPurchasePrice.setText(sPurchasePrice);
		txfSalesPrice.setText(sSalesPrice);
		txfRentPrice.setText(sRentPrice);
		txfCountryOfOrigin.setText(country);
		txfNameOfSupplier.setText(nameOfSupplier);
		
		prodId=Integer.parseInt(id);
		
		JButton btnNewButton = new JButton("Save");
		
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				myStringError = "";
				
				String prodName = txfName.getText();
				//String prodPurchasePrice = txfPurchasePrice.getText();
				//String prodSalesPrice = txfSalesPrice.getText();
				//String prodRentPrice = txfRentPrice.getText();
				String prodCountryOfOrigin = txfCountryOfOrigin.getText();
				String prodNameOfSupplier = txfNameOfSupplier.getText();
				
				String[] fieldsArray = {prodName, prodCountryOfOrigin,prodNameOfSupplier};
				
				
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
					
					ProductCtr myProduct = new ProductCtr();
					try {
						myProduct.updateProduct(prodId,prodName,purchasePrice,salesPrice,rentPrice,prodCountryOfOrigin, prodNameOfSupplier);
						txfName.setText("");
						txfPurchasePrice.setText("");
						txfSalesPrice.setText("");
						txfRentPrice.setText("");
						txfCountryOfOrigin.setText("");
						txfNameOfSupplier.setText("");
						JOptionPane.showMessageDialog(null, "Product updated successfully", "Success", 1);
						dispose();
						ProductList.printAllProducts();
						
						
						
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

		btnNewButton.setBounds(242, 705, 270, 36);
		contentPane.add(btnNewButton);
		
		
	}
}
