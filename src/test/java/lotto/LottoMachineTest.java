package lotto;

import lotto.domain.LottoBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void makeLottoTicket() {
        LottoMachine lottoMachine = LottoMachine.newMachine(0);
        List<LottoBall> numbers1 = new ArrayList<>(List.of(
                LottoBall.newBall(1),
                LottoBall.newBall(3),
                LottoBall.newBall(5),
                LottoBall.newBall(7),
                LottoBall.newBall(9),
                LottoBall.newBall(11),
                LottoBall.newBall(13)
        ));
        List<LottoBall> numbers2 = new ArrayList<>(List.of(
                LottoBall.newBall(2),
                LottoBall.newBall(4),
                LottoBall.newBall(6),
                LottoBall.newBall(8),
                LottoBall.newBall(10),
                LottoBall.newBall(12),
                LottoBall.newBall(14)
        ));
        lottoMachine.makeTicket(numbers1);
        lottoMachine.makeTicket(numbers2);

        LottoTicket firstTicket = lottoMachine.getTickets().get(0);
        assertThat(firstTicket.getLottoNumbers()).isEqualTo(new ArrayList<>(List.of(1, 3, 5, 7, 9, 11, 13)));

        LottoTicket secondTicket = lottoMachine.getTickets().get(1);
        assertThat(secondTicket.getLottoNumbers()).isEqualTo(new ArrayList<>(List.of(2, 4, 6, 8, 10, 12, 14)));
    }

    @Test
    void makeLottoTicketsWithMoney() {
        Money money = Money.newMoney(14_000);
        LottoMachine lottoMachine = LottoMachine.newMachine(0);
        lottoMachine.makeTicketsWithMoney(money);

        assertThat(lottoMachine.getTickets()).hasSize(14);
    }
}
