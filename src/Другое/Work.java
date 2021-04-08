import java.sql.*;

public class Work {
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "Sara";
    String password = "12345s";
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;

            statement.executeUpdate("Create table if not exists market(" +
                    "id int not null auto_increment," +
                    "productCategory varchar(50)," +
                    "productname  varchar(50)," +
                    "price int," +
                    "brand varchar (50)," +
                    "PRIMARY KEY(id))");

        statement.executeUpdate("Insert into market(productCategory,productname,price,brand) values" +
                "('Напиток','Пепси',25, 'Coca-Cola')," +
                "('Полуфабрикаты','Колбаса', 600,'Салих')," +
                "('Полуфабрикаты','Сосиски', 750,'Салих')," +
                "('Полуфабрикаты','Сыр', 300,'Салих')," +
                "('Молочная продукция','Молоко', 50,'Веселый молочник')," +
                "('Молочная продукция','Кефир', 50,'Веселый молочник')," +
                "('Молочная продукция','Йогурт', 50,'Веселый молочник')," +
                "('Конфеты и печенье', 'Печенье',70,'Юбилейное')");
            String sql = "SELECT * FROM market";

            Boolean isRetrieved = statement.execute(sql);

            System.out.println("Is data retrieved: " + isRetrieved);

            System.out.println("Displaying retrieved data:");
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String productCategory = resultSet.getString("productCategory");
                String productname = resultSet.getString("productname");
                int price = resultSet.getInt("price");
                String brand = resultSet.getString("brand");


                System.out.println("productCategory" + productCategory);
                System.out.println("productname: " + productname);
                System.out.println("price: " + price);
                System.out.println("brand: " + brand);
                System.out.println("\n===================\n");
            }

            System.out.println("Closing connection and releasing resources...");

            try {
                resultSet.close();
                statement.close();
                connection.close();
            }finally {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }
            System.out.println("Thank You.");
        }
    }