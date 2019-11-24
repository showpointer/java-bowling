package bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ScoreTest {
    @Test
    void 스코어_생성() {
        Score score = new Score(10);
        assertThat(score).isEqualTo(new Score(10));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void 스코어_0에서10사이(int score) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Score(score);
        });
    }
}
