package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.Expense;
import entities.User;
import repositories.ExpenseRepo;

public class ExpenseListFrame extends JFrame implements ActionListener {
    private JLabel categoryLabel, dateLabel;
    private JTextField categoryTF, dateTF;
    private JButton filterBtn, resetBtn, backBtn;
    private JTextArea resultArea;
    private User loggedUser;

    public ExpenseListFrame(User user) {
        super("Expense List - Daily Expense Tracker");
        this.setSize(550, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.loggedUser = user;
        JPanel panel = new JPanel();
        panel.setLayout(null);

        categoryLabel = new JLabel("Category ID:");
        categoryLabel.setBounds(20, 20, 100, 30);
        panel.add(categoryLabel);

        categoryTF = new JTextField();
        categoryTF.setBounds(130, 20, 120, 30);
        panel.add(categoryTF);

        dateLabel = new JLabel("Date (dd-mm-yyyy):");
        dateLabel.setBounds(270, 20, 130, 30);
        panel.add(dateLabel);

        dateTF = new JTextField();
        dateTF.setBounds(400, 20, 120, 30);
        panel.add(dateTF);

        filterBtn = new JButton("Filter");
        filterBtn.setBounds(150, 60, 100, 30);
        filterBtn.addActionListener(this);
        panel.add(filterBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(270, 60, 100, 30);
        resetBtn.addActionListener(this);
        panel.add(resetBtn);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 110, 500, 240);
        resultArea.setEditable(false);
        panel.add(resultArea);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 370, 120, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        displayAll();
        this.add(panel);
    }

    private void displayAll() {
        ExpenseRepo er = new ExpenseRepo();
        Expense[] list = er.getAllExpensesByUser(loggedUser.getId());
        StringBuilder sb = new StringBuilder();
        for (Expense e : list) {
            if (e == null) break;
            sb.append("ID: ").append(e.getExpenseId())
              .append(", Cat: ").append(e.getCategoryId())
              .append(", Amt: ").append(e.getAmount())
              .append(", Desc: ").append(e.getDescription())
              .append(", Date: ").append(e.getDate())
              .append("\n");
        }
        resultArea.setText(sb.toString());
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == filterBtn) {
            String category = categoryTF.getText().trim();
            String date = dateTF.getText().trim();
            ExpenseRepo er = new ExpenseRepo();
            Expense[] list = er.getAllExpensesByUser(loggedUser.getId());
            StringBuilder sb = new StringBuilder();
            for (Expense e : list) {
                if (e == null) break;
                boolean match = true;
                if (!category.isEmpty() && !e.getCategoryId().equals(category)) match = false;
                if (!date.isEmpty() && !e.getDate().equals(date)) match = false;
                if (match) {
                    sb.append("ID: ").append(e.getExpenseId())
                      .append(", Cat: ").append(e.getCategoryId())
                      .append(", Amt: ").append(e.getAmount())
                      .append(", Desc: ").append(e.getDescription())
                      .append(", Date: ").append(e.getDate())
                      .append("\n");
                }
            }
            resultArea.setText(sb.toString());
        } else if (ae.getSource() == resetBtn) {
            categoryTF.setText("");
            dateTF.setText("");
            displayAll();
        } else if (ae.getSource() == backBtn) {
            new DashboardFrame(loggedUser).setVisible(true);
            this.setVisible(false);
        }
    }
}
