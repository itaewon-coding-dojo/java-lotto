package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket newLotto(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
}