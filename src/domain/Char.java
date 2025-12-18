package domain;

public class Char {
    public String name;
    public String password;
    public int health;
    public int level;

    public Char(String name, String password) {
        this.name = name;
        this.password = password;
        this.health = 10;
        this.level = 1;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public int getHealth(){
        return health;
    }
    public int getLevel(){
        return level;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void showInfoAboutChar(){
        System.out.println("Name: " + name);
        System.out.println("health: " + health);
        System.out.println("level: " + level);
    }




}
