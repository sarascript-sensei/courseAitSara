import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ank implements ActionListener {
    // frame
    JFrame frame;
    // inputs
    JTextField surname = new JTextField();
    JTextField name = new JTextField();
    JTextField mid_name = new JTextField();
    JTextField gender = new JTextField();
    JTextField date_of_birth = new JTextField();
    JTextField phone_number = new JTextField();
    JTextField education = new JTextField();
    JTextField zodiac_sign = new JTextField();
    JTextField maritl_status = new JTextField();
    JTextField interests = new JTextField();
    ;
    ;
    // labels

    JLabel surnameLabel = new JLabel("Фамилия");
    JLabel nameLabel = new JLabel("Имя");
    JLabel mid_nameLabel = new JLabel("Отчество");
    JLabel genderLabel = new JLabel("Пол");
    JLabel date_of_birthLabel = new JLabel("День рождения");
    JLabel phone_numberLabel = new JLabel("Номер телефона");
    JLabel educationLabel = new JLabel("Образование");
    JLabel zodiac_signLabel = new JLabel("Знак Зодиака");
    JLabel marital_statusLabel = new JLabel("Семейное положение");
    JLabel interestsLabel = new JLabel("");
    ButtonGroup bgMaritalStatus = new ButtonGroup();              // Radio button group
    JRadioButton rMarried  = new JRadioButton("Married"); // Radio buttons
    JRadioButton rSingle   = new JRadioButton ("Single");
    JRadioButton rDivorced = new JRadioButton ("Divorced");
    JComboBox comboHobbies = new JComboBox();

    JButton regButton = new JButton("Зарегистрироваться");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Log window = new Log();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @param log
     */
    public Ank(Reg log) {
        createWindow();
        initialize();
        actionEvent();
    }

    /**
     * Create a main window
     */
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Анкета");
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setBounds(100, 100, 1113, 806);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {


        // label: orange colored background
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 165, 0, 200));
        panel.setBounds(300, 150, 500, 472);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Label: scaled background
        JLabel background = new JLabel("");
        background.setBounds(6, 6, 1100, 772);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/0_00Love.jpg"));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        background.setIcon(scaledIcon);
        frame.getContentPane().add(background);

        // title: "Login Page"
        JLabel lblNewLabel_1 = new JLabel("Регистрация");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        lblNewLabel_1.setBounds(196, 40, 107, 29);
        panel.add(lblNewLabel_1);

        // input: user name
        surnameLabel.setBounds(145, 100, 210, 39);
        panel.add(surname);
        surname.setColumns(10);
        // input: user name
        nameLabel.setBounds(145, 150, 210, 39);
        panel.add(name);
        surname.setColumns(10);
        // input: password
        mid_nameLabel.setBounds(145, 200, 210, 39);
        panel.add(mid_name);

        // Label: user name
        genderLabel.setBounds(49, 250, 79, 16);
        panel.add(gender);

        // Label: password
        date_of_birthLabel.setBounds(49, 300, 79, 16);
        panel.add(date_of_birth);

        // Label: password
        phone_numberLabel.setBounds(49, 350, 79, 16);
        panel.add(phone_number);

        // Label: password
        educationLabel.setBounds(49, 400, 79, 16);
        panel.add(education);

        // Label: password
        zodiac_signLabel.setBounds(49, 450, 79, 16);
        panel.add(zodiac_sign);

        // Label: password
        marital_statusLabel.setBounds(49, 500, 79, 16);
        panel.add(maritl_status);

        // Label: password
        interestsLabel.setBounds(49, 550, 79, 16);
        panel.add(interests);




        // Button: Log in
        regButton.setBounds(190, 304, 120, 52);
        panel.add(regButton);


    }

    public void actionEvent() {
        // Adding action listener to buttons
        regButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regButton) {
            try {
                // Creating Connection Object
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework", "Sara", "12345");
                PreparedStatement Pstatement = connection.prepareStatement("INSERT INTO users (surname,name,mid_name,gender,date_of_birth,phone_number,education,zodiac_sign,marital_status,interests) VALUES (?,?,?,?,?,?,?,?,?,?)");
                Pstatement.setString(1, surname.getText());
                Pstatement.setString(2, name.getText());
                Pstatement.setString(3, mid_name.getText());
                Pstatement.setString(4, gender.getText());
                Pstatement.setString(5, date_of_birth.getText());
                Pstatement.setString(6, phone_number.getText());
                Pstatement.setString(7, education.getText());
                Pstatement.setString(8, zodiac_sign.getText());
                Pstatement.setString(9, maritl_status.getText());
                Pstatement.setString(10, interests.getText());
                ResultSet result = Pstatement.executeQuery();
                if (result.next()) {
                    JOptionPane.showMessageDialog(null, "Анкета заполнена!");
                } else {
                    JOptionPane.showMessageDialog(null, "Анкета не заполнена. Заполните пропущенные значения!");
                    surname.setText("");
                    name.setText("");
                    mid_name.setText("");
                    gender.setText("");
                    date_of_birth.setText("");
                    phone_number.setText("");
                    education.setText("");
                    zodiac_sign.setText("");
                    maritl_status.setText("");
                    interests.setText("");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
