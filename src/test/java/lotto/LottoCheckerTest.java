package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    LottoMachine lottoMachine;
    LottoChecker lottoChecker;

    @BeforeEach
    void init() {
        lottoMachine = LottoMachine.newMachine();

        lottoMachine.makeTicket(List.of(
                LottoBall.newBall(1),
                LottoBall.newBall(2),
                LottoBall.newBall(3),
                LottoBall.newBall(11),
                LottoBall.newBall(12),
                LottoBall.newBall(13),
                LottoBall.newBall(14)
        ));
        lottoMachine.makeTicket(List.of(
                LottoBall.newBall(1),
                LottoBall.newBall(2),
                LottoBall.newBall(11),
                LottoBall.newBall(12),
                LottoBall.newBall(13),
                LottoBall.newBall(14),
                LottoBall.newBall(15)
        ));
        lottoMachine.makeTicket(List.of(
                LottoBall.newBall(11),
                LottoBall.newBall(12),
                LottoBall.newBall(13),
                LottoBall.newBall(14),
                LottoBall.newBall(15),
                LottoBall.newBall(16),
                LottoBall.newBall(17)
        ));
        lottoMachine.makeTicket(List.of(
                LottoBall.newBall(1),
                LottoBall.newBall(2),
                LottoBall.newBall(3),
                LottoBall.newBall(4),
                LottoBall.newBall(5),
                LottoBall.newBall(7),
                LottoBall.newBall(16)
        ));

        String winningNumbers = "1,2,3,4,5,6";
        LottoBall lottoBall = LottoBall.newBall(7);
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
