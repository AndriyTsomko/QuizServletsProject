import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Level {
    EASY(3),
    MEDIUM(2),
    HARD(1),
    DEFAULT(3);

    private final int tries;

    public static Level fromString(String level) {
        try {
            return Level.valueOf(level.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Level.DEFAULT;
        }
    }
}
