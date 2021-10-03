package car;

import car.domain.*;

import java.util.List;

public class Application {

    /*
        1. 자동차 이름이 5글자 이상일 수 없음
        2. 랜덤값 입력 받아 5이상일 경우 움직임
        3. 최종 우승자를 출력 (위치가 젤 높은 수)
     */

    public static void main(String[] args) {
        List<Car> original = RacingGame.initCars("k3,k5,k7");
        RacingGame racingGame = new RacingGame(original, 10);

//        List<Car> winners = Cars.findWinners(original, new Position(8));

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
