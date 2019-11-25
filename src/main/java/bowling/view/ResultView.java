package bowling.view;

import bowling.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DELIMITER = "|";

    private static List<String> headerBoard
            = Arrays.asList("NAME", " 01 ", " 02 ", " 03 ", " 04 ", " 05 ", " 06 ", " 07 ", " 08 ", " 09 ", " 10 ");
    private static List<String> sampleBoard
            = Arrays.asList("", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ");

    public static void print(Player player) {
        System.out.println("|" + headerBoard.stream()
                .collect(Collectors.joining(DELIMITER)));

        sampleBoard.set(0, player.getName());

        System.out.println("|" + sampleBoard.stream()
                .collect(Collectors.joining(DELIMITER)));
    }
}
