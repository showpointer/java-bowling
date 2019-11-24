package bowling.domain;

import java.util.Objects;

public class FinalFrame implements Frame {
    private static final int FINAL_SCORES_SIZE = 3;

    private String result;
    private Scores scores;

    public FinalFrame() {
        this.scores = new Scores(FINAL_SCORES_SIZE);
    }

    public FinalFrame shoot(int score) {
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

    public int size() {
        return scores.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalFrame that = (FinalFrame) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(scores, that.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, scores);
    }

}
