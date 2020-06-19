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
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoMachine.makeLottoTicket(numbers);

        LottoTicket firstTicket = lottoMachine.getLottoTickets().get(0);

        assertThat(firstTicket.getLottoNumbers()).isEqualTo(numbers);
    }
}
