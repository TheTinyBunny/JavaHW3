package service;

import domain.Character;
import repository.CharacterRepo;

public class GameAuthImpl implements GameAuth {

    private final CharacterRepo repository;

    public GameAuthImpl(CharacterRepo repository) {
        this.repository = repository;
    }

    @Override
    public Character register(String username, String password) {
        if (repository.findByName(username) != null) {
            //надпись что такой персонаж существует
            return null;
        }

        Character character = new Character(username, password);
        repository.save(character);
        // надпись о создании перса
        return character;
    }

    @Override
    public Character login(String username, String password) {
        Character character = repository.findByName(username);

        if (character == null) {
            // надпись что такого перса нет
            return null;
        }

        if (!character.password().equals(password)) {
            // надпись что пароль неверный
            return null;
        }

        //надпись что вход состоялся
        return character;
    }
}
