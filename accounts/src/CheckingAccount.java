package accounts.src;

public class CheckingAccount extends BankingAccount {
    private double interestRate;

    CheckingAccount(String fName, String lName, int ID, double balance, double interestRate) {
        super(fName, lName, ID, balance); 
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;

    }
}
