import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws IOException {

        System.out.println("Добро пожаловать в сайт знакомств!");
        System.out.println("1.Желаете войти в систему? \n" +
                "2.Зарегистрироваться?");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        if (choice.equals("1")) {
            LoginRegistation login = new LoginRegistation();
            login.Login();
            Menu menu = new Menu();
            menu.Menu();

        }
        else if(choice.equals("2")){
            LoginRegistation reg = new LoginRegistation();
            reg.Registration();
            Anketaa anketa = new Anketaa();
            anketa.Anketaa();
            Menu menu = new Menu();
            menu.Menu();
        }
    }
}
