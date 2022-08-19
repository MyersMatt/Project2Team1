package models.users;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User extends AnonymousUser{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="user_id")
	private Integer Id;
	
	@Column(name="user_name",unique=true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="shipping_address")
	private String shippingAddress;
	
	@Column(name="payment_info")
	private String paymentInfo;
	
	public User() {
		this("firstName","lastName","email","userName","password","shippingAddress","paymentInfo");
		
	}
	
	public User(String firstName, String lastName, String email, String userName, String password, String shippingAddress, String paymentInfo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.paymentInfo = paymentInfo;
	
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public String setFirstName(String firstName) {
		return this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}

	public String getUsername() {
		return this.userName;
	}

	public String setUserName(String userName) {
		return this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}
	
	public String getshippingAddress() {
		return this.shippingAddress;
	}

	public String setshippingAddress(String shippingAddress) {
		return this.shippingAddress = shippingAddress;
	}
	
	public String getpaymentInfo() {
		return this.paymentInfo;
	}

	public String setpaymentInfo(String paymentInfo) {
		return this.paymentInfo = paymentInfo;
	}
}
