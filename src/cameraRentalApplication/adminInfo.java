package cameraRentalApplication;

public class adminInfo {
	private  String admin = "Admin";
	private  String password = "pass1234";
	
	public  boolean check(String name, String pass) {
		if(admin.equals(name)) {
			if(password.equals(pass)) {
				return true;
			}
		}
		return false;
	}
}

