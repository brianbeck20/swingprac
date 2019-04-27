package com.yoo;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("login prac");
        final JButton btnLogin = new JButton("�α���");
        final JButton btnRegister = new JButton("ȸ������");

        btnLogin.addActionListener(
                e -> {
                    LoginDialog loginDlg = new LoginDialog(frame);
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                        btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                    }
                });


        btnRegister.addActionListener(
                e -> {
                    RegisterDialog registerDialog = new RegisterDialog(frame);
                    registerDialog.setVisible(true);
                    // if logon successfully
                    if(registerDialog.isSucceeded()){
                        btnLogin.setText(registerDialog.getUsername() + "�� ȸ�������� �Ϸ�Ǿ����ϴ�.");
                    }
                });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 80);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnRegister);
        frame.setVisible(true);
    }
}
