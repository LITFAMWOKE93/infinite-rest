package accounts.src;

public class BankingAccount {

    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // constructor

    BankingAccount() {
        this.firstName = "BLANK";
        this.lastName = "BLANK";
        this.accountID = 000000;
        this.balance = 0.00;
    }

    //parameterized constructor
    BankingAccount(String fName, String lName, int ID, double balance) {
        this.firstName = fName;
        this.lastName = lName;
        this.accountID = ID;
        this.balance = balance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Must deposit a positive value");
        }
        this.balance = this.balance + depositAmount;
    }




    


    public static void main(String[] args) {

        System.out.println("Hello World");
    
}
}

