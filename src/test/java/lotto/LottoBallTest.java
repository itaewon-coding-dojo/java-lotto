package lotto;

import lotto.domain.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("with invalid bonusBall")
    void invalidBonusBall(int number) {
        assertThatThrownBy(() -> {
            LottoBall lottoBall = LottoBall.newBall(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isElementOf() {
        LottoBall lottoBall = LottoBall.newBall(2);
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        assertThat(lottoBall.isElementOf(numbers)).isTrue();
    }

    @Test
    void beElementOf() {
        LottoBall lottoBall = LottoBall.newBall(3);
        List<Integer> numbers = new ArrayList<>(List.of(1, 2));

        lottoBall.beElementOf(numbers);

        assertThat(numbers).contains(3);
    }
}
