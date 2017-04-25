package bwise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

//referencing the table t_users table of database
@Entity
@Table(name = "t_users")
public class User {

	//Assigning variables to values of table t_users in database
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long uid;
	
	@Column(name="username")
	@Size(min=5, max=15)
	private String username;
	
	@Column(name="password")
	@Size(min=5, max=8)
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	//constructors
	public User(){}
	
	public User(String username, String password,String first_name, String last_name){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Getters and Setters
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	
}
