import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args){
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

            System.out.println("\nЖелаете войти в систему?: ");
            do {
                String choice = bf.readLine();
                if (choice.startsWith("n")) {
                    break;
                }
            }
            while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}