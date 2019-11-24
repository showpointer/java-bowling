package bowling.domain;

import java.util.List;
import java.util.Objects;

import static bowling.domain.Frame.STRIKE_SCORE;

public class Total {
    public static final int MAX_FRAME_COUNT = 10;
    public static final int FINAL_ROUND_INDEX = 9;
    public static final int NINETH_ROUND_INDEX = 8;
    private static final int MAX_STRIKE_SCORE = STRIKE_SCORE * 3;

    private List<Frame> total;

    public Total(List<Frame> scores) {
        checkRange(scores);
        this.total = scores;
    }

    private void checkRange(List<Frame> scores) {
        if (scores.size() > MAX_FRAME_COUNT) {
            throw new IllegalArgumentException("최대 10라운드 입니다");
        }
    }

    public int getTotalScore() {
        int totalScore = 0;

        for (int round = 0; round < total.size(); round++) {
            totalScore = sumByRound(totalScore, round);
            System.out.println("round: " + round + " , score: " + totalScore + ", type:" + total.get(round).getStatus().getStatus());
        }

        return totalScore;
    }

    private int sumByRound(int score, int round) {
        Frame frame = total.get(round);

        if (round < NINETH_ROUND_INDEX) {
            score += sumByType(frame, round);
            return score;
        }

        if (round == NINETH_ROUND_INDEX) {
            score += sumByTypeAtNinth(frame, round);
            return score;
        }

        if (round == FINAL_ROUND_INDEX) {
            score += frame.getSum();
            return score;
        }

        return score;
    }

    private int sumByType(Frame frame, int round) {
        if (frame.isStrike()) {
            return sumStrike(total.get(round), total.get(round + 1), total.get(round + 2));
        }

        return total.get(round).getSum();
    }

    private int sumByTypeAtNinth(Frame frame, int round) {
        if (frame.isStrike()) {
            return sumStrike(total.get(round), total.get(round + 1), null);
        }
        return total.get(round).getSum();
    }


    private int sumStrike(Frame frame, Frame secondFrame, Frame thirdFrame) {
        System.out.println("is strike");
        if (!secondFrame.isStrike() && thirdFrame == null) {
            return frame.getSum() + secondFrame.getSum();
        }

        if (!secondFrame.isStrike()) {
            return frame.getSum() + secondFrame.getSum();
        }

        if (!thirdFrame.isStrike()) {
            return STRIKE_SCORE + STRIKE_SCORE + thirdFrame.getSum();
        }

        return MAX_STRIKE_SCORE;
    }

    public int size() {
        return this.total.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Total total1 = (Total) o;
        return Objects.equals(total, total1.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
