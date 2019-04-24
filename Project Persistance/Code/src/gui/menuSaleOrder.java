package gui;

import controler.ProductCtr;
import controler.saleOrderCtr;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import model.Customer;
import model.Product;
import model.SaleOrder;

import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;



public class menuSaleOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static menuSaleOrder frame;
	private JTextField txfCpr;
	private int myID;
	Object[][] data = null;
	DefaultTableModel model;
	JComboBox<String> cbbProducts;
	
	saleOrderCtr mySaleOrder = new saleOrderCtr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new menuSaleOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public menuSaleOrder() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setType(Type.UTILITY);
		setResizable(true);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(menuSaleOrder.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(12, 0, 273, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomers = new JLabel("Sale");
		lblCustomers.setForeground(new Color(255, 255, 255));
		lblCustomers.setFont(new Font("Segoe UI Emoji", Font.BOLD, 31));
		lblCustomers.setBounds(65, 52, 165, 57);
		panel.add(lblCustomers);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 112, 165, 25);
		panel.add(separator);
		
		JTextPane lblError = new JTextPane();
		lblError.setForeground(Color.RED);
		lblError.setBackground(new Color(0, 51, 102));
		lblError.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		lblError.setBounds(23, 585, 228, 161);
		panel.add(lblError);
		
		JLabel lblSale = new JLabel("Sale list");
		lblSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				SalesList.main(null);
			}
		});
		lblSale.setForeground(Color.WHITE);
		lblSale.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28));
		lblSale.setBounds(62, 205, 164, 73);
		panel.add(lblSale);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(menuSaleOrder.class.getResource("/list.png")));
		label_1.setBounds(23, 223, 27, 32);
		panel.add(label_1);
		
		JLabel westerLabel = new JLabel("Western Style Ltd");
		westerLabel.setFont(new Font("Tekton Pro Ext", Font.BOLD, 24));
		westerLabel.setBounds(387, 13, 262, 32);
		contentPane.add(westerLabel);
		
		JPanel tittlePanel = new JPanel();
		tittlePanel.setBackground(new Color(51, 102, 153));
		tittlePanel.setBounds(283, 56, 917, 105);
		contentPane.add(tittlePanel);
		tittlePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create a new sale");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tekton Pro Ext", Font.BOLD, 21));
		lblTitle.setBounds(246, 35, 409, 34);
		tittlePanel.add(lblTitle);
		
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setBackground(new Color(0, 0, 51));
		fieldsPanel.setBounds(283, 161, 917, 739);
		contentPane.add(fieldsPanel);
		fieldsPanel.setLayout(null);
		
		LineBorder roundedLineBorder = new LineBorder(Color.white, 2, true);
		TitledBorder personalBorder = new TitledBorder(roundedLineBorder,"");
		personalBorder.setTitleJustification(TitledBorder.LEFT);
		personalBorder.setTitlePosition(TitledBorder.TOP);
		personalBorder.setTitleColor(Color.white);
		
		TitledBorder addressBorder = new TitledBorder(roundedLineBorder,"Address Information");
		addressBorder.setTitleJustification(TitledBorder.LEFT);
		addressBorder.setTitlePosition(TitledBorder.TOP);
		addressBorder.setTitleColor(Color.white);
		
		JPanel aditionalPanel = new JPanel();
		aditionalPanel.setBackground(new Color(0, 0, 51));
		aditionalPanel.setBounds(44, 33, 765, 589);
		fieldsPanel.add(aditionalPanel);
		aditionalPanel.setLayout(null);
		
		TitledBorder aditionalBorder = new TitledBorder(roundedLineBorder,"Sale Information");
		aditionalBorder.setTitleJustification(TitledBorder.LEFT);
		aditionalBorder.setTitlePosition(TitledBorder.TOP);
		aditionalBorder.setTitleColor(Color.white);
		
		aditionalPanel.setBorder(aditionalBorder);
		
		JLabel lblSaleNumber = new JLabel("Sale Number: ");
		lblSaleNumber.setBounds(38, 80, 116, 16);
		aditionalPanel.add(lblSaleNumber);
		lblSaleNumber.setForeground(new Color(0, 204, 255));
		lblSaleNumber.setFont(new Font("Verdana", Font.BOLD, 15));
	    
	   

		
		JLabel lblCpr = new JLabel("Customer CPR");
		lblCpr.setForeground(new Color(0, 204, 255));
		lblCpr.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCpr.setBounds(393, 46, 146, 16);
		aditionalPanel.add(lblCpr);
		
		txfCpr = new JTextField();
		txfCpr.setForeground(Color.WHITE);
		txfCpr.setFont(new Font("Verdana", Font.PLAIN, 15));
		txfCpr.setColumns(10);
		txfCpr.setBorder(null);
		txfCpr.setBackground(new Color(0, 0, 51));
		txfCpr.setBounds(393, 71, 282, 35);
		aditionalPanel.add(txfCpr);
		
		JSeparator spCpr = new JSeparator();
		spCpr.setBounds(393, 111, 282, 16);
		aditionalPanel.add(spCpr);
		
		
		JComboBox<String> cbbOrder = new JComboBox<String>();
		cbbOrder.setBounds(38, 197, 146, 20);

		cbbOrder.addItem("Select the order type");
		cbbOrder.addItem("Buy");
		cbbOrder.addItem("Rent");
		
		aditionalPanel.add(cbbOrder);
		
		JLabel lblOrderType = new JLabel("Order type");
		lblOrderType.setForeground(new Color(0, 204, 255));
		lblOrderType.setFont(new Font("Verdana", Font.BOLD, 15));
		lblOrderType.setBounds(38, 170, 116, 16);
		aditionalPanel.add(lblOrderType);
		
		
		
		String [] header={"Product", "Quantity"};
	
		model = new DefaultTableModel(data,header);
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
        table.setBounds(40, 313, 363, 118);
        //table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);

        // Disable row editor
        table.setDefaultEditor(Object.class, null);

        // Disable header dragging
        table.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane js=new JScrollPane(table);
        js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVisible(true);
        js.setSize(447, 128);
        js.setLocation(38, 328);
        aditionalPanel.add(js);
        
        JButton btnAdd = new JButton("Add");
        
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(102, 0, 204));
        btnAdd.setBounds(396, 279, 89, 23);
        aditionalPanel.add(btnAdd);
        
        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(216, 492, 371, 53);
        aditionalPanel.add(btnCreate);
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        btnCreate.setBackground(new Color(0, 102, 204));
        
        cbbProducts = new JComboBox<String>();
        cbbProducts.setMaximumRowCount(900);
        cbbProducts.setBounds(38, 280, 146, 20);
        cbbProducts.addItem("Select one product");
        aditionalPanel.add(cbbProducts);
        
        getAllProductNames();
        
        JLabel lblProducts = new JLabel("Product");
        lblProducts.setForeground(new Color(0, 204, 255));
        lblProducts.setFont(new Font("Verdana", Font.BOLD, 15));
        lblProducts.setBounds(38, 253, 116, 16);
        aditionalPanel.add(lblProducts);
        
        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setForeground(new Color(0, 204, 255));
        lblQuantity.setFont(new Font("Verdana", Font.BOLD, 15));
        lblQuantity.setBounds(212, 254, 79, 16);
        aditionalPanel.add(lblQuantity);
        
        
        // Formatter to just allow positive numbers | PERFECT!
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField txfQuantity = new JFormattedTextField(formatter);

        txfQuantity.setForeground(Color.WHITE);
        txfQuantity.setFont(new Font("Verdana", Font.PLAIN, 15));
        txfQuantity.setColumns(10);
        txfQuantity.setBorder(null);
        txfQuantity.setBackground(new Color(0, 0, 51));
        txfQuantity.setBounds(216, 275, 132, 21);
        aditionalPanel.add(txfQuantity);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(216, 301, 132, 16);
        aditionalPanel.add(separator_1);
        
        JLabel lblSaleN = new JLabel("");
        lblSaleN.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
        lblSaleN.setForeground(Color.WHITE);
        lblSaleN.setBounds(164, 77, 34, 26);
        aditionalPanel.add(lblSaleN);
		
        
        //GETTING LAST ID ON THE TABLE AND THEN INCREMENTING ONE
        String getStringId = getLastSaleId();
        myID = Integer.valueOf(getStringId);
        myID += 1;
        String sMyId = String.valueOf(myID);
        lblSaleN.setText(sMyId);
		
		
		JLabel lblClose = new JLabel("");
		lblClose.setIcon(new ImageIcon(menuSaleOrder.class.getResource("/close.png")));
		lblClose.setBounds(1156, 13, 32, 25);
		contentPane.add(lblClose);
		
		
		
		btnAdd.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		String product = (String) cbbProducts.getSelectedItem();
        		String quantityF = txfQuantity.getText();
        		
        		if(!product.equals("Select one product") && !quantityF.equals("")) {
        			
        			
        			model.addRow(new Object[]{product, quantityF});
        			
        			int quantity = Integer.valueOf(quantityF);
        			
        			mySaleOrder.insertProduct(myID, product, quantity);
        			
        			txfQuantity.setText("");
            		cbbProducts.setSelectedItem("Select one product");
            		lblError.setText("");
        		} else {
        			lblError.setText("You need to select a product and insert a quantity");
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
		
	}
	
	public void getAllProductNames() {
		ProductCtr myProduct = new ProductCtr();
		try {
			ArrayList<Product> prod = myProduct.getAll();
			for (Product product : prod) {
				cbbProducts.addItem(product.getName());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String getLastSaleId() throws Exception {
		saleOrderCtr mySale = new saleOrderCtr();
		SaleOrder cus = mySale.getLastId();
		String cprNumber = cus.getCustomerCpr();
		
		return cprNumber;
	}
}
