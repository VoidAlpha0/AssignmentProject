package cameraRentalApplication;


public class wallet {
    private static wallet instance;
    private static int balance;
    
    private wallet() {
        // Private constructor to prevent direct instantiation
    }
    
    public static wallet getInstance() {
        if (instance == null) {
            instance = new wallet();
        }
        return instance;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        wallet.balance = balance;
    }
}
