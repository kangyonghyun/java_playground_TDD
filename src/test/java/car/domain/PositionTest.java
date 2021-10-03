package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void 정상_position() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void 에러_position() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Position position = new Position();
        Position move = position.move();
        assertThat(move).isEqualTo(new Position(1));
    }

    @Test
    void lessThan() {
        Position position = new Position(1);
        assertThat(position.lessThan(new Position(2))).isTrue();
    }
}
