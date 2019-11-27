package bowling.controller;

import bowling.domain.Player;
import bowling.domain.Total;
import bowling.service.BowlingGame;
import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingController {

    public static void main(String[] args) {
        Player player = new Player(InputView.getPlayerName());
        ResultView.printStartBoard(player);

        BowlingGame bowlingGame = new BowlingGame(player);
        Total total = bowlingGame.getTotal();
        while (!bowlingGame.isEnd()) {
            total = bowlingGame.play(total);
        }
    }
}


