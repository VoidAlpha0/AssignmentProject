package cameraRentalApplication;

import java.util.Scanner;

public class cameraClass {
	private int cameraId;
	private String cameraName;
	private String cameraModel;
	private int pricePerDay;
	private boolean status;
	
	public void setCamera() {
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter camera Id :");
		int cameraId = sc1.nextInt();
		sc1.nextLine();
		System.out.println("Enter camera Name :");
		String cameraName = sc1.nextLine();

		
		System.out.println("Enter camera Model :");
		String cameraModel = sc1.nextLine();

		
		System.out.println("Enter Price per day :");
		int pricePerDay = sc1.nextInt();
		sc1.nextLine();
		
		
		this.cameraId = cameraId;
		this.cameraName = cameraName;
		this.cameraModel = cameraModel;
		this.pricePerDay = pricePerDay;
		this.status=true;
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}

	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}

	public void setCameraModel(String cameraModel) {
		this.cameraModel = cameraModel;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getCameraId() {
		return cameraId;
	}

	public String getCameraName() {
		return cameraName;
	}

	public String getCameraModel() {
		return cameraModel;
	}
	public int getPricePerDay() {
		return pricePerDay;
	}

	public cameraClass(int cameraId, String cameraName, String cameraModel, int pricePerDay, boolean status) {
		super();
		this.cameraId = cameraId;
		this.cameraName = cameraName;
		this.cameraModel = cameraModel;
		this.pricePerDay = pricePerDay;
		this.status = status;
	}

	public cameraClass() {
	}

	public Object getStatus() {
		if(isStatus()) {
			return "Available";
			}
			else 
				return "Rented";
	}



	
	
	 

}
