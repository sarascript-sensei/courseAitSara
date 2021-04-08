import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String name_db = "Sara";
        String password = "12345s";
        try (Connection con = DriverManager.getConnection(url, name_db, password);
             Statement statement = con.createStatement();
        ) {

            PreparedStatement ps1 = con.prepareStatement("Insert into books(price) values" +
                    "(25)," +
                    "(464)," +
                    "(543)," +
                    "(15125)," +
                    "(5124)," +
                    "(20000)," +
                    "(414)," +
                    "(55)");
            ResultSet set = ps1.executeQuery("Select price from books");

            while (set.next()) {
                {
                    System.out.println("\nцена: " + set.getString("price"));
                }
            }
        }
    }
}