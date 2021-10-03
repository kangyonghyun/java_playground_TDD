package car.domain;

import java.util.Objects;

public class Car {

    private CarName name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return this.position = position.move();
        }
        return position;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.lessThan(maxPosition)) {
            return maxPosition;
        }
        return position;
    }

    // 랜덤값 테스트용
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    public Position move(int num) {
        if (num >= FORWARD_NUM) {
            return this.position = position.move();
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
