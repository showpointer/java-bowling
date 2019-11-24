package bowling.service;

import bowling.domain.FinalFrame;
import bowling.domain.Frame;
import bowling.domain.NormalFrame;
import bowling.domain.Total;

import java.util.ArrayList;
import java.util.List;

import static bowling.domain.Total.FINAL_ROUND_INDEX;

public class BowlingGame {
    public static void main(String[] args) {
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

        Total total = new Total(frames);
        total.getTotalScore();
    }
}
