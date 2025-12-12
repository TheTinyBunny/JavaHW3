import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        while(true){
            System.out.println("Меню");
            System.out.println("1. Регистрация");
            System.out.println("2. Вход");
            System.out.println("3. Выход");
            System.out.print("Выберите действие (1-3): ");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("\n--- РЕГИСТРАЦИЯ ---");
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();

                    System.out.print("Введите логин: ");
                    String login = scanner.nextLine();

                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();

                    auth.registerUser(name, login, password);
                    break;
                case "2":

                    System.out.println("\n--- ВХОД В СИСТЕМУ ---");
                    System.out.print("Введите логин: ");
                    String loginEnter = scanner.nextLine();

                    System.out.print("Введите пароль: ");
                    String passwordEnter = scanner.nextLine();

                    boolean success = auth.login(loginEnter, passwordEnter);

                    if (success) {
                        System.out.println("Вы успешно вошли");
                    }
                    break;
                case "3":
                    System.out.println("До свидания!");
                    scanner.close();
                    return;
            }
        }
    }
}