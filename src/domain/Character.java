package domain;

public record Character(
        String name,
        String password,
        int health,
        int level
) {
    //так написывается record
    //TODO шифрование пароля (придумать и реализовать самому)
    //создать метод прям здесь
    public Character(String name, String password) {
        this(name , password, 10 , 1 );
    }
    private String encryptPassword(String password) {
        return password;
    }

}
