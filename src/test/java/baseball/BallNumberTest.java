package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallNumberTest {

    @Test
    void create() {
        BallNumber ballNumber = new BallNumber(1);
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            new BallNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
