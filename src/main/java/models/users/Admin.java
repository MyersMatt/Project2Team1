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
	
	public int getadminId() {
		return this.adminId;
	}

	public void setadminId(int adminId) {
		this.adminId = adminId;
	}
	
}
