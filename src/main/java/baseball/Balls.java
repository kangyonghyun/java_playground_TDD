package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls implements Playable {

    private List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers =  mapToBall(answers);
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball ball : answers) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }
        return result;
    }

     BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(status -> status.isNotNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

//    public BallStatus play(Ball userBall) {
//        for (Ball answer : answers) {
//            BallStatus status = answer.play(userBall);
//            if (status.equals(BallStatus.NOTHING)) continue;
//            return status;
//        }
//        return BallStatus.NOTHING;
//    }

    private List<Ball> mapToBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }
}
