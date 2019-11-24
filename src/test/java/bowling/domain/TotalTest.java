package bowling.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bowling.domain.Total.*;
import static org.assertj.core.api.Assertions.*;

public class TotalTest {
    @Test
    void 토탈_생성() {
        Frame frame = new NormalFrame();
        Total total = new Total(Arrays.asList(frame));
        assertThat(total).isEqualTo(new Total(Arrays.asList(frame)));
    }

    @Test
    void 토탈_최대10라운드() {
        Frame frame = new NormalFrame();

        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            frames.add(frame);
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Total(frames);
        });
    }

    @Test
    void 토탈2회_미스_미스_총점_얻기() {
        Frame normalFirstFrame = new NormalFrame();
        normalFirstFrame.shoot(2);
        normalFirstFrame.shoot(3);

        Frame normalSecondFrame = new NormalFrame();
        normalSecondFrame.shoot(3);
        normalSecondFrame.shoot(2);

        List<Frame> frames = Arrays.asList(normalFirstFrame, normalSecondFrame);

        assertThat(new Total(frames).getTotalScore()).isEqualTo(10);
    }

    @Test
    void 토탈2회_스트라이크_미스_총점_얻기() {
        Frame strikeFrame = new NormalFrame();
        strikeFrame.shoot(10);

        Frame missFrame = new NormalFrame();
        missFrame.shoot(3);
        missFrame.shoot(2);

        List<Frame> frames = Arrays.asList(strikeFrame, missFrame);
        assertThat(new Total(frames).getTotalScore()).isEqualTo(20);
    }

    @Test
    void 토탈3회_스트라이크_스트라이크_미스_총점_얻기() {
        Frame strikeFrame = new NormalFrame();
        strikeFrame.shoot(10);

        Frame missFrame = new NormalFrame();
        missFrame.shoot(3);
        missFrame.shoot(2);

        List<Frame> frames = Arrays.asList(strikeFrame, strikeFrame, missFrame);
        assertThat(new Total(frames).getTotalScore()).isEqualTo(30);
    }

    @Test
    void 토탈10회_생성() {
        Frame missFrame = new NormalFrame();
        missFrame.shoot(3);
        missFrame.shoot(2);

        Frame finalFrame = new FinalFrame();
        finalFrame.shoot(3);
        finalFrame.shoot(2);

        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < FINAL_ROUND_INDEX ; i++) {
            frames.add(missFrame);
        }
        frames.add(finalFrame);

        assertThat(new Total(frames).size()).isEqualTo(10);
    }

    @Test
    void 토탈10회_올_미스_총점_얻기() {
        Frame missFrame = new NormalFrame();
        missFrame.shoot(3);
        missFrame.shoot(2);

        Frame finalFrame = new FinalFrame();
        finalFrame.shoot(3);
        finalFrame.shoot(2);

        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < FINAL_ROUND_INDEX ; i++) {
            frames.add(missFrame);
        }
        frames.add(finalFrame);

        new Total(frames).getTotalScore();
        //assertThat(new Total(frames).getTotalScore()).isEqualTo(50);
    }
}
