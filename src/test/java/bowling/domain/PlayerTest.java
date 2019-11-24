package bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    void 플레이어_생성() {
        Player player = new Player("PSJ");
        assertThat(player).isEqualTo(new Player("PSJ"));
    }

    @Test
    void 이름_영어인지_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player("한글사랑");
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "BB", "DDDD"})
    void 이름_3글자인지_검사(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(name);
        });
    }
}
