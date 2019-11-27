package bowling.domain;

public enum Status {
    STRIKE("X"),
    SPARE("/"),
    MISS("MISS"),
    GUTTER("-");

    private String status;

    Status(String s) {
        this.status = s;
    }

    public String getStatus() {
        return status;
    }

    public String getGutter(int score) {
        if (score == 0) {
            return GUTTER.getStatus();
        }
        return String.valueOf(score);
    }
}
