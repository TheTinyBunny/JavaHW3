

import controller.GameController;
import repository.CharacterRepo;
import repository.CharacterRepoImpl;
import service.GameAuthImpl;
import view.GameView;
import view.CharacterView;

public class MainGame {
    public static void main(String[] args) {
        CharacterRepo repository = new CharacterRepoImpl();
        GameAuthImpl authService = new GameAuthImpl(repository);
        GameView gameView = new GameView();
        CharacterView characterView = new CharacterView();
        GameController controller = new GameController(authService, gameView, characterView, repository);
        controller.start();
    }
}