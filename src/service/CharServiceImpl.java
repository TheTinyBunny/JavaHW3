package service;

import domain.Char;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CharServiceImpl implements CharService {
    @Override
    public Char createChar(Char character) {
        try {
            String name =  character.getName();

            File file = new File("Characters/" + name + ".txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(name + "\n");
            bw.write(character.getPassword() + "\n");
            bw.write(character.getHealth() + "\n");
            bw.write(character.getLevel() + "\n");

            bw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return character;
    }
}
