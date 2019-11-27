package bowling.view;

import bowling.domain.Frame;
import bowling.domain.Player;
import bowling.domain.Total;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String headerBoard
            = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

    private static final String scoreFormat
            = "|  %s ";

    private static String[] scores = new String[10];

    public static void printStartBoard(Player player) {
        printHeader();

        Arrays.fill(scores, "   ");
        printBody(player);
    }

    public static void printScoresBoard(Player player, Total total) {
        printHeader();
        printBody(player, total);
    }

    public static void printHeader() {
        System.out.println(headerBoard);
    }

    public static void printBody(Player player) {
        System.out.printf(scoreFormat, player.getName());
        printScores();
    }

    public static void printBody(Player player, Total total) {
        System.out.printf(scoreFormat, player.getName());

        List<Frame> frames = total.getTotal();
        for (int index = 0; index < total.size(); index++) {
            scores[index] = frames.get(index).toString();
        }

        printScores();
    }

    public static void printScores() {
        for (String score : scores) {
            System.out.printf(scoreFormat, score);
        }
        System.out.println("|");
    }
}
