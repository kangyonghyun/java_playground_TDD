package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomNumber();
        System.out.println(numbers);
    }
}
