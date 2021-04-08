import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;


public class Anketa {
    public static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/coursework";
        String name="Sara";
        String password="12345s";
        Scanner in = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Анкета: ");
        String AnketaInsert=in.next();

        System.out.println("first_name:");
        String firstNameInsert = in.next();

        System.out.println("last_name: ");
        String lastNameInsert = in.next();

        System.out.println("age:");
        String ageInsert = in.next();

        System.out.println("gender:");
        String genderInsert = in.next();

        System.out.println("city:");
        String cityInsert = in.next();

        System.out.println("hobbies:");
        String hobbiesInsert = in.next();

        System.out.println("email:");
        String emailInsert = in.next();

        System.out.println("partner description:");
        String partnerDescriptionInsert = in.next();

        System.out.println("zodiac:");
        String zodiakInsert = in.next();


        try{
            String sql="INSERT INTO login2 (first_name,first_name,age,gender,city,hobbies,email,partner description,zodiak) VALUES(?,?,?,?,?,?,?,?,?)";
            Connection myConnection= DriverManager.getConnection(url, name, password);
            Statement myStatement= myConnection.createStatement();
            PreparedStatement preparedStatement=myConnection.prepareStatement(sql);

            preparedStatement.setString (1, AnketaInsert);
            preparedStatement.setString (2, lastNameInsert);
            preparedStatement.setInt (3, Integer.parseInt(ageInsert));
            preparedStatement.setString(4,genderInsert);
            preparedStatement.setString(5,cityInsert);
            preparedStatement.setString(6,hobbiesInsert);
            preparedStatement.setString(7,emailInsert);
            preparedStatement.setString(8,partnerDescriptionInsert);
            preparedStatement.setString(9,zodiakInsert);


            int rows = myStatement.executeUpdate(sql);
            System.out.println(rows);
            System.out.println("анкета заполнена ");

        } catch (Exception ex){
            System.out.println("анкета не заполнена, повторите еще раз ");
            System.out.println(ex);


        }
    }
}