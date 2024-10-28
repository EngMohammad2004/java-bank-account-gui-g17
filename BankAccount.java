/**
 *
 * @author 10
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Account {
    private String accountNumber;
    private String accountName;
    private int balance;

    public Account(String name, String num) {
        accountNumber = num;
        accountName = name;
        balance = 0;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }
}

public class BankAccount {
    private Account account;
    private JFrame frame;
    private JLabel balanceLabel;

    public BankAccount() {
        account = new Account("Mohamed", "9487250984375");

        frame = new JFrame("Bank Account GUI");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        
        JButton displayNameButton = new JButton("Display Account Name");
        displayNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Your Account Name Is: " + account.getAccountName());
            }
        });
        mainPanel.add(displayNameButton);
        
        JButton displayNumberButton = new JButton("Display Account Number");
        displayNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Your Account Number Is: " + account.getAccountNumber());
            }
        });
        mainPanel.add(displayNumberButton);
        
        JButton displayBalanceButton = new JButton("Display Balance");
        displayBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Your Balance Is: " + account.getBalance() + " EGP");
            }
        });
        mainPanel.add(displayBalanceButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:", "Deposit", JOptionPane.PLAIN_MESSAGE);

                if (input != null && !input.isEmpty()) {
                    try {
                        int amount = Integer.parseInt(input);
                        account.deposit(amount);

                        JOptionPane.showMessageDialog(frame, "Deposited " + amount + " EGP successfully!\nYour new balance is: " + account.getBalance() + " EGP", "Deposit Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        mainPanel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:", "Withdraw", JOptionPane.PLAIN_MESSAGE);

                if (input != null && !input.isEmpty()) {
                    try {
                        int amount = Integer.parseInt(input);
                        if (amount > account.getBalance()) {
                            JOptionPane.showMessageDialog(frame, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            account.withdraw(amount);

                            JOptionPane.showMessageDialog(frame, "Withdrawn " + amount + " EGP successfully!\nYour new balance is: " + account.getBalance() + " EGP", "Withdraw Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        mainPanel.add(withdrawButton);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BankAccount();
    }
}
