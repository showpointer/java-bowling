package bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class FrameTest {
    @Test
    void 프래임_생성() {
        NormalFrame frame = new NormalFrame(10);
        assertThat(frame).isEqualTo(new NormalFrame(10));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void 프래임_0에서10사이(int score) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new NormalFrame(score);
        });
    }

    @Test
    void 프레임_스트라이크() {
        NormalFrame frame = new NormalFrame();
        assertThat(frame.shoot(10).getResult()).isEqualTo("X");
    }

    @Test
    void 프레임_스페어() {
        NormalFrame frame = new NormalFrame();

        frame.shoot(3);
        assertThat(frame.shoot(7).getResult()).isEqualTo("/");
    }

    @Test
    void 프레임_미스() {
        NormalFrame frame = new NormalFrame();

        frame.shoot(3);
        assertThat(frame.shoot(3).getResult()).isEqualTo("MISS");
    }
}
