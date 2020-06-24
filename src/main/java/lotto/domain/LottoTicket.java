package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<LottoBall> lottoNumbers;

    public LottoTicket(List<LottoBall> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket newTicket(List<LottoBall> numbers) {
        return new LottoTicket(numbers);
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (LottoBall ball : this.lottoNumbers) {
            ball.beElementOf(numbers);
        }

        return numbers;
    }
}