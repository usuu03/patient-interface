// package software.patient-interface.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

   
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField username;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JButton loginBtn;
    

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

        
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userLogin = username.getText();
                String passwordLogin = password.getText();
                
                if(userLogin.equals("username") && passwordLogin.equals("password")){
                    JOptionPane.showMessageDialog(Login.this, "Welcome to the GP");
                } else{
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password.");
                }
    
            }
        });

        this.add(title);
        this.add(usernameLabel);
        this.add(username);

        this.add(passwordLabel);
        this.add(password);

        this.add(loginBtn);
  
        
        
        this.setVisible(true);

    }


   

    //Checks if the username and password are in the Database
    /* public void authenticate(){

        String userLogin = username.getText();
        String passwordLogin = password.getText();

        try {
            DBManager db = new DBManager();

            // db.connect();
            // db.open();

            String query = "SELECT * FROM patients WHERE username=' " + userLogin+ "'AND password='" + passwordLogin + "'";
            // ResultSet rs = db.executeQuery(query);

            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Welcome to the GP");
            } else{
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }


            rs.close();
            db.disconnect();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 */
    public static void main(String[] args) {
        new Login();
    }

}

