package bowling;

import bowling.domain.FinalFrame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

public class FinalFrameTest {
    @Test
    void 파이널프래임_생성() {
        FinalFrame frame = new FinalFrame();
        assertThat(frame).isEqualTo(new FinalFrame());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void 프래임_0에서10사이(int score) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new FinalFrame().shoot(score);
        });
    }

    @Test
    void 파이널프레임_세개까지_Score생성가능() {
        FinalFrame frame = new FinalFrame();

        frame.shoot(2);
        frame.shoot(3);
        frame.shoot(1);

        assertThat(frame.size()).isEqualTo(3);
    }

    @Test
    void 파이널프레임_네개이상_Score생성불가() {
        FinalFrame frame = new FinalFrame();

        assertThatIllegalStateException().isThrownBy(() -> {
            frame.shoot(2);
            frame.shoot(2);
            frame.shoot(3);
            frame.shoot(1);
        });
    }

    @Test
    void 파이널프레임_스트라이크() {
        FinalFrame frame = new FinalFrame();
        assertThat(frame.shoot(10).getResult()).isEqualTo("X");
    }

    @Test
    void 파이널프레임_스페어() {
        FinalFrame frame = new FinalFrame();

        frame.shoot(3);
        assertThat(frame.shoot(7).getResult()).isEqualTo("/");
    }

    @Test
    void 파이널프레임_미스() {
        FinalFrame frame = new FinalFrame();

        frame.shoot(3);
        assertThat(frame.shoot(3).getResult()).isEqualTo("MISS");
    }
}
