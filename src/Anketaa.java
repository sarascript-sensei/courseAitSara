import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Anketaa {
    public void Anketaa(){
        String url = "jdbc:mysql://localhost:3306/coursework";
        String name_db = "Sara";
        String password = "12345s";
        Scanner in = new Scanner(System.in);
        new BufferedReader(new InputStreamReader(System.in));
        System.out.println("surname: ");
        String surnameInsert = in.next();
        System.out.println("name:");
        String nameInsert = in.next();
        System.out.println("mid_name:");
        String mid_nameInsert = in.next();
        System.out.println("gender:");
        String genderInsert = in.next();
        System.out.println("date_of_birth:");
        String date_of_birthInsert = in.next();
        System.out.println("phone_number:");
        String phone_numberInsert = in.next();
        System.out.println("education:");
        String educationInsert = in.next();
        System.out.println("Знак зодиака:");
        String zodiakInsert = in.next();
        System.out.println("Семейное положение(Замужем/свободен/в отношениях:");
        String maritalInsert = in.next();
        System.out.println("Опишите свои интересы и хобби:");
        String interestInsert = in.next();

        try (Connection conn = DriverManager.getConnection(url, name_db, password);
             Statement myState = conn.createStatement()) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO users (surname,name,mid_name,gender,date_of_birth,phone_number,education,zodiac_sign,marital_status,interests) VALUES (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, surnameInsert);
            statement.setString(2,nameInsert );
            statement.setString(3, mid_nameInsert);
            statement.setString(4, genderInsert);
            statement.setString(5, date_of_birthInsert);
            statement.setString(6, phone_numberInsert);
            statement.setString(7, educationInsert);
            statement.setString(8, zodiakInsert);
            statement.setString(9, maritalInsert);
            statement.setString(10, interestInsert);
            int rows = statement.executeUpdate();
            System.out.println(rows);
            System.out.println("анкета заполнена ");
        } catch (Exception var21) {
            System.out.println("анкета не заполнена, повторите еще раз ");
            System.out.println(var21);
        }

    }
    }
