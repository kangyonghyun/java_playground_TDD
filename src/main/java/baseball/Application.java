package baseball;

import baseball.domain.Balls;
import baseball.domain.NumberGenerator;
import baseball.domain.PlayResult;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> comNumbers = numberGenerator.createRandomNumber();
        Balls comBalls = new Balls(comNumbers);

        while (true) {
            Scanner sc = new Scanner(System.in);
            List<Integer> userNumbers = numberGenerator.toIntegerList(sc.next());

            PlayResult play = comBalls.play(userNumbers);
            if (play.isGameEnd()) {
                System.out.println("정답!!");
                break;
            }
            play.print();
            System.out.println("다시입력 바람");
        }
    }
}