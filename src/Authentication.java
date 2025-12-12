import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Authentication{


    public void registerUser(String name, String password, String login){

        try {
            String fileName = name + ".txt";

            FileWriter fileWriter = new FileWriter(fileName);
            // добавть BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); -?
            fileWriter.write(login + "\n");

            fileWriter.write(password + "\n");

            fileWriter.close();

        } catch (IOException e){
            System.out.println(e);
        }
    }

    public boolean login(String login, String password) {
        try {
            File folder = new File(".");
            File[] files = folder.listFiles();

            for (File file : files) {
                if (file.getName().endsWith(".txt")) {
                    Scanner fileScanner = new Scanner(file);

                    if (!fileScanner.hasNextLine()) {
                        fileScanner.close();
                        continue;
                    }

                    String fileLogin = fileScanner.nextLine();

                    if (!fileScanner.hasNextLine()) {
                        fileScanner.close();
                        continue;
                    }

                    String filePassword = fileScanner.nextLine();
                    fileScanner.close();

                    if (fileLogin.equals(login) && filePassword.equals(password)) {
                        System.out.println("Добро пожаловать, " + login + "!");
                        return true;
                    }
                }
            }

            System.out.println("Неверный логин или пароль!");
            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
