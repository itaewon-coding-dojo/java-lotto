package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("with valid money")
    void validMoney() {
        Money money = Money.newMoney(14_000);

        assertThat(money.get()).isEqualTo(14_000);
    }

    @Test
    @DisplayName("with invalid money")
    void invalidMoney() {
        assertThatThrownBy(() -> {
            Money money = Money.newMoney(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
