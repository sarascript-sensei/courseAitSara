import java.util.Scanner;

public class Menu {
    public void Menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Вы в главном меню. Куда направимся?");
        System.out.println("1)анкета\n" +
                "2)сообщения\n" +
                "3)люди рядом\n" +
                "4)подходящие партнеры\n" +
                "5)заявки (добавить в друзья и тд) просмотр друзей\n" +
                "6)поиск пользователей\n" +
                "7)просмотр совместимости\n" +
                "8)выход");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                ReadyAnketas anketas = new ReadyAnketas();
            case 2:
                ChatServer chat = new ChatServer();

            case 3:

            case 4:

            case 5:
            case 6:
                FindPerson person = new FindPerson();
                person.FindPerson();
            case 7:
            case 8:
        }
    }
}
