package bankingGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventManager {
    private BankGUI app;

    public EventManager(BankGUI app) {
        this.app = app;
    }


    public ActionListener createDepositButtonListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(app.getFrame(), "Enter deposit amount:"));
                app.deposit(depositAmount);
                app.updateBalanceLabel();
            }
        };
    }


    public ActionListener createWithdrawButtonListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(app.getFrame(), "Enter withdrawal amount:"));
                app.withdrawal(withdrawAmount);
                app.updateBalanceLabel();
            }
        };
    }

    public ActionListener createShowBalanceButtonListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.updateBalanceLabel();
            }
        };
    }
}