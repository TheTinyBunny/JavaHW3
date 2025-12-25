package domain;

public record Character(String name, String password, int health, int level) {

    public Character(String name, String password) {
        this(name , password , 10 , 1 );
    }
}
