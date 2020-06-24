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
        LottoMachine lottoMachine = LottoMachine.newMachine();
        List<LottoBall> numbers1 = new ArrayList<>(List.of(
                LottoBall.newLottoBall(1),
                LottoBall.newLottoBall(3),
                LottoBall.newLottoBall(5),
                LottoBall.newLottoBall(7),
                LottoBall.newLottoBall(9),
                LottoBall.newLottoBall(11),
                LottoBall.newLottoBall(13)
        ));
        List<LottoBall> numbers2 = new ArrayList<>(List.of(
                LottoBall.newLottoBall(2),
                LottoBall.newLottoBall(4),
                LottoBall.newLottoBall(6),
                LottoBall.newLottoBall(8),
                LottoBall.newLottoBall(10),
                LottoBall.newLottoBall(12),
                LottoBall.newLottoBall(14)
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
        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicketsWithMoney(money);

        assertThat(lottoMachine.getTickets()).hasSize(14);
    }
}
