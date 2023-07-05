package cameraRentalApplication;

import java.util.*;



public class mainPage {
	
	 static List<cameraClass> cameraList= new ArrayList<>();
	 static wallet myWallet = wallet.getInstance();
	 

	public static void main(String[] args) {
		int width = 30;
        int height = 5;
        String name, pass;
        Scanner sc = new Scanner(System.in);
        adminInfo ob = new adminInfo();
        
        initializeCamera();

        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++) {
                if (row == 1 || row == height) {
                    System.out.print("* ");
                } else if (row == height / 2 + 1 && col == width / 4 + 1) {
                    System.out.print("Camera Rental Application ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("Login to Continue-");
        boolean exi=true;
        while(exi) {
        	System.out.println("UserName :-");
        	name=sc.nextLine();
        	System.out.println("password :-");
        	pass=sc.nextLine();
        
       
        	if(ob.check(name, pass)) {
        		System.out.println("Welcome ");
        		option1();
        		exi=false;
        	}
        	else {
        		System.out.println("Wrong Username or Password ");
        	}
        }
        System.out.println("End of the program.");
        sc.close();
	}
	
	
	private static void option1() {
		String[] arr = {"1. My Camera",
                "2. Rent A Camera",
                "3. View All Cameras",
                "4. My wallet",
                "5. Exit",
        	};
        int  slen = arr.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
        }
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        switch(options) {
        	case 1 :
        		myCam();
        		break;
        	case 2 :
        		rentCam();
        		break;
        	case 3 :
        		displayCameras(cameraList);
        		option1();
        		break;
        	case 4 :
        		viewWallet();
        		break;
        	case 5 :
        		break;
        	default :
        		System.out.println("invalid input");
        		option1();
        	
        }

	}
	
	private static void viewWallet() {
		System.out.println("Your Current balance is "+ myWallet.getBalance());
		System.out.println("Do you wamt to deposite more amount to your wallet?(1- Yes 2- No)");
		Scanner scanner= new Scanner(System.in);
		int i= scanner.nextInt();
		if(i==1) {
			System.out.println("Enter Amount to be added ");
			int amt=scanner.nextInt();
			int bal=myWallet.getBalance();
			myWallet.setBalance(bal+amt);
			System.out.println("Amount added to the wallet. New Balance is $"+myWallet.getBalance());
			option1();
		}
		else {
			System.out.println("No money to be added going back to previous page");
			option1();
		}
	}




	private static void rentCam() {
		displayCamerasAvailable(cameraList);
		System.out.println("Enter Camera Id which you want to rent");
		Scanner sc = new Scanner(System.in);
		int key=sc.nextInt();
		rentCamera(key,cameraList);
	}


	private static void rentCamera(int key, List<cameraClass> cameraList2) {
		int flag=0;
		for (cameraClass camera : cameraList) {
	    	int camId=camera.getCameraId();
	    	if (key==camId) {
	    		flag=1;
	    		int bal= myWallet.getBalance();
	    		if(bal>=camera.getPricePerDay()) {
	    			camera.setStatus(false);
	    			myWallet.setBalance(bal-camera.getPricePerDay());
	    			System.out.println("Camera rented successfully");
	    			System.out.println( "New Balance is $"+myWallet.getBalance());
	    			option1();
	    		}
	    		else {
	    		System.out.println("You have insufficent balance.");
	    		option1();
	    		}
	    	}
	    }
		if(flag==0) {
		System.out.println("camera Id not available Try again.");
		rentCam();
		}
		
	}



	private static void myCam() {
		String[] arr = {"1. Add",
                "2. Remove",
                "3. View All Cameras",
                "4. Go to previous Menu",
        };
		int  slen = arr.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Enter choice");
	    Scanner sc = new Scanner(System.in);
	    int selectnew =  sc.nextInt();
	    switch(selectnew) {
	    	case 1 : 
	    		cameraClass camnew = new cameraClass();
	        	camnew.setCamera();		
	        	cameraList.add(camnew);
	        	System.out.println("Camera Added to the List");
	    		myCam();
	        	break;
	    	case 2 :
	    		displayCameras(cameraList);
	        	System.out.println("Enter the Id to remove Camera");
	        	int idToRemove = sc.nextInt();
	        	boolean flag=false;
	        	Iterator<cameraClass> iterator  = cameraList.iterator();
	        	while (iterator.hasNext()) {
	        		cameraClass camera = iterator.next();
	        		if (camera.getCameraId() == idToRemove) {
	        			if(camera.isStatus()) {
	        				iterator.remove();
	        				flag=true;
		        			break;
	        			}
	        			else {
	        				System.out.println("Camera is rented cannot remove it");
	        				break;
	        			}
	        			
	        		}
	        	}
	        	if(flag) {
	        	System.out.println("Camera id = "+ idToRemove + "has been removed from list");}
	        	myCam();
	        	break;
	    	case 3 :
	    		displayCameras(cameraList);
	    		myCam();
	    		break;
	    	case 4 :
	    		option1();
	    		break;
	    	default :
	        		System.out.println("invalid Entry");
	        		myCam();
	        }
	        sc.close();



		
	}

	

	
	public static void displayCameras(List<cameraClass> cameraList) {
	    if (cameraList.isEmpty()) {
	        System.out.println("No cameras found.");
	        return;
	    }
	    
	    System.out.println("Cameras in the list:");
	    System.out.println("------------------------------------------------------------");
	    System.out.printf("%-10s %-15s %-20s %-8s %-10s%n", "Camera ID", "Camera Name", "Camera Model", "Price", "Status");
	    System.out.println("------------------------------------------------------------");
	    
	    for (cameraClass camera : cameraList) {
	        System.out.printf("%-10d %-15s %-20s $%-7d %-10s%n",
	                camera.getCameraId(),
	                camera.getCameraName(),
	                camera.getCameraModel(),
	                camera.getPricePerDay(),
	                (camera.getStatus()));
	    }
	    System.out.println("------------------------------------------------------------");
	}

	
	public static void displayCamerasAvailable(List<cameraClass> cameraList) {
		if (cameraList.isEmpty()) {
	        System.out.println("No cameras found.");
	        return;
	    }
	    
	    System.out.println("Cameras in the list:");
	    System.out.println("------------------------------------------------------------");
	    System.out.printf("%-10s %-15s %-20s %-8s %-10s%n", "Camera ID", "Camera Name", "Camera Model", "Price", "Status");
	    System.out.println("------------------------------------------------------------");
	    
	    for (cameraClass camera : cameraList) {
	    	if(camera.isStatus()) {
		        System.out.printf("%-10d %-15s %-20s $%-7d %-10s%n",
		                camera.getCameraId(),
		                camera.getCameraName(),
		                camera.getCameraModel(),
		                camera.getPricePerDay(),
		                camera.getStatus());
	    	}
	    }
	    System.out.println("------------------------------------------------------------");
	}
	
	public static void initializeCamera() {
		cameraClass camnew1 = new cameraClass(10,"Nikon","DSLR-D251",350,true);
		cameraClass camnew2 = new cameraClass(11,"Sony","DSLR-1550",123,true);
		cameraClass camnew3 = new cameraClass(12,"Samsung","SM153",875,true);
		cameraClass camnew4 = new cameraClass(13,"Sony","DSLR-2550",450,false);
		cameraClass camnew5 = new cameraClass(14,"Nikon","DSLR-D351",500,true);
		cameraClass camnew6 = new cameraClass(15,"Canon","5050",2500,false);
		cameraList.add(camnew1);
		cameraList.add(camnew2);
		cameraList.add(camnew3);
		cameraList.add(camnew4);
		cameraList.add(camnew5);
		cameraList.add(camnew6);
	}

	
		
}
