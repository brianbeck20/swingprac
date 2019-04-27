package com.yoo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RegisterDialog extends JDialog {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JPasswordField pfPasswordConfirm;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JLabel lbPasswordConfirm;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;

    public RegisterDialog(Frame parent) {
        super(parent, "Register", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        lbPasswordConfirm = new JLabel("Password confirm: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbPasswordConfirm, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        pfPasswordConfirm = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(pfPasswordConfirm, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("확인");

        btnLogin.addActionListener(e -> {
            if (Register.authenticate(getUsername(), getPassword())) {
                JOptionPane.showMessageDialog(RegisterDialog.this,
                        "Hi " + getUsername() + " 회원가입이 완료되었어!",
                        "Register",
                        JOptionPane.INFORMATION_MESSAGE);
                succeeded = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(RegisterDialog.this,
                        "Invalid username or password",
                        "Login",
                        JOptionPane.ERROR_MESSAGE);
                // reset username and password
                pfPassword.setText("");
                pfPasswordConfirm.setText("");
                succeeded = false;
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}