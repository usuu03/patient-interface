import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ChangeDoctor extends JFrame implements ActionListener {

    private JLabel label;
    private JComboBox<String> doctorList;
    private JButton changeButton;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public ChangeDoctor() {
        super("Change Doctor");

        // Initialize components
        label = new JLabel("Select a new doctor:");
        doctorList = new JComboBox<String>();
        changeButton = new JButton("Change Doctor");

        // Getting the doctors name from the database and adding them to the combo box
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/database?user=root&password=$uperDragon13");
            statement = connection.prepareStatement("SELECT name FROM doctors");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                doctorList.addItem(resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(doctorList);
        panel.add(changeButton);
        add(panel);

        // Register action listener for button
        changeButton.addActionListener(this);

        // Set frame attributes
        setSize(300, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeButton) {
            String selectedDoctor = (String) doctorList.getSelectedItem();

            // Getting the ID of the selected doctor from the database
            int ID = -1;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/database?user=root&password=$uperDragon13");
                statement = connection.prepareStatement("SELECT id FROM doctors WHERE name='" + selectedDoctor + "'");
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    ID = resultSet.getInt(1);
                }
                connection.close();

            } catch (Exception b) {
                b.printStackTrace();
            }

            // Update the bookings table in the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/database?user=root&password=$uperDragon13");
                String query = "UPDATE bookings SET doctor_id=" + ID + " WHERE status='Scheduled'";
                PreparedStatement updateStatement = connection.prepareStatement("UPDATE bookings SET doctor_id=? WHERE status='Scheduled'");
                updateStatement.setInt(1, ID);
                int rowsAffected = updateStatement.executeUpdate();

                connection.close();
            } catch (Exception b) {
                b.printStackTrace();
            }

            // Code to send confirmation messages to the patient and the doctor
            String confirmationMessage = "Your doctor has been changed to " + selectedDoctor;
            JOptionPane.showMessageDialog(this, confirmationMessage);

        }
    }

    public static void main(String[] args) {
        new ChangeDoctor();
        DBManager db = new DBManager();
        db.testConnection();

    }
}
