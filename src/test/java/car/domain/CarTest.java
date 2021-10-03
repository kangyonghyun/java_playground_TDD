package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 이동() {
        Car car = new Car("sonata");
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_이동() {
        Car car = new Car("sonata");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car("sonata");
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 최대_위치값() {
        Car car = new Car("sonata", 1);
        Position maxPosition = car.getMaxPosition(new Position(2));
        assertThat(maxPosition).isEqualTo(new Position(2));
    }
}