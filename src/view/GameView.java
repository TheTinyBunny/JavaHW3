package view;
import java.util.Scanner;

public class GameView {

    private final Scanner scanner;

    public GameView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(){
        System.out.println("\n--- МЕНЮ ---");
        System.out.println("1. Создать персонажа");
        System.out.println("2. Войти в игру");
        System.out.println("3. Показать всех персонажей");
        System.out.println("4. Выйти");
        System.out.print("Выбери: ");
    }

    public String readLine(){
        return scanner.nextLine();
    }

    public String readLine(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.out.println("Ошибка: " + error);
    }

    public void showSuccess(String message) {
        System.out.println("это ок " + message);
    }

    public String askForUsername() {
        System.out.print("Введи имя персонажа: ");
        return scanner.nextLine();
    }

    public String askForPassword() {
        System.out.print("Введи пароль: ");
        return scanner.nextLine();
    }
}
