package bowling.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String getPlayerName() {
        System.out.println("프로그램 실행 결과");
        System.out.println("플레이어 이름은(3 english letters)?:");

        return sc.next();
    }
}
