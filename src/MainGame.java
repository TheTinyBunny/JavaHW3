

import controller.GameController;
import repository.CharacterRepo;
import repository.CharacterRepoImpl;
import service.GameAuthImpl;
import view.GameView;
import view.CharacterView;

public class MainGame {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }
}