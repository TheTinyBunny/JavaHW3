package service;

import domain.Character;

public interface GameAuth {
    Character register(String username, String password);
    Character login(String username, String password);
}
