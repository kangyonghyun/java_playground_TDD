package car.domain;

import org.apache.commons.lang3.StringUtils;

public class CarName {

    private final String name;

    public CarName(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("값이 존재해야 합니다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자를 초과해서는 안됩니다");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
