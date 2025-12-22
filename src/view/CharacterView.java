package view;
import domain.Character;

import java.util.List;

public class CharacterView {

    public void showCharacter(Character character) {
        System.out.println("\n=== ИНФОРМАЦИЯ О ПЕРСОНАЖЕ ===");
        System.out.println("Имя: " + character.name());
        System.out.println("Здоровье: " + character.health());
        System.out.println("Уровень: " + character.level());
        System.out.println("=============================");
    }

    public void showAllCharacters(List<Character> characters) {
        System.out.println("\n=== ВСЕ ПЕРСОНАЖИ ===");

        if (characters.isEmpty()) {
            System.out.println("Нет персонажей.");
            return;
        }

        System.out.println("Всего: " + characters.size());
        System.out.println("------------------");

        for (Character character : characters) {
            System.out.println("Имя: " + character.name());
            System.out.println("Уровень: " + character.level());
            System.out.println("Здоровье: " + character.health());
            System.out.println("------------------");
        }
    }
}
