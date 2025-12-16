package domain;

import java.util.UUID;
//хранилище всей статистики
public record User(
        UUID id,
        String login,
        String password
) {
}
