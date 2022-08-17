package models.users;

public class Admin extends User{
	private int adminId;
	
	public Admin() {
		super();
		
	}
	
	public Admin(String firstName, String lastName, String email, String userName, String password, String shippingAddress, String paymentInfo, int adminId) {
		super(firstName, lastName, email, userName, password, shippingAddress, paymentInfo);
		this.adminId = adminId;
		
	
	}
	
	public String getadminId() {
		return this.adminId;
	}

	public String setadminId(String adminId) {
		return this.adminId = adminId;
	}
	
}
