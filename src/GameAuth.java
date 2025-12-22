import domain.Char;
import service.CharService;
import service.CharServiceImpl;

import java.io.*;
import java.util.*;

public class GameAuth {

    CharService charService = new CharServiceImpl();


    HashMap<String, Char> allChars = new HashMap<>();

    public GameAuth() {
        loadCharacters();
    }

    public void loadCharacters() {
        // удалить !!!!!!!!!!!!!
        // насколько вообще правильно делать так? я ведь создаю новый обьект класса каждый раз, когда я подтягиваю
        // сохранения, это просто не может быть правильно, как это исправить? - пока без идей, совсем не понимаю
        // можно исправить, наверное, если хранить где то отдельно только названия персонажей, а при выборе уже
        // подтаскивать нужного перса, но это опять же обращение к БД, что лучше? ( вопросы самому себе )
        File folder = new File("Characters");
        File[] files = folder.listFiles();

        if (files == null) {
            System.err.println("Error: Characters file could not be found.");
            return;
        }
        //не нужно загружать всех персонажей, можно грузить только нужного нам, реализовать через выбор среди имен файлов
        for (File file : files) {

            try {
                Scanner fileScanner = new Scanner(file);

                String name = fileScanner.nextLine();
                String password = fileScanner.nextLine();
                int health = Integer.parseInt(fileScanner.nextLine());
                int level = Integer.parseInt(fileScanner.nextLine());

                fileScanner.close();

                Char loadedChar = new Char(name, password);
                loadedChar.setHealth(health);
                loadedChar.setLevel(level);
                allChars.put(name, loadedChar);


            } catch (Exception e) {
                System.out.println(e + "что то с файлом " + file.getName());
            }
        }
    }
    //паттерн MVC (применяется в спринге)
    public Char register(String username, String password) {
        if (allChars.containsKey(username)) {
            System.out.println("Такой персонаж уже существует");
            return null;
        }

        Char character = new Char(username, password);
        allChars.put(username, character);

//        saveCharacter(character);
        charService.createChar(character);
        //тут мы вынесли действие в отдельный класс

        System.out.println("Новый персонаж " + username + " создан");
        return character;
    }

    public Char login(String username, String password) {
        Char character = allChars.get(username);

        if (character == null) {
            System.out.println("Такого персонажа нет");
            return null;
        }

        if (!character.password.equals(password)) {
            System.out.println("Неверный пароль!");
            return null;
        }

        System.out.println("Вход выполнен!");
        return character;
    }

    private void saveToFile(String username, String password, int health, int level) {
        try {

            File file = new File("Characters/" + username + ".txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(username + "\n");
            bw.write(password + "\n");
            bw.write(health + "\n");
            bw.write(level + "\n");

            bw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveCharacter(Char character) {
        saveToFile(character.getName(), character.getPassword(), character.getHealth(), character.getLevel());
    }

    // заделка под изменение персонажа и запись об этом в бд - будет ли оно в реальном времени работать? наверное да.
    public void updateCharacter(Char character) {
        allChars.put(character.getName(), character);
        saveCharacter(character);
    }
    // задекла под то, что чара можно удалить
    public void deleteCharacter(Char character) {
        allChars.remove(character.getName());
        File file = new File("Characters/" + character.getName() + ".txt");
        file.delete(); // возможно это очень опасно не знаю
    }

}