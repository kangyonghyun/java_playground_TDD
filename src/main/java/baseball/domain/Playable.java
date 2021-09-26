package baseball.domain;

import java.util.List;

public interface Playable {

    public PlayResult play(List<Integer> balls);
}
