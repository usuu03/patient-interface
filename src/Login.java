// package software.patient-interface.src;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JPanel panel;
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField username;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JButton loginBtn;
    private JButton signupBtn;

    public Login() {

        this.setTitle("Login Page");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);

        //Setting up the labels
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(200, 200, 100, 40);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(200, 250, 100, 40);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //Setting up the Textfields
        username =  new JTextField();       
        username.setBounds(300, 200, 300, 40);

        password =  new JPasswordField();       
        password.setBounds(300, 250, 300, 40);


        title = new JLabel("Welcome to the GP!");
        title.setBounds(300, 20, 250, 100);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        loginBtn = new JButton("Log in");
        loginBtn.setBounds(300, 300, 100, 40);


        this.add(title);
        this.add(usernameLabel);
        this.add(username);

        this.add(passwordLabel);
        this.add(password);

        this.add(loginBtn);
  
        
        
        this.setVisible(true);

    }

    //Checks if the username and password are in the Database
    public void authenticate(){

        String userLogin = username.getText();
        String passwordLogin = password.getText();
    }

    public static void main(String[] args) {
        new Login();
    }

}
