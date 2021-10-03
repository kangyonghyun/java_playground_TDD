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

    public Position move() {
        return new Position(position + 1);
    }

    public boolean lessThan(Position maxPosition) {
        return maxPosition.moreThan(position);
    }

    private boolean moreThan(int position) {
        return this.position > position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
