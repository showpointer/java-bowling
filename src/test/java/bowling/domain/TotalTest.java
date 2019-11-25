package bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bowling.domain.Total.*;
import static org.assertj.core.api.Assertions.*;

public class TotalTest {
    // Strike
    private Frame strikeFrame = new NormalFrame();
    private Frame finalStrikeAnd5And5 = new FinalFrame();

    // Gutters
    private Frame normalGutters = new NormalFrame();
    private Frame finalGutters = new FinalFrame();

    // Miss
    private Frame miss5And0 = new NormalFrame();
    private Frame fianl2And3 = new FinalFrame();

    @BeforeEach
    void setUp() {
        strikeFrame.shoot(10);
        finalStrikeAnd5And5.shoot(10);
        finalStrikeAnd5And5.shoot(5);
        finalStrikeAnd5And5.shoot(5);
        normalGutters.shoot(0);
        normalGutters.shoot(0);
        finalGutters.shoot(0);
        finalGutters.shoot(0);
        miss5And0.shoot(5);
        miss5And0.shoot(0);
        fianl2And3.shoot(2);
        fianl2And3.shoot(3);
    }

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
    void 미스10_총점_얻기() {
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < FINAL_ROUND_INDEX ; i++) {
            frames.add(miss5And0);
        }
        frames.add(fianl2And3);

        assertThat(new Total(frames).getTotalScore()).isEqualTo(50);
    }

    @Test
    void 스트라이크2_미스8_총점_얻기() {
        List<Frame> frames = new ArrayList<>();

        frames.add(strikeFrame);
        frames.add(strikeFrame);
        for (int i = 0; i < 8 ; i++) {
            frames.add(miss5And0);
        }

        assertThat(new Total(frames).getTotalScore()).isEqualTo(80);
    }

    @Test
    void 미스7_스트라이크3_총점_얻기() {
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < 7 ; i++) {
            frames.add(miss5And0);
        }
        frames.add(strikeFrame);
        frames.add(strikeFrame);
        frames.add(finalStrikeAnd5And5);

        assertThat(new Total(frames).getTotalScore()).isEqualTo(110);
    }

    @Test
    void 미스3_스트라이크7_총점_얻기() {
        List<Frame> frames = new ArrayList<>();

        frames.add(miss5And0);
        frames.add(miss5And0);
        frames.add(miss5And0);

        for (int i = 0; i < 6 ; i++) {
            frames.add(strikeFrame);
        }
        frames.add(finalStrikeAnd5And5);

        assertThat(new Total(frames).getTotalScore()).isEqualTo(210);
    }
}
