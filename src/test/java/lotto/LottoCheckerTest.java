package lotto;

import lotto.domain.LottoChecker;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    void checkTicket() {
        String winningNumbers = "1,2,3,4,5,6";
        LottoChecker lottoChecker = LottoChecker.newChecker(winningNumbers);
        LottoTicket ticket = LottoTicket.newLotto(List.of(1, 2, 3, 4, 11, 12));

        int count = lottoChecker.checkTicket(ticket);

        assertThat(count).isEqualTo(4);
    }
}
