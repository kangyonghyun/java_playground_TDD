package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayResult {

    public static final int GAME_END_NUMBER = 3;
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike())
            strike++;
        if (status.isBall())
            ball++;
    }

    public boolean isGameEnd() {
        return strike == GAME_END_NUMBER;
    }

    public void print() {
        if (strike != 0 && ball !=0)
            System.out.print(strike + "스트라이크 " + ball + "볼");
        if (strike != 0)
            System.out.println(strike + "스트라이크");
        if (ball != 0)
            System.out.println(ball + "볼");
    }

    private static List<Integer> toIntegerList(String string) {
        List<Integer> list = Arrays.stream(string.split(""))
                .map(str -> Integer.valueOf(str))
                .collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
        String ran = String.valueOf((int)(Math.random()*1000));
        System.out.println(ran);
        List<Integer> comList = PlayResult.toIntegerList(ran);
        Balls com = new Balls(comList);

        while (true) {
            Scanner sc = new Scanner(System.in);
            List<Integer> userList = PlayResult.toIntegerList(sc.next());
            PlayResult play = com.play(userList);
            if (play.isGameEnd()) {
                System.out.println("정답!!");
                break;
            }
            play.print();
            System.out.println("다시입력 바람");
        }
    }


}
