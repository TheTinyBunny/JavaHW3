package controller;
import service.GameAuthImpl;
import view.GameView;
import view.CharacterView;
import repository.CharacterRepo;
import domain.Character;
import java.util.List;
public class GameController {
    private final GameAuthImpl authService;
    private final GameView gameView;
    private final CharacterView characterView;
    private final CharacterRepo repository;

    public GameController(GameAuthImpl authService, GameView gameView,
                          CharacterView characterView, CharacterRepo repository) {
        this.authService = authService;
        this.gameView = gameView;
        this.characterView = characterView;
        this.repository = repository;
    }

    public void start() {
        gameView.showMessage("Загружено персонажей: " + repository.count());

        while (true) {
            gameView.showMenu();
            String choice = gameView.readLine();
            switch (choice) {
                case "1":
                    createCharacter();
                    break;
                case "2":
                    loginCharacter();
                    break;
                case "3":
                    showAllCharacters();
                    break;
                case "4":
                    gameView.showMessage("Выход.");
                    return;
                default:
                    gameView.showError("Неверный выбор!");
                    break;
            }

        }
    }

    private void createCharacter() {
        String username = gameView.askForUsername();
        String password = gameView.askForPassword();
        Character newcharacter = authService.register(username, password);
        if (newcharacter != null) {
            gameView.showSuccess("Персонаж создан!");
            characterView.showCharacter(newcharacter);
        } else {
            gameView.showError("Не удалось создать персонажа");
        }
    }

    private void loginCharacter() {
        String username = gameView.askForUsername();
        String password = gameView.askForPassword();
        Character character = authService.login(username, password);
        if (character != null) {
            gameView.showSuccess("вход выполнен");
            characterView.showCharacter(character);
        } else {
            gameView.showError("ошибка при входе?");
        }
    }

    private void showAllCharacters(){
        List<Character> allCharacters = repository.findAll();
        characterView.showAllCharacters(allCharacters);
    }
}
