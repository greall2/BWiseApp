package bwise.model;

import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//referencing table n database
@Entity(name="t_transactions")
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int amount;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTransfered;
	
	//null constructor
	public Transaction (){}
	
	//
	public Transaction(int amount, String type, Date dateTransfered) {
		super();
		this.amount = amount;
		this.type = type;
		this.dateTransfered = dateTransfered;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateTransfered() {
		return dateTransfered;
	}
	public void setDateTransfered(Date dateTransfered) {
		this.dateTransfered = dateTransfered;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", type=" + type + ", dateTransfered=" + dateTransfered
				+ "]";
	}
	
	
	

}
