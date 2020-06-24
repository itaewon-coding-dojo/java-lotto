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
                LottoBall.newBall(1),
                LottoBall.newBall(2),
                LottoBall.newBall(3),
                LottoBall.newBall(4),
                LottoBall.newBall(5),
                LottoBall.newBall(6),
                LottoBall.newBall(7)
        ));

        LottoTicket lottoTicket = LottoTicket.newTicket(numbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void countMatchedNumber() {
        List<LottoBall> numbers = new ArrayList<>(List.of(
                LottoBall.newBall(1),
                LottoBall.newBall(2),
                LottoBall.newBall(3),
                LottoBall.newBall(4),
                LottoBall.newBall(5),
                LottoBall.newBall(6),
                LottoBall.newBall(7)
        ));

        LottoTicket lottoTicket = LottoTicket.newTicket(numbers);
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 14, 15, 16, 17));

        assertThat(lottoTicket.countMatchedNumber(winningNumbers)).isEqualTo(3);
    }
}
