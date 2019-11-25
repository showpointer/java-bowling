package bowling.controller;

import bowling.domain.Player;
import bowling.view.InputView;
import bowling.view.ResultView;

public class bowlingController {
    Player player = new Player(InputView.getPlayerName());

    ResultView.print(player);
}
