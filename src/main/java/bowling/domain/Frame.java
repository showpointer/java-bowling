package bowling.domain;

public interface Frame {
    int STRIKE_SCORE = 10;

    Frame shoot(int score);

    int size();

    int getSum();

    int getFirstScore();

    boolean isStrike();

    boolean isSpare();

    Status getStatus();
}
