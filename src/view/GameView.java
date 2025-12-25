package view;
import dictionary.ViewTemplate;

import java.util.Scanner;

public class GameView {

    private final Scanner scanner;

    public GameView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(){
        System.out.print(ViewTemplate.MENU.getValue());
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
        System.out.println(ViewTemplate.ERROR.getValue().formatted(error));
    }

    public void showSuccess(String message) {
        System.out.println(ViewTemplate.SUCCESS.getValue().formatted(message));
    }

    public String askForUsername() {
        System.out.print(ViewTemplate.LOGIN.getValue());
        return scanner.nextLine();
    }

    public String askForPassword() {
        System.out.print(ViewTemplate.PASSWORD.getValue());
        return scanner.nextLine();
    }
}
