import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class FindPerson {
    String url = "jdbc:mysql://localhost:3306/coursework";
    String name_db = "Sara";
    String password = "12345s";
    Scanner in = new Scanner(System.in);
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public void FindPerson(){
        Scanner in = new Scanner(System.in);
        System.out.println("Впишите имя пользователя: ");
        String findPerson = in.next();
        try (Connection conn = DriverManager.getConnection(url, name_db, password);
             Statement myState = conn.createStatement()) {
            PreparedStatement statement = conn.prepareStatement("Select name from users where name=?");

            statement.setString(1, findPerson);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Пользователь найден!");
                System.out.println(findPerson);
                System.out.println("Отправить заявку на дружбу? \n" +
                        "1.Да" +
                        "2.Нет");
            }
            String reshenie = in.next();
            if(reshenie.equals("1")) {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    }
