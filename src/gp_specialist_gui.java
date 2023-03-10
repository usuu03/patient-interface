import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gp_specialist_gui extends JFrame {
    private JTextField nameField;
    private JTextField contactField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField emailField;
    private JComboBox<String> expertiseComboBox;
    private JComboBox<String> specialistComboBox;

    public gp_specialist_gui() {
        setTitle("GP Appointment Scheduler");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for registering new patients
        JPanel patientPanel = new JPanel(new GridLayout(3, 2));
        patientPanel.setBorder(BorderFactory.createTitledBorder("New Patient"));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField();

        JLabel contactLabel = new JLabel("Contact Info:");
        contactField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPatient();
            }
        });
        patientPanel.add(nameLabel);
        patientPanel.add(nameField);

        patientPanel.add(ageLabel);
        patientPanel.add(ageField);

        patientPanel.add(genderLabel);
        patientPanel.add(genderField);

        patientPanel.add(contactLabel);
        patientPanel.add(contactField);

        patientPanel.add(emailLabel);
        patientPanel.add(emailField);

        patientPanel.add(new JLabel());
        patientPanel.add(registerButton);
        add(patientPanel, BorderLayout.NORTH);

        // Create a panel for selecting a specialist
        JPanel specialistPanel = new JPanel(new GridLayout(2, 2));
        specialistPanel.setBorder(BorderFactory.createTitledBorder("Select Specialist"));
        JLabel expertiseLabel = new JLabel("Area of Expertise:");
        expertiseComboBox = new JComboBox<>(new String[]{"Cardiology", "Dermatology", "Endocrinology"});
        JLabel specialistLabel = new JLabel("GP Specialist:");
        specialistComboBox = new JComboBox<>(new String[]{"Dr. Smith", "Dr. Jones", "Dr. Lee"});
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSpecialist();
            }
        });
        specialistPanel.add(expertiseLabel);
        specialistPanel.add(expertiseComboBox);
        specialistPanel.add(specialistLabel);
        specialistPanel.add(specialistComboBox);
        add(specialistPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void registerPatient() {
        String name = nameField.getText();
        String contactInfo = contactField.getText();
        // TODO: Save patient information to a database or file
        JOptionPane.showMessageDialog(this, "Patient registered successfully.");
        nameField.setText("");
        contactField.setText("");
    }

    private void selectSpecialist() {
        String areaOfExpertise = (String) expertiseComboBox.getSelectedItem();
        // TODO: Get a list of available GP specialists based on area of expertise
        String[] availableSpecialists = new String[]{"Dr. Smith", "Dr. Jones", "Dr. Lee"};
        specialistComboBox.setModel(new DefaultComboBoxModel<>(availableSpecialists));
    }

    public static void main(String[] args) {
        new gp_specialist_gui();
    }
}