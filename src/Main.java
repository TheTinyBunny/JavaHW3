import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        while (true) {
            System.out.println("меню");
            System.out.println("1. регистрация");
            System.out.println("2. вход в аккаунт");
            System.out.println("3. выход из меню");
            System.out.print("выберите опцию (1-3):");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("введите логин: ");
                    String login = scanner.nextLine();
                    System.out.print("введите пароль: ");
                    String password = scanner.nextLine();
                    auth.registerUser(login, password);
                    break;

                case 2:
                    System.out.print("введите логин: ");
                    String loginLogin = scanner.nextLine();

                    System.out.print("введите пароль: ");
                    String loginPassword = scanner.nextLine();

                    boolean loginSuccess = auth.login(loginLogin, loginPassword);

                    if (loginSuccess) {
                        System.out.println("вход в систему");
                    }

                    break;

                case 3:
                    scanner.close();
                    return;
            }
        }
    }
}