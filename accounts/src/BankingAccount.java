package accounts.src;

import java.text.NumberFormat;
import java.util.Locale;


public class BankingAccount {

    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // constructor

    protected BankingAccount() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.accountID = 01234;
        this.balance = 0.00;
    }

    //parameterized constructor
    protected BankingAccount(String fName, String lName, int ID, double balance) {
        this.firstName = fName;
        this.lastName = lName;
        this.accountID = ID;
        this.balance = balance;
    }

    //Deposit and withdrawal can be refactored into a single method for adjusting the balance in either direction.

    public void deposit(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Must deposit a positive value");
        } else {
        this.balance = this.balance + depositAmount;
        }
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

    public void setBalance(double balance) {
        this.balance = balance;
    }
    

    public void accountSummary() {
        System.out.println("Account Information: \n");
        System.out.println(this.toString());
    }

   public String toString() {
        return "First Name: " + this.firstName + "\n" + "Last Name: " + this.lastName + "\n" + "Account ID:" + this.accountID + "\n" + "Balance: $" + this.balance;
    }






    


    public static void main(String[] args) {

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        


        BankingAccount acct1 = new BankingAccount("bill", "Sutter", 234, 890.23);

        String formattedAmount = currencyFormat.format(acct1.getBalance());
        System.out.println(formattedAmount);
        acct1.accountSummary();
    
}
}

