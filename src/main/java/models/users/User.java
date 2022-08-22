package models.users;


import jakarta.persistence.*;
@Entity
@Table(name="users")

public class User extends AnonymousUser{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="user_id")
	private Integer id;
	
	@Column(name="username",unique=true)
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

	public User(Integer id,String firstName, String lastName, String email, String userName, String password, String shippingAddress, String paymentInfo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString(){
		return "User ID: " + id
				+"\nusername: "			+ userName
				+"\nEmail: "			+ email
				+"\npassword: "			+ password
				+"\nFirst Name: "		+ firstName
				+"\nLast Name: "		+ lastName
				+"\nShipping Address: "	+ shippingAddress
				+"\nPayment Info" 		+ paymentInfo;
	}
}
