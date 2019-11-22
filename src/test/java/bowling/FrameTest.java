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
}
