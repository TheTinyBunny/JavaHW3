package repository;
import domain.Character;

import java.util.List;

public interface CharacterRepo {
    void save(Character character);
    void loadCharacters();
    void safeToFile(Character character);
    Character findByName(String name); // у меня неправльная реализция, переписать.
    List<Character> findAll();
    int count();
    void delete(String name);
}
