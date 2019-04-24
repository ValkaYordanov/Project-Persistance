package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controler.saleOrderCtr;
import model.SaleOrder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalesList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Object[][] data = null;
	static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesList frame = new SalesList();
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
	public SalesList() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1195, 743);
		setType(Type.UTILITY);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 51, 102));
		titlePanel.setBounds(0, 0, 1177, 129);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel lblClientList = new JLabel("Sale List");
		lblClientList.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
		lblClientList.setForeground(new Color(255, 255, 255));
		lblClientList.setBounds(516, 35, 147, 51);
		titlePanel.add(lblClientList);
		
		JPanel listPanel = new JPanel();
		listPanel.setBackground(new Color(0, 0, 51));
		listPanel.setBounds(0, 125, 1177, 571);
		contentPane.add(listPanel);
		listPanel.setLayout(null);
		
		
		String [] header={"ID","CPR Number","Order Type","Date","Status","Delivery Date"};
		String [] fieldValues={"cprNumber","name","address","zipCode","city","phoneNo"};
        
        model = new DefaultTableModel(data,header);
        printAllOrders();
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
        
        table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);

        // Disable row editor
        table.setDefaultEditor(Object.class, null);

        // Disable header dragging
        table.getTableHeader().setReorderingAllowed(false);


        JScrollPane js=new JScrollPane(table);
        js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVisible(true);
        js.setSize(1109, 458);
        js.setLocation(31, 27);
        listPanel.add(js);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setForeground(new Color(255, 255, 255));
        btnUpdate.setBackground(new Color(102, 0, 204));
        
        btnUpdate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent arg0) {

				int myRow = table.getSelectedRow();
				if(myRow == -1) {
					JOptionPane.showMessageDialog(null, "You need to select one row to be able to edit", "No row selected", 1);
				} else {
					String myVar;
					String info[]=new String[6];
					for(int i = 0; i < fieldValues.length; i++) {
						myVar = fieldValues[i];
						myVar = table.getValueAt(myRow, i).toString();
						info[i] = myVar;
					}
					//String cprNumber = table.getValueAt(myRow, 0).toString();
					UpdateCustomer.main(info);

				}
            		
        	}
        });
        
        btnUpdate.setBounds(913, 498, 97, 25);
        listPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBackground(new Color(102, 0, 204));
        
        btnDelete.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		
        		int myRow = table.getSelectedRow();
				if(myRow == -1) {
					JOptionPane.showMessageDialog(null, "You need to select one row to be able to delete it", "No row selected", 1);
				} else {
					String cprNumber = table.getValueAt(myRow, 0).toString();
					String ObjButtons[] = {"Yes","No"};
	        		int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete the customer" +cprNumber+" ?","Online Examination System",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
	                if(PromptResult==JOptionPane.YES_OPTION)
	                {
	                	//CustomerCtr myCustomer = new CustomerCtr();
	                	//myCustomer.deleteCustomer(cprNumber);
	                	JOptionPane.showMessageDialog(null, "Customer deleted with success", "Success", 1);
	                	printAllOrders();
	                }
				}
        		
        	}
        });
        
        btnDelete.setBounds(1043, 498, 97, 25);
        listPanel.add(btnDelete);
        
        
	}
	
	public static void printAllOrders() {
		model.setNumRows(0);
		saleOrderCtr mySale = new saleOrderCtr();
		try {
			ArrayList<SaleOrder> sales = mySale.getAll();
			for (SaleOrder sale : sales) {
	          model.addRow(new Object[]{sale.getId(),sale.getCustomerCpr(),sale.getTypeOrder(),sale.getDate(),sale.getDeliveryStatus(),sale.getDeliveryDate()});
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
