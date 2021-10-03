package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 이동() {
        Car car = new Car("k5");
        Position move = car.move(5);
        assertThat(move).isEqualTo(new Position(1));
    }

    @Test
    void 랜덤_이동() {
        Car car = new Car("k5");
        Position move = car.move(() -> true);
        assertThat(move).isEqualTo(new Position(1));
    }

    @Test
    void 정지() {
        Car car = new Car("k5");
        Position move = car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(move).isEqualTo(new Position());
    }

    @Test
    void 최대_위치값() {
        Car car = new Car("k5", 1);
        Position maxPosition = car.getMaxPosition(new Position(2));
        assertThat(maxPosition).isEqualTo(new Position(2));
    }
}