package models.users;

import java.util.List;

import com.models.Account;

public class User extends AnonymousUser{
	
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String shippingAddress;
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
		return this.username;
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
