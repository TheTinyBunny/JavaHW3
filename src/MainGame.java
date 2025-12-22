import domain.Char;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameAuth auth = new GameAuth();

        System.out.println("Загружено персонажей: " + auth.allChars.size());

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Создать персонажа");
            System.out.println("2. Войти в игру");
            System.out.println("3. Показать всех персонажей");
            System.out.println("4. Выйти");
            System.out.print("Выбери: ");
            //некрасиво и неправильно, можно написать в отдельном месте, еще и не писать строчка за строчкой - переделать

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Введи имя персонажа: ");
                String name = scanner.nextLine();

                System.out.print("Введи пароль: ");
                String password = scanner.nextLine();

                Char newChar = auth.register(name, password);

                if (newChar != null) {
                    System.out.println("Персонаж создан!");
                    newChar.showInfoAboutChar();

                    auth.saveCharacter(newChar);
                    System.out.println("Персонаж сохранен в файл.");
                }

            } else if (choice.equals("2")) {

                System.out.print("Введи имя персонажа: ");
                String name = scanner.nextLine();

                System.out.print("Введи пароль: ");
                String password = scanner.nextLine();

                Char foundChar = auth.login(name, password);

                if (foundChar != null) {
                    System.out.println("Успешный вход!");
                    foundChar.showInfoAboutChar();
                }

            } else if (choice.equals("3")) {

                System.out.println("\n=== ВСЕ ПЕРСОНАЖИ ===");

                if (auth.allChars.isEmpty()) {
                    System.out.println("Нет персонажей.");
                } else {
                    System.out.println("Всего: " + auth.allChars.size());
                    System.out.println("------------------");

                    for (Char character : auth.allChars.values()) {
                        System.out.println("Имя: " + character.name);
                        System.out.println("Уровень: " + character.level);
                        System.out.println("Здоровье: " + character.health);
                        System.out.println("------------------");
                    }
                    // сюда нужно выводить view, тк это еще view обьект, вот тут пригодятся рекорды
                }

            } else if (choice.equals("4")) {
                System.out.println("Выход.");
                break;

            } else {
                System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
    }
}