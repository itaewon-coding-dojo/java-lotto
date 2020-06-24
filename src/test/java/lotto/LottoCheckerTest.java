package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    void checkTicket() {
        String winningNumbers = "1,2,3,4,5,6";
        LottoBall lottoBall = LottoBall.newLottoBall(7);
        LottoChecker lottoChecker = LottoChecker.newChecker(winningNumbers, lottoBall);
        LottoTicket ticket = LottoTicket.newLotto(List.of(
                LottoBall.newLottoBall(1),
                LottoBall.newLottoBall(2),
                LottoBall.newLottoBall(3),
                LottoBall.newLottoBall(4),
                LottoBall.newLottoBall(11),
                LottoBall.newLottoBall(12)
        ));

        int count = lottoChecker.countMatchedNumber(ticket);

        assertThat(count).isEqualTo(4);
    }

    LottoMachine lottoMachine;
    LottoChecker lottoChecker;

    @BeforeEach
    void init() {
        lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicket(List.of(
                LottoBall.newLottoBall(1),
                LottoBall.newLottoBall(2),
                LottoBall.newLottoBall(3),
                LottoBall.newLottoBall(11),
                LottoBall.newLottoBall(12),
                LottoBall.newLottoBall(13),
                LottoBall.newLottoBall(14)
        ));
        lottoMachine.makeTicket(List.of(
                LottoBall.newLottoBall(1),
                LottoBall.newLottoBall(2),
                LottoBall.newLottoBall(11),
                LottoBall.newLottoBall(12),
                LottoBall.newLottoBall(13),
                LottoBall.newLottoBall(14),
                LottoBall.newLottoBall(15)
        ));
        lottoMachine.makeTicket(List.of(
                LottoBall.newLottoBall(11),
                LottoBall.newLottoBall(12),
                LottoBall.newLottoBall(13),
                LottoBall.newLottoBall(14),
                LottoBall.newLottoBall(15),
                LottoBall.newLottoBall(16),
                LottoBall.newLottoBall(17)
        ));
        lottoMachine.makeTicket(List.of(
                LottoBall.newLottoBall(1),
                LottoBall.newLottoBall(2),
                LottoBall.newLottoBall(3),
                LottoBall.newLottoBall(4),
                LottoBall.newLottoBall(5),
                LottoBall.newLottoBall(7),
                LottoBall.newLottoBall(16)
        ));

        String winningNumbers = "1,2,3,4,5,6";
        LottoBall lottoBall = LottoBall.newLottoBall(7);
        lottoChecker = LottoChecker.newChecker(winningNumbers, lottoBall);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0",
            "2,1",
            "3,1",
            "4,0",
            "5,0",
            "6,0",
            "7,1",
    })
    void checkAllTickets(Integer key, Integer value) {
        CheckCounter checkCounter = lottoChecker.checkAllTickets(lottoMachine);

        assertThat(checkCounter.get(key)).isEqualTo(value);
    }
}
