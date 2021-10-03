package car.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private int tryNo;


    public RacingGame(List<Car> cars, int tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public static List<Car> initCars(String carName) {
        if (StringUtils.isBlank(carName)) {
            throw new IllegalArgumentException("자동차 이름값은 존재해야 합니다.");
        }

        String[] carArr = carName.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carArr) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        this.tryNo--;
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(new RandomMovingStrategy());
        }
    }

    public boolean isFinal() {
        return tryNo == 0;
    }

}
