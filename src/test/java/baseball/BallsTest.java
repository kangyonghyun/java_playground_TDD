package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    /*
        com / user
        1 2 3 / 1 4 -> nothing
        1 2 3 / 1 1 -> strike
        1 2 3 / 1 3 -> ball

        com / user
        1 2 3 / 1 4 5 -> 1strike
        1 2 3 / 1 2 5 -> 2strike
        1 2 3 / 1 2 3 -> 정답!!
        1 2 3 / 4 1 5 -> 1ball
        1 2 3 / 3 1 5 -> 2ball
        1 2 3 / 3 1 2 -> 3ball
        1 2 3 / 1 4 2 -> 1strike 1ball
        1 2 3 / 1 3 2 -> 1strike 2ball
        1 2 3 / 4 5 6 -> nothing
     */

    @Test
    void nothing() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void play_nothing() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = com.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = com.play(Arrays.asList(1, 5, 6));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1ball() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = com.play(Arrays.asList(3, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_1strike_1ball() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = com.play(Arrays.asList(1, 3, 6));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = com.play(Arrays.asList(1, 2, 3));
        assertThat(result.isGameEnd()).isTrue();
    }

}
