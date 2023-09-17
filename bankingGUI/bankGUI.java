package bankingGUI;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.text.NumberFormat;
import java.awt.*;
import accounts.src.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


// the BankGUI class inherits the BankingAccount class in this instance to use all of the previously created methods for handling transactions

public class BankGUI extends BankingAccount {
    // ActionListener components
    private EventManager eventManager;
    
    // GUI components
    private JFrame frame;
    private JPanel panel;
    private JLabel balanceLabel;
    private JLabel acctIDLabel;
    private JLabel acctNameLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    

    public JFrame getFrame() {
        return this.frame;
    }

    // Requirements: Get balance from user, display balance inside of JPanel, withdraw and deposit interface
    // Common set up
    // Create components
    // Create top level container
    // layout and add components to container
    // configure top level container(close operation and pack)
    // display container

    public BankGUI() {

        super();

        // Create the main frame
        frame = new JFrame("LateStage Banking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 500);

        // Create a JPanel with GridBagLayout
        panel = new JPanel(new GridBagLayout());


        // Cell border
        LineBorder cellBorder = new LineBorder(Color.BLACK);
        
        // GBC to apply one a modified instance to each component before adding to panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 5, 3);


        // Balance Label
        balanceLabel = new JLabel("Balance: $" + formatCurrency());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2; 

        gbc.insets = new Insets(10, 50, 5, 50);
        panel.add(balanceLabel, gbc);

        // Account ID
        acctIDLabel = new JLabel("Account ID:" + String.valueOf(getID()));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2; 
        gbc.insets = new Insets(10, 50, 5, 50);
        panel.add(acctIDLabel, gbc);

         // Name
        acctNameLabel = new JLabel("Account Holder: " + getFname() + " " + getLname());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2; 
        gbc.insets = new Insets(10, 50, 5, 50);
        panel.add(acctNameLabel, gbc);





        //depositButton layout
        depositButton = new JButton("Deposit");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2; 
        depositButton.setBorder(cellBorder);
        gbc.insets = new Insets(10, 50, 5, 50);
        panel.add(depositButton, gbc);

        //withdrawButton layout
        withdrawButton = new JButton("Withdraw");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2; 
        withdrawButton.setBorder(cellBorder);
        gbc.insets = new Insets(10, 50, 5, 50);
        panel.add(withdrawButton, gbc);

        // Add the panel to the frame
        frame.add(panel);
        // Create eventManager to handle action listeners
        eventManager = new EventManager(this);


        // Add action listeners to buttons using the event manager
        depositButton.addActionListener(eventManager.createDepositButtonListener());
        withdrawButton.addActionListener(eventManager.createWithdrawButtonListener());

        // override the windowListener to report final balance
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                displayFinalBalance();
                System.exit(0); // Exit the application
            }
        });


        setBalance(promptForBalanceInput());
        updateBalanceLabel();
        System.out.println("GUI Constructed");
        // Make the frame visible
        frame.setVisible(true);
    }

    // displayFinalBalance method is invoked during window event to show the last balance before close.
    public void displayFinalBalance() {
            JOptionPane.showMessageDialog(frame, "Final Balance: $" + formatCurrency(), "Exit Report", JOptionPane.INFORMATION_MESSAGE);
        }
    // updateBalanceLabel formats the currency and is called during ActionEvent to update the balance field
    public void updateBalanceLabel() {
        
        balanceLabel.setText("Balance: $" + formatCurrency());
    }
    // formatCurrency grabs the double value from the Bank Superclass and reformats it
    public String formatCurrency() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        String formattedCurrency = currencyFormatter.format(getBalance());
        return formattedCurrency;
    }

    public double promptForBalanceInput() {
        String input = JOptionPane.showInputDialog(frame, "Enter your balance:");
        try {
            // Parse the input as a double and return it
            return Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            // Handle invalid input (non-numeric)
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numeric value.");
            return 0.0; // Default value for invalid input
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankGUI();
            }
        });
    }
}