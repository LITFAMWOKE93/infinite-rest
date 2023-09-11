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

    //Deposit and withdrawal can be refactored into a single method for adjusting the balance in either direction.

    public void deposit(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Must deposit a positive value");
        }
        this.balance = this.balance + depositAmount;
    }


    public void withdrawal(double withdrawalAmount) {
        if (this.balance >= withdrawalAmount ) {
            this.balance = this.balance - withdrawalAmount;
        } else {
            System.out.println("You don't have enough money");
        }
    }

    // Setters and Getters

    public String getFname() {
        return this.firstName;
    }
    public String getLname() {
        return this.lastName;
    }

    public int getID() {
        return this.accountID;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setFname(String n) {
        this.firstName = n;
    }
    public void setLname(String n) {
        this.lastName = n;
    }

    public void setID(int ID) {
        this.accountID = ID;
    }
    

    public void accountSummary() {
        System.out.println("Account Information: \n");
        System.out.println(this.toString());
    }

   public String toString() {
        return "First Name: " + this.firstName + "\n" + "Last Name: " + this.lastName + "\n" + "Account ID:" + this.accountID + "\n" + "Balance:" + this.balance;
    }






    


    public static void main(String[] args) {


        BankingAccount acct1 = new BankingAccount("bill", "Sutter", 234, 890.023);

        acct1.accountSummary();
    
}
}

