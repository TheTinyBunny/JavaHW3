package view;
import dictionary.ViewTemplate;
import domain.Character;

import java.util.List;

public class CharacterView {

    public void showCharacter(Character character) {
        String formatted = ViewTemplate.STATS.getValue().formatted(character.name(), character.health(), character.level());
        System.out.println(formatted);
    }

    public void showAllCharacters(List<Character> characters) {
        System.out.println(ViewTemplate.CHARACTERS_HEADER.getValue());

        if (characters.isEmpty()) {
            System.out.println(ViewTemplate.NO_CHARACTERS.getValue());
            return;
        }

        String template = ViewTemplate.CHARACTERS_COUNT.getValue().formatted(characters.size());
        System.out.println(template);

        for (Character character : characters) {
            String formatted = ViewTemplate.STATS.getValue().formatted(
                    character.name(),
                    character.health(),
                    character.level()
            );
            System.out.println(formatted);
        }
    }
}
