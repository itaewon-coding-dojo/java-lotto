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

    public int countMatchedNumber(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : winningNumbers) {
            count = plusCount(this.lottoNumbers, count, number);
        }

        return count;
    }

    private int plusCount(List<LottoBall> ticketNumbers, int count, Integer number) {
        for (LottoBall ball : ticketNumbers) {
            if (ball.isSameWith(number)) {
                count += 1;
            }
        }

        return count;
    }

    public boolean isContaining(LottoBall ball) {
        return this.lottoNumbers.contains(ball);
    }
}