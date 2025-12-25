package dictionary;

public enum ViewTemplate {

    EX_CHARACTER_HEADER("""
            === ИНФОРМАЦИЯ О ПЕРСОНАЖЕ ===
            """),
    MENU("""
            --- МЕНЮ ---
            1. Создать персонажа
            2. Войти в игру
            3. Показать всех персонажей
            4. Выйти
            Выбери:"""),
    ERROR("""
            Произошла ошибка: %s
            """),
    SUCCESS("""
            Пользователь, %s
            """),
    PASSWORD("""
            Пожалуйста, введите пароль
            """),
    LOGIN("""
            Пожалуйста, введите имя
            """),

    STATS("""
                       Имя: %s
            =============================
            Здоровье: %d
            Уровень: %d
            =============================
            """),
    NO_CHARACTERS("""
            Нет персонажей.
            """),
    CHARACTERS_COUNT("""
            Всего: %d
            """),
    CHARACTERS_HEADER("""
            
            === ВСЕ ПЕРСОНАЖИ ===
            """);


    private String value;

    ViewTemplate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
