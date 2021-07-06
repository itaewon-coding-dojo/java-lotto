package lotto;

import lotto.domain.LottoBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,true",
            "3,true",
            "5,true",
            "7,true",
            "9,true",
            "11,true",
            "13,true",
            "14,false",
            "15,false",
    })
    void makeLottoTicket(int number, boolean bool) {
        LottoMachine lottoMachine = LottoMachine.newMachine();
        List<LottoBall> numbers = new ArrayList<>(List.of(
                LottoBall.newBall(1),
                LottoBall.newBall(3),
                LottoBall.newBall(5),
                LottoBall.newBall(7),
                LottoBall.newBall(9),
                LottoBall.newBall(11),
                LottoBall.newBall(13)
        ));

        lottoMachine.makeTicket(numbers);

        LottoTicket ticket = lottoMachine.getTickets().get(0);
        LottoBall ball = LottoBall.newBall(number);
        assertThat(ticket.isContaining(ball)).isEqualTo(bool);
    }

    @Test
    void makeTickets() {
        Money money = Money.newMoney(14_000);
        LottoMachine lottoMachine = LottoMachine.newMachine();
        List<LottoTicket> empty = new ArrayList<>();
        lottoMachine.makeTickets(money, empty);

        assertThat(lottoMachine.getTickets()).hasSize(14);
    }
}
