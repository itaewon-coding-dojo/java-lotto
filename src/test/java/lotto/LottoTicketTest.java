package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        LottoTicket lottoTicket = LottoTicket.newLotto(numbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(numbers);
    }
}
