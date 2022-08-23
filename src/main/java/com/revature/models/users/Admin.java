package com.revature.models.users;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private Integer adminId;
	
	public Admin() {
		super();
		
	}
	
	public Admin(String firstName, String lastName, String email, String userName, String password, String shippingAddress, String paymentInfo, int adminId) {
		super(firstName, lastName, email, userName, password, shippingAddress, paymentInfo);
		this.adminId = adminId;
		
	
	}
	
	public int getadminId() {
		return this.adminId;
	}

	public void setadminId(int adminId) {
		this.adminId = adminId;
	}
	
}
