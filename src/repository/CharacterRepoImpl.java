package repository;
import domain.Character;
import java.io.*;
import java.nio.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CharacterRepoImpl implements CharacterRepo {

    HashMap<String, Character> allChars = new HashMap<>();

    public CharacterRepoImpl() {
        loadCharacters();
    }


    @Override
    public void save(Character character) {
        allChars.put(character.name(), character);
        safeToFile(character);
    }

    @Override
    public void loadCharacters() {
        // тут все неправильно сделана подгрузка, изменить.
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

                Character loadedChar = new Character(name, password,health,level);
                allChars.put(name, loadedChar);


            } catch (Exception e) {
                System.out.println(e + "что то с файлом " + file.getName());
            }
        }
    }

    @Override
    public void safeToFile(Character character) {

        try {

            File file = new File("Characters/" + character.name() + ".txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(character.name() + "\n");
            bw.write(character.password() + "\n");
            bw.write(character.health() + "\n");
            bw.write(character.level() + "\n");

            bw.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @Override
    public Character findByName(String name) {
        return allChars.get(name);
    }

    @Override
    public List<Character> findAll() {
        return new ArrayList<>(allChars.values());
    }

    @Override
    public int count() {
        return allChars.size();
    }

    @Override
    public void delete(String name) {
        allChars.remove(name);
        File file = new File("Characters/" + name + ".txt");
        if (file.exists()) {
            file.delete();
        }
    }
}
