package bowling.domain;

public interface Frame {
    int STRIKE_SCORE = 10;

    Frame shoot(int score);

    int size();

    int getSum();

    boolean isStrike();

    boolean isSpare();

    Scores getScores();

    Status getStatus();
}
