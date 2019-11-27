package bowling.service;

import bowling.domain.*;
import bowling.view.InputView;
import bowling.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static bowling.domain.Total.FINAL_ROUND_INDEX;
import static bowling.domain.Total.MAX_FRAME_COUNT;

public class BowlingGame {
    private Total total;
    private int round;
    private Player player;

    public BowlingGame(Player player) {
        this.total = new Total();
        this.round = 0;
        this.player = player;
    }

    public Total play(Total total) {
        this.total = total;
        Total playedTotal;

        int frameScore = InputView.getFrameScore(round);

        List<Frame> frames = new ArrayList<>();
        Frame frame = new NormalFrame().shoot(frameScore);
        playedTotal = new Total(frames);

        if (frame.getStatus() == Status.STRIKE) {
            frames.add(frame);
            ResultView.printScoresBoard(player, playedTotal);
            return playedTotal;
        }

        ResultView.printScoresBoard(player, playedTotal);

        int secondScore = InputView.getFrameScore(round);
        frame.shoot(secondScore);

        if (frame.isSpare()) {
            frames.add(frame);
            ResultView.printScoresBoard(player, total);
            return new Total();
        }

        ResultView.printScoresBoard(player, total);

        return new Total(frames);
    }

    public boolean isFinalRound() {
        return this.total.size() == FINAL_ROUND_INDEX;
    }

    public boolean isEnd() {
        return this.total.size() > MAX_FRAME_COUNT;
    }

    public int getRound() {
        return this.total.size();
    }

    public Total getTotal() {
        return this.total;
    }
}
