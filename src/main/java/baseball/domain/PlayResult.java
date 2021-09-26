package baseball.domain;

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
}
