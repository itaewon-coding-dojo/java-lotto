package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void makeLottoTicket() {
        LottoMachine lottoMachine = LottoMachine.newMachine();
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 3, 5, 7, 9, 11));
        List<Integer> numbers2 = new ArrayList<>(List.of(2, 4, 6, 8, 10, 12));
        lottoMachine.makeTicket(numbers1);
        lottoMachine.makeTicket(numbers2);

        LottoTicket firstTicket = lottoMachine.getTickets().get(0);
        assertThat(firstTicket.getLottoNumbers()).isEqualTo(numbers1);

        LottoTicket secondTicket = lottoMachine.getTickets().get(1);
        assertThat(secondTicket.getLottoNumbers()).isEqualTo(numbers2);
    }

    @Test
    void makeLottoTicketsWithMoney() {
        int money = 14_000;
        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicketsWithMoney(money);

        assertThat(lottoMachine.getTickets()).hasSize(14);
    }
}
