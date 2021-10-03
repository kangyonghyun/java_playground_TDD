package car;

import car.domain.*;

import java.util.List;

public class Application {

    /*
        1.
     */

    public static void main(String[] args) {
        List<Car> original = RacingGame.initCars("k3,k5,k7");
        RacingGame racingGame = new RacingGame(original, 10);

        while (!racingGame.isFinal()) {
            racingGame.race();
        }

        Cars cars = new Cars(original);
        List<Car> winners = cars.findWinners();

        for (Car winner : winners) {
            System.out.println("winner : " + winner);
        }
    }
}
