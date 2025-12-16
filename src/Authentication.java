import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Authentication{

    private HashMap<String, String> users = new HashMap<>();

    public void registerUser(String username, String password){

        users.put(username, password);
        System.out.println("сделал регу юзеру" + username + "  " + password); //лог, потом убрать

        try {

            String filename = username + ".txt";
            File file = new File(filename);
            FileWriter fw = new FileWriter(file);
            // опять же вопрос про bufferedwriter, но как понимаю излишне
            fw.write("логин: " + username + "\n");
            fw.write("пароль: " + password + "\n");
            fw.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean login(String username, String password){
        String stored = users.get(username);
        if(stored == null){
            System.out.println("не нашли такого пользователя");
            return false;
        }
        if(!stored.equals(password)){
            System.out.println("вы успешно не залогинились");
            return false;
        }

        System.out.println("вы вошли как " + username);
        return true;
    }


}
