package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public static final int MAX_SIZE = 3;

    public List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_SIZE) {
            int number = new Random().nextInt(9) + 1;
            if (numbers.contains(number)) continue;
            else numbers.add(number);
        }
        return numbers;
    }

}