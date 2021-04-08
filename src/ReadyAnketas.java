import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class ReadyAnketas {
    String url = "jdbc:mysql://localhost:3306/coursework";
    String name_db = "Sara";
    String password = "12345s";
    Scanner in = new Scanner(System.in);
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public void ReadyAnketas() {
        try (
                Connection conn = DriverManager.getConnection(url, name_db, password);
                Statement myState = conn.createStatement()) {
            PreparedStatement statement = conn.prepareStatement("Select ");

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Пользователь найден!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
