package cameraRentalApplication;

public class temp {

	public static void main(String[] args) {
		cameraClass ob= new cameraClass();
		ob.setCamera();
		String modelname=ob.getCameraModel();
		int camid= ob.getCameraId();
		String camname=ob.getCameraName();
		int campr=ob.getPricePerDay();
		boolean ab=ob.getstatus();
		System.out.println(modelname + camid +camname +campr+ab);
	}

}
