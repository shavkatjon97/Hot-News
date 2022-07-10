package shavkatjon.hotnews.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Chanel_GroupStatus {

    ACTIVE_AND_PUBLIC(0),

    ACTIVE_AND_PRIVATE(1),

    INACTIVE_AND_PUBLIC(2),

    INACTIVE_AND_PRIVATE(3),

    BLOCKED_AND_PRIVATE(4),

    BLOCKED_AND_PUBLIC(5);

    int state = 0;

    public static Chanel_GroupStatus getByState(int state) {
        return Stream.of(Chanel_GroupStatus.values())
                .filter(value -> value.getState() == state)
                .findFirst().orElse(null);
    }
}
