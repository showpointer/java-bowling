package bowling;

import java.util.Objects;

public class Score {
    private int score;

    public Score(int score) {
        checkRange(score);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    private void checkRange(int score) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("투구 수는 0~10사이여야 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
