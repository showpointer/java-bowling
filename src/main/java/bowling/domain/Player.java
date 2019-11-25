package bowling.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {
    private static String ENGLISH_REGEX = "^[a-zA-Z]*$";
    private static int NAME_SIZE = 3;
    private static Pattern pattern = Pattern.compile(ENGLISH_REGEX);

    private String name;

    public Player(String name) {
        checkEnglish(name);

        if (name.length() != NAME_SIZE) {
            throw new IllegalArgumentException("이름은 3글자여야 합니다");
        }
        this.name = name;
    }

    private void checkEnglish(String name) {
        if (!pattern.matcher(name).matches()) {
            throw new IllegalArgumentException("영어가 아닙니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return this.name;
    }
}
