package cinema;

import java.util.UUID;

public class Token {

    UUID token;

    Token() {
        token = UUID.randomUUID();
    }
    Token(UUID number) {
        token = number;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
