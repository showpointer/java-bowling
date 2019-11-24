package bowling.domain;

public interface Frame {
    int STRIKE_SCORE = 10;

    Frame shoot(int score);

    int size();
}
