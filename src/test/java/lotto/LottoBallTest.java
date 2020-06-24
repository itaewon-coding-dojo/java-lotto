package lotto;

import lotto.domain.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallTest {
    @Test
    @DisplayName("with valid bonusBall")
    void validBonusBall() {
        LottoBall lottoBall = LottoBall.newBall(21);

        assertThat(lottoBall.get()).isEqualTo(21);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("with invalid bonusBall")
    void invalidBonusBall(int number) {
        assertThatThrownBy(() -> {
            LottoBall lottoBall = LottoBall.newBall(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
