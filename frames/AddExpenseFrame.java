package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.Expense;
import entities.User;
import repositories.ExpenseRepo;

public class AddExpenseFrame extends JFrame implements ActionListener {
    private JLabel categoryLabel, amountLabel, descLabel, dateLabel;
    private JTextField categoryTF, amountTF, descTF, dateTF;
    private JButton addBtn, backBtn;
    private User loggedUser;

    public AddExpenseFrame(User user) {
        super("Add Expense - Daily Expense Tracker");
        this.setSize(400, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.loggedUser = user;
        JPanel panel = new JPanel();
        panel.setLayout(null);

        categoryLabel = new JLabel("Category ID:");
        categoryLabel.setBounds(30, 30, 100, 30);
        panel.add(categoryLabel);

        categoryTF = new JTextField();
        categoryTF.setBounds(150, 30, 180, 30);
        panel.add(categoryTF);

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 70, 100, 30);
        panel.add(amountLabel);

        amountTF = new JTextField();
        amountTF.setBounds(150, 70, 180, 30);
        panel.add(amountTF);

        descLabel = new JLabel("Description:");
        descLabel.setBounds(30, 110, 100, 30);
        panel.add(descLabel);

        descTF = new JTextField();
        descTF.setBounds(150, 110, 180, 30);
        panel.add(descTF);

        dateLabel = new JLabel("Date (dd-mm-yyyy):");
        dateLabel.setBounds(30, 150, 150, 30);
        panel.add(dateLabel);

        dateTF = new JTextField();
        dateTF.setBounds(150, 150, 180, 30);
        panel.add(dateTF);

        addBtn = new JButton("Add Expense");
        addBtn.setBounds(50, 210, 130, 30);
        addBtn.addActionListener(this);
        panel.add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 210, 130, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            Expense e = new Expense(
                "EXP" + System.currentTimeMillis(),
                loggedUser.getId(),
                categoryTF.getText(),
                Double.parseDouble(amountTF.getText()),
                descTF.getText(),
                dateTF.getText()
            );
            ExpenseRepo er = new ExpenseRepo();
            er.insertExpense(e);
            JOptionPane.showMessageDialog(this, "Expense added successfully!");
        } else if (ae.getSource() == backBtn) {
            new DashboardFrame(loggedUser).setVisible(true);
            this.setVisible(false);
        }
    }
}
