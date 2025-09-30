package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryFrame extends JFrame implements ActionListener {
    private JButton loginBtn, signUpBtn;
    private JLabel titleLabel;
    private JPanel panel;

    public EntryFrame() {
        super("Welcome - Daily Expense Tracker");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Daily Expense Tracker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(80, 30, 250, 40);
        panel.add(titleLabel);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 100, 100, 30);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(200, 100, 100, 30);
        signUpBtn.addActionListener(this);
        panel.add(signUpBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginBtn) {
            new LoginFrame().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == signUpBtn) {
            new SignUpFrame().setVisible(true);
            this.setVisible(false);
        }
    }
}
