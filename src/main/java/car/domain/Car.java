package car.domain;

public class Car {

    private String name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.lessThan(maxPosition)) {
            return maxPosition;
        }
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position.getPosition() +
                '}';
    }

    // 랜덤값 테스트용
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    public void move(int num) {
        if (num >= FORWARD_NUM) {
            position.move();
        }
    }

}
