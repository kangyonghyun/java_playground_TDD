package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void create() {
        List<Car> car = new ArrayList<>();
        Cars cars = new Cars(car);
    }

    @Test
    void findWinners() {
        Car sonata = new Car("sonata", 2);
        Car k5 = new Car("k5", 2);
        Car k9 = new Car("k9", 3);

        List<Car> original = Arrays.asList(sonata, k5, k9);
        Cars cars = new Cars(original);
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(k9);
    }
}
