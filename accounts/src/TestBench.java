package accounts.src;

public class TestBench {

    
    public static void main(String[] args) {
        // Create a new BankingAccount object using the parameterized constructor
        BankingAccount account1 = new BankingAccount("John", "Doe", 12345, 1000.0);

        // Print account information
        account1.accountSummary();

        // Deposit and withdraw from the account
        account1.deposit(500.0);
        account1.withdrawal(200.0);

        // Print updated account information
        account1.accountSummary();

        // Create another BankingAccount object using the default constructor
        BankingAccount account2 = new BankingAccount();

        // Set account information using setters
        account2.setFname("Alice");
        account2.setLname("Smith");
        account2.setID(54321);
        account2.deposit(1500.0);

        // Print account information for the second account
        account2.accountSummary();


        CheckingAccount account = new CheckingAccount("John", "Doe", 12345, 1000.0, 0.02);

        // Print initial account information
        account.accountSummary();

        // Deposit and withdraw from the account
        account.deposit(500.0);
        account.withdrawal(200.0);
        account.withdrawal(1500.0, account.getOverDraftFee()); // This should trigger the overdraft fee

        // Print updated account information
        account.accountSummary();

        // Change the interest rate
        account.setInterestRate(0.03);

        // Print account information again
        account.displayAccount();
    }
}
    

