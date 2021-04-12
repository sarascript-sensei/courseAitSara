import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class Log implements ActionListener {
    // frame
    JFrame frame;
    // inputs
    JTextField username = new JTextField();;
    JPasswordField password = new JPasswordField();;
    // labels
    JLabel usernameLabel = new JLabel("Имя пользователя");
    JLabel passwordLabel = new JLabel("Пароль");
    JLabel createAccountLabel = new JLabel("Зарегистрироваться");
    // button
    JButton loginButton = new JButton("Войти");

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
     */
    public Log() {
        createWindow();
        initialize();
        actionEvent();
    }

    /**
     * Create a main window
     */
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Login Page");
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
        panel.setBackground(new Color(255,165,0,200));
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
        JLabel lblNewLabel_1 = new JLabel("Login Page");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        lblNewLabel_1.setBounds(196, 40, 107, 29);
        panel.add(lblNewLabel_1);

        // input: user name
        username.setBounds(145, 156, 210, 39);
        panel.add(username);
        username.setColumns(10);

        // input: password
        password.setBounds(145, 207, 210, 39);
        panel.add(password);

        // Label: user name
        usernameLabel.setBounds(49, 167, 79, 16);
        panel.add(usernameLabel);

        // Label: password
        passwordLabel.setBounds(49, 218, 79, 16);
        panel.add(passwordLabel);

        // Label: create a new account
        createAccountLabel.setBounds(182, 407, 138, 16);
        panel.add(createAccountLabel);
        createAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Reg rp = new Reg(Log.this);
            }
        });

        // Button: Log in
        loginButton.setBounds(190, 304, 120, 52);
        panel.add(loginButton);



    }
    public void actionEvent() {
        // Adding action listener to buttons
        loginButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {
                // Creating Connection Object
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework", "Sara", "12345");
                PreparedStatement Pstatement = connection.prepareStatement("Select login_name, pass from login2 where login_name=? and pass=?");
                Pstatement.setString(1, username.getText());
                Pstatement.setString(2, String.valueOf(password.getPassword()));
                ResultSet result = Pstatement.executeQuery();
                if (result.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Username OR Password");
                    username.setText("");
                    password.setText("");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}