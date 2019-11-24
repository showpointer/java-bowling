package bowling;

import java.util.Objects;

public class NormalFrame {
    private static final int STRIKE_SCORE = 10;

    private String result;
    private Scores scores;

    public NormalFrame() {
        this.scores = new Scores();
    }

    public NormalFrame(int score) {
        this();
        this.scores.add(new Score(score));
    }

    public NormalFrame shoot(int score) {
        scores.add(new Score(score));

        if (isStrike(score)) {
            result = "X";
            return this;
        }

        if (isSpare()) {
            result = "/";
            return this;
        }

        result = "MISS";
        return this;
    }

    private boolean isStrike(int score) {
        return score == STRIKE_SCORE;
    }

    private boolean isSpare() {
        return scores.isSpare();
    }

    public String getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalFrame that = (NormalFrame) o;
        return Objects.equals(scores, that.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }
}
