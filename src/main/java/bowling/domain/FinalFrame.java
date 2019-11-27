package bowling.domain;

import java.util.Objects;

public class FinalFrame implements Frame {
    private static final int MISS_FINAL_SCORES_SIZE = 2;
    private static final int FINAL_SCORES_SIZE = 3;

    private Status status;
    private Scores scores;

    public FinalFrame() {
        this.scores = new Scores(FINAL_SCORES_SIZE);
    }

    @Override
    public FinalFrame shoot(int score) {
        scores.add(new Score(score));

        if (isStrike()) {
            status = status.STRIKE;
            return this;
        }

        if (isSpare()) {
            status = status.SPARE;
            return this;
        }

        status = status.MISS;
        return this;
    }

    @Override
    public int getSum() {
        if (size() == MISS_FINAL_SCORES_SIZE) {
            return getFirstSecondSum();
        }

        return scores.sum();
    }

    public int getFirstSecondSum() {
        return scores.sumFirstAndSecound();

    }

    public int getFirstScore() {
        return scores.getFirstScore();
    }

    private int getSecondScore() {
        return scores.getSecondScore();
    }

    @Override
    public boolean isStrike() {
        return scores.isStrike();
    }

    @Override
    public boolean isSpare() {
        return scores.isSpare();
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public int size() {
        return scores.size();
    }

    public String toString() {
        if (isStrike()) {
            return Status.STRIKE.getStatus();
        }

        if (isSpare()) {
            return getFirstScore() + "|" + Status.SPARE.getStatus();
        }

        if (size() < MISS_FINAL_SCORES_SIZE) {
            return Status.GUTTER.getGutter(getFirstScore());
        }

        return Status.GUTTER.getGutter(getFirstScore()) + "|" + Status.GUTTER.getGutter(getSecondScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalFrame that = (FinalFrame) o;
        return status == that.status &&
                Objects.equals(scores, that.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, scores);
    }
}
