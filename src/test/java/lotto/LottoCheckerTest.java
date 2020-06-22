package lotto;

import lotto.domain.CheckCounter;
import lotto.domain.LottoChecker;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

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

    LottoMachine lottoMachine;
    LottoChecker lottoChecker;

    @BeforeEach
    void init() {
        lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicket(List.of(1, 2, 3, 11, 12, 13));
        lottoMachine.makeTicket(List.of(1, 2, 11, 12, 13, 14));
        lottoMachine.makeTicket(List.of(11, 12, 13, 14, 15, 16));

        String winningNumbers = "1,2,3,4,5,6";
        lottoChecker = LottoChecker.newChecker(winningNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0",
            "2,1",
            "3,1",
            "4,0",
            "5,0",
            "6,0",
    })
    void checkAllTickets(Integer key, Integer value) {
        CheckCounter checkCounter = lottoChecker.checkAllTickets(lottoMachine);

        assertThat(checkCounter.get(key)).isEqualTo(value);
    }
}
