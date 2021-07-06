package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void withInvalidMoney() {
        assertThatThrownBy(() -> {
            Money money = Money.newMoney(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAutoLottoCount() {
        Money money = Money.newMoney(14_000);

        int manualLottoCount = 3;

        assertThat(money.getAutoLottoCount(manualLottoCount)).isEqualTo(11);
    }

    @Test
    void getRevenueRate() {
        Money money = Money.newMoney(14_000);

        int totalWinningMoney = 7_000;

        assertThat(money.getRevenueRate(totalWinningMoney)).isEqualTo(0.5);
    }
}
