package model;

import java.sql.Date;

public class Invoice {
	
//	private int invoiceNo;
	private Date paymentDate;
	private double amount;
	
	public Invoice(int invoiceNo, Date paymentDate, double amount) {
		
		//this.invoiceNo=invoiceNo;
		this.paymentDate=paymentDate;
		this.amount=amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount=amount;
	}

	

}
