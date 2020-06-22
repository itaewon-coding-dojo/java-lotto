package lotto;

import lotto.domain.CheckCounter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckCounterTest {
    @Test
    void put() {
        CheckCounter checkCounter = new CheckCounter();

        checkCounter.setInitial(1);

        assertThat(checkCounter.get(1)).isEqualTo(1);
    }

    @Test
    void has() {
        CheckCounter checkCounter = new CheckCounter();

        checkCounter.setInitial(1);

        assertThat(checkCounter.has(1)).isTrue();
        assertThat(checkCounter.has(2)).isFalse();
    }

    @Test
    void countUp() {
        CheckCounter checkCounter = new CheckCounter();

        checkCounter.setInitial(1);
        checkCounter.countUp(1);

        assertThat(checkCounter.get(1)).isEqualTo(2);
    }

    @Test
    void getTotalWinningMoney() {
        CheckCounter checkCounter = new CheckCounter();

        checkCounter.setInitial(3);
        checkCounter.setInitial(4);

        assertThat(checkCounter.getTotalWinningMoney()).isEqualTo(55_000);
    }
}
