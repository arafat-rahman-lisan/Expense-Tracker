package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entities.User;
import repositories.UserRepo;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel userLabel, passLabel;
    private JTextField userTF;
    private JPasswordField passPF;
    private JButton loginBtn, backBtn;
    private JPanel panel;

    public LoginFrame() {
        super("Login - Daily Expense Tracker");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        userLabel = new JLabel("User ID:");
        userLabel.setBounds(50, 60, 100, 30);
        panel.add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(150, 60, 150, 30);
        panel.add(userTF);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 30);
        panel.add(passLabel);

        passPF = new JPasswordField();
        passPF.setBounds(150, 110, 150, 30);
        panel.add(passPF);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(50, 170, 100, 30);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 170, 100, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String userId = userTF.getText();
        String password = new String(passPF.getPassword());

        if (ae.getSource() == loginBtn) {
            UserRepo ur = new UserRepo();
            User user = ur.searchUser(userId);

            if (user != null && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Redirect to dashboard
                this.setVisible(false);
                new DashboardFrame(user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid ID or password.");
            }
        } else if (ae.getSource() == backBtn) {
            new EntryFrame().setVisible(true);
            this.setVisible(false);
        }
    }
}
