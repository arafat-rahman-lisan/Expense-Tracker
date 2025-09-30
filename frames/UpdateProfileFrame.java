package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.User;
import repositories.UserRepo;

public class UpdateProfileFrame extends JFrame implements ActionListener {
    private JLabel emailLabel, passwordLabel;
    private JTextField emailTF;
    private JPasswordField passwordPF;
    private JButton updateBtn, backBtn;
    private User loggedUser;

    public UpdateProfileFrame(User user) {
        super("Update Profile - Daily Expense Tracker");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.loggedUser = user;
        JPanel panel = new JPanel();
        panel.setLayout(null);

        emailLabel = new JLabel("New Email:");
        emailLabel.setBounds(50, 40, 100, 30);
        panel.add(emailLabel);

        emailTF = new JTextField(loggedUser.getEmail());
        emailTF.setBounds(150, 40, 180, 30);
        panel.add(emailTF);

        passwordLabel = new JLabel("New Password:");
        passwordLabel.setBounds(50, 90, 100, 30);
        panel.add(passwordLabel);

        passwordPF = new JPasswordField(loggedUser.getPassword());
        passwordPF.setBounds(150, 90, 180, 30);
        panel.add(passwordPF);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(80, 150, 100, 30);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 150, 100, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateBtn) {
            loggedUser.setEmail(emailTF.getText());
            loggedUser.setPassword(new String(passwordPF.getPassword()));
            UserRepo ur = new UserRepo();
            ur.updateUser(loggedUser);
            JOptionPane.showMessageDialog(this, "Profile updated successfully!");
        } else if (ae.getSource() == backBtn) {
            new DashboardFrame(loggedUser).setVisible(true);
            this.setVisible(false);
        }
    }
}
