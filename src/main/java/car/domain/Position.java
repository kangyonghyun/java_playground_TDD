package car.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("위치값은 음수를 가질 수 없다");
        }
        this.position = num;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public boolean lessThan(Position maxPosition) {
        return position < maxPosition.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
