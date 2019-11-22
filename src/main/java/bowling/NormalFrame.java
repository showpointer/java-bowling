package bowling;

import java.util.Objects;

public class NormalFrame {
    int score;

    public NormalFrame(int score) {
        checkRange(score);
        this.score = score;
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
        NormalFrame that = (NormalFrame) o;
        return score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
