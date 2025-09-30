package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entities.User;
import repositories.UserRepo;

public class SignUpFrame extends JFrame implements ActionListener {
    private JLabel idLabel, nameLabel, emailLabel, passLabel, genderLabel, ageLabel;
    private JTextField idTF, nameTF, emailTF, ageTF;
    private JPasswordField passPF;
    private JComboBox<String> genderCB;
    private JButton registerBtn, backBtn;
    private JPanel panel;

    public SignUpFrame() {
        super("Sign Up - Daily Expense Tracker");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        idLabel = new JLabel("User ID:");
        idLabel.setBounds(30, 30, 100, 30);
        panel.add(idLabel);

        idTF = new JTextField();
        idTF.setBounds(140, 30, 200, 30);
        panel.add(idTF);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 30);
        panel.add(nameLabel);

        nameTF = new JTextField();
        nameTF.setBounds(140, 70, 200, 30);
        panel.add(nameTF);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 110, 100, 30);
        panel.add(emailLabel);

        emailTF = new JTextField();
        emailTF.setBounds(140, 110, 200, 30);
        panel.add(emailTF);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 150, 100, 30);
        panel.add(passLabel);

        passPF = new JPasswordField();
        passPF.setBounds(140, 150, 200, 30);
        panel.add(passPF);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 190, 100, 30);
        panel.add(genderLabel);

        genderCB = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderCB.setBounds(140, 190, 200, 30);
        panel.add(genderCB);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 230, 100, 30);
        panel.add(ageLabel);

        ageTF = new JTextField();
        ageTF.setBounds(140, 230, 200, 30);
        panel.add(ageTF);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(50, 280, 120, 30);
        registerBtn.addActionListener(this);
        panel.add(registerBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 280, 120, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == registerBtn) {
            User user = new User(
                idTF.getText(),
                nameTF.getText(),
                emailTF.getText(),
                new String(passPF.getPassword()),
                genderCB.getSelectedItem().toString(),
                Integer.parseInt(ageTF.getText())
            );
            UserRepo ur = new UserRepo();
            ur.insertUser(user);
            JOptionPane.showMessageDialog(this, "Registration successful!");
            new LoginFrame().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == backBtn) {
            new EntryFrame().setVisible(true);
            this.setVisible(false);
        }
    }
}
