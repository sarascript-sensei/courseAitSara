import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class LogReg {
    public void register() throws IOException {
        String url = "jdbc:mysql://localhost:3306/coursework";
        String name_db = "Sara";
        String password = "12345s";
        Scanner in = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Логин: ");
        String loginInsert = in.next();
        System.out.println("Пароль : ");
        String passwordInsert = in.next();
        try (Connection conn = DriverManager.getConnection(url, name_db, password);
             Statement myState = conn.createStatement())
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO login2 (login_name, pass) VALUES (?, ?)");

            statement.setString(1, loginInsert);
            statement.setString(2, passwordInsert);
            int rows = statement.executeUpdate();
            System.out.println(rows);
            System.out.println("Пользователь создан!");
            while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login(){

    }
}