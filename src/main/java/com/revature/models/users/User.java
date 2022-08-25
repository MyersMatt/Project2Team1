package com.revature.models.users;

import com.revature.models.items.OrderList;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users",uniqueConstraints = @UniqueConstraint(columnNames = {"username","email"}))
public class User extends AnonymousUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id", insertable = false, updatable = false)
	private Integer id;

	@Column(name="username",unique=true)
	private String username;
	
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderList> history;

	public User() {
		this("firstName","lastName","email","userName","password");
		
	}

	public User(String firstName, String lastName, String email, String username, String password){
		this(firstName,lastName,email,username,password,"123 Example St.");
	}
	public User(String firstName, String lastName, String email, String username, String password, String shippingAddress) {
		this(firstName,lastName,email,username,password,shippingAddress,"1111-1111-1111-1111");
	}
	public User(String firstName, String lastName, String email, String username, String password, String shippingAddress, String paymentInfo) {
		this(0,firstName,lastName,email,username,password,shippingAddress,paymentInfo);
	}

	public User(Integer id, String firstName, String lastName, String email, String username, String password, String shippingAddress, String paymentInfo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.paymentInfo = paymentInfo;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public List<OrderList> getHistory() {
		return history;
	}

	public void setHistory(List<OrderList> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", shippingAddress='" + shippingAddress + '\'' +
				", paymentInfo='" + paymentInfo + '\'' +
				", history=" + history +
				'}';
	}
}
