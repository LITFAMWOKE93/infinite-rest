package accounts.src;

public class CheckingAccount extends BankingAccount {
    private double interestRate;
    private final double OVERDRAFT_FEE = 30.00;

    CheckingAccount(String fName, String lName, int ID, double balance, double interestRate) {
        super(fName, lName, ID, balance); 
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;

    }

    public double getOverDraftFee() {
        return this.OVERDRAFT_FEE;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

     // Overloaded withdrawal method with an additional transactionFee
     public void withdrawal(double withdrawalAmount, double OVERDRAFT_FEE) {

                processWithdrawal(withdrawalAmount, OVERDRAFT_FEE);

    }

    public void processWithdrawal(double withdrawalAmount, double OVERDRAFT_FEE) {
        if (this.getBalance() < withdrawalAmount-OVERDRAFT_FEE) {
            this.setBalance(this.getBalance()-withdrawalAmount-OVERDRAFT_FEE);
            System.out.println("Overdraft fee has been applied to checking account.\n");
            System.out.println("$"+this.getBalance());

        } else {
            this.setBalance(this.getBalance()-withdrawalAmount);
        }
    

    }

    public void displayAccount() {
        this.accountSummary();
        System.out.println("Interest Rate: " + this.interestRate);
    }
}
