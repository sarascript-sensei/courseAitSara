import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class LoginRegistation {
    String url = "jdbc:mysql://localhost:3306/coursework";
    String name_db = "Sara";
    String password = "12345s";
    Scanner in = new Scanner(System.in);
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   public void Login(){
       Scanner in = new Scanner(System.in);
       System.out.println("Логин: ");
       String loginRegInsert = in.next();
       System.out.println("Пароль : ");
       String passwordRegInsert = in.next();
       try (Connection conn = DriverManager.getConnection(url, name_db, password);
            Statement myState = conn.createStatement()) {
           PreparedStatement statement = conn.prepareStatement("Select login_name, pass from login2 where login_name=? and pass=?");
           statement.setString(1, loginRegInsert);
           statement.setString(2, passwordRegInsert);
           ResultSet rs = statement.executeQuery();
           if (rs.next()) {
               System.out.println("Успешный вход!");
               System.out.println("--тут типо меню--");
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }
    public void Registration(){
        Scanner in = new Scanner(System.in);
        System.out.println("Логин: ");
        String loginInsert = in.next();
        System.out.println("Пароль : ");
        String passwordInsert = in.next();
        try (Connection conn = DriverManager.getConnection(url, name_db, password);
             Statement myState = conn.createStatement()) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO login2 (login_name, pass) VALUES (?, ?)");

            statement.setString(1, loginInsert);
            statement.setString(2, passwordInsert);
            int rows = statement.executeUpdate();
            System.out.println(rows);
            System.out.println("Пользователь создан!");
            System.out.println("Пожалуйста заполните анкету.Позже ее можно отредактировать!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
