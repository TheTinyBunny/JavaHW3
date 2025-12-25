package service;

import domain.Character;
import repository.CharacterRepo;
import repository.CharacterRepoImpl;

public class GameAuthImpl implements GameAuth {

    private final CharacterRepo repository;

    public GameAuthImpl(CharacterRepo repository) {
        this.repository = repository;
    }

    @Override
    public Character register(String username, String password) {
        if (repository.findByName(username) != null) {
            System.out.println("Username already exists!");
            return null;
        }

        Character character = new Character(username, password);
        repository.save(character);
        System.out.println("Character registered successfully!");
        return character;
    }

    @Override
    public Character login(String username, String password) {
        Character character = repository.findByName(username);

        if (character == null) {
            System.out.println("Username not found!");
            return null;
        }

        if (!character.password().equals(password)) {
            System.out.println("Wrong password!");
            return null;
        }

        System.out.println("Logged in successfully!");
        return character;
    }
}
