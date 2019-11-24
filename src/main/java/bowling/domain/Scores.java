package bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bowling.domain.Frame.STRIKE_SCORE;

public class Scores {
    private int maxScoresSize = 2;
    private static final int MAX_SCORES_SUM = 10;

    private List<Score> scores;

    public Scores(int scoresSize) {
        this.maxScoresSize = scoresSize;
        this.scores = new ArrayList<>();
    }

    public Scores(List<Score> scores) {
        this.scores = scores;
        checkSum();
    }

    public void add(Score score) {
        scores.add(score);

        if (scores.size() > maxScoresSize) {
            throw new IllegalStateException("마지막 프레임이 아니면 프레임 당 스코어는 최대 " + maxScoresSize + "개입니다");
        }
        checkSum();
    }

    private void checkSum() {
        int sum = sum();

        if (sum > MAX_SCORES_SUM) {
            throw new IllegalStateException("Score의 합이 " + MAX_SCORES_SUM + "을 넘을 수 없습니다");
        }
    }

    public int sum() {
        return scores.stream()
                .map(Score::getScore)
                .reduce(0, Integer::sum);
    }

    public int sumFirstAndSecound() {
        return scores.get(0).getScore() + scores.get(1).getScore();
    }

    public int getFirstScore() {
        return scores.get(0).getScore();
    }


    public boolean isStrike() {
        return scores.get(0).getScore() == STRIKE_SCORE;
    }

    public boolean isSpare() {
        return sum() == MAX_SCORES_SUM;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scores scores1 = (Scores) o;
        return Objects.equals(scores, scores1.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }

    public int size() {
        return scores.size();
    }
}
