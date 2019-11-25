package bowling.domain;

import java.util.Objects;

public class NormalFrame implements Frame {
    private static final int NORMAL_SCORES_SIZE = 2;

    private Status status;
    private Scores scores;

    public NormalFrame() {
        this.scores = new Scores(NORMAL_SCORES_SIZE);
    }

    @Override
    public NormalFrame shoot(int score) {
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
        return scores.sum();
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
    public int getFirstScore() {
        return scores.getFirstScore();
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public int size() {
        return scores.size();
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
