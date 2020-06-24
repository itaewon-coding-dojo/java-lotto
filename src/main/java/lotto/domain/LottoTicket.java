package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<LottoBall> lottoNumbers;

    public LottoTicket(List<LottoBall> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket newTicket(List<LottoBall> numbers) {
        return new LottoTicket(numbers);
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
            count = addCount(count, number, ball);
        }

        return count;
    }

    private int addCount(int count, Integer number, LottoBall ball) {
        if (ball.isSameWith(number)) {
            count += 1;
        }

        return count;
    }

    public boolean isContaining(LottoBall ball) {
        return this.lottoNumbers.contains(ball);
    }

    @Override
    public String toString() {
        String result = "";
        for (LottoBall ball : this.lottoNumbers) {
            result += ball.toString() + " ";
        }

        return "[ " + result + "]";
    }
}