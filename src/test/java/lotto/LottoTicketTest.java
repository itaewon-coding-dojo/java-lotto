package lotto;

import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void getLottoNumbers() {
        List<LottoBall> numbers = new ArrayList<>(List.of(
                LottoBall.newLottoBall(1),
                LottoBall.newLottoBall(2),
                LottoBall.newLottoBall(3),
                LottoBall.newLottoBall(4),
                LottoBall.newLottoBall(5),
                LottoBall.newLottoBall(6),
                LottoBall.newLottoBall(7)
        ));

        LottoTicket lottoTicket = LottoTicket.newLotto(numbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)));
    }
}
