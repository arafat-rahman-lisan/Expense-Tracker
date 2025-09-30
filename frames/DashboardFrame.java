package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.User;

public class DashboardFrame extends JFrame implements ActionListener {
    private User loggedUser;
    private JLabel welcomeLabel;
    private JButton addExpenseBtn, viewExpenseBtn, updateProfileBtn, logoutBtn;

    public DashboardFrame(User user) {
        super("Dashboard - Daily Expense Tracker");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.loggedUser = user;
        JPanel panel = new JPanel();
        panel.setLayout(null);

        welcomeLabel = new JLabel("Welcome, " + user.getName());
        welcomeLabel.setBounds(30, 30, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(welcomeLabel);

        addExpenseBtn = new JButton("Add Expense");
        addExpenseBtn.setBounds(50, 90, 160, 30);
        addExpenseBtn.addActionListener(this);
        panel.add(addExpenseBtn);

        viewExpenseBtn = new JButton("View Expenses");
        viewExpenseBtn.setBounds(250, 90, 160, 30);
        viewExpenseBtn.addActionListener(this);
        panel.add(viewExpenseBtn);

        updateProfileBtn = new JButton("Update Profile");
        updateProfileBtn.setBounds(50, 140, 160, 30);
        updateProfileBtn.addActionListener(this);
        panel.add(updateProfileBtn);

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(250, 140, 160, 30);
        logoutBtn.addActionListener(this);
        panel.add(logoutBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addExpenseBtn) {
            new AddExpenseFrame(loggedUser).setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == viewExpenseBtn) {
            new ExpenseListFrame(loggedUser).setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == updateProfileBtn) {
            new UpdateProfileFrame(loggedUser).setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == logoutBtn) {
            new EntryFrame().setVisible(true);
            this.setVisible(false);
        }
    }
}
