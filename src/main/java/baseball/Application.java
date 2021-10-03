package baseball;

import baseball.domain.Balls;
import baseball.domain.NumberGenerator;
import baseball.domain.PlayResult;

import java.util.List;
import java.util.Scanner;

public class Application {

    /*
       - 컴퓨터 수와 1자리와 입력한 수 1자리와 비교 - Ball
       - 컴퓨터 수 3자리와 입력한 수 1자리씩 비교 - Balls
       - 컴퓨터 수 3자리와 입력한 수 3자리씩 비교 - Balls
       - strike / ball 확인 - PlayResult
       - 1부터 9까지 서로 다른 임의수 3개 생성 - NumberGenerator
     */

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