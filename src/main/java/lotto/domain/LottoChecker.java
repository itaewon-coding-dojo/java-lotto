package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    private final CheckCounter checkCounter = new CheckCounter();
    private final List<Integer> winningNumbers;

    public LottoChecker(String winnings) {
        this.winningNumbers =
                Arrays.asList(
                    Arrays.stream(winnings.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new)
                );
    }

    public static LottoChecker newChecker(String winnings) {
        return new LottoChecker(winnings);
    }

    public int checkTicket(LottoTicket ticket) {
        List<Integer> ticketNumbers = ticket.getLottoNumbers();

        int count = 0;
        for (Integer number : winningNumbers) {
            count = getCount(ticketNumbers, count, number);
        }

        return count;
    }

    private int getCount(List<Integer> ticketNumbers, int count, Integer number) {
        if (ticketNumbers.contains(number)) {
            count += 1;
        }

        return count;
    }

    public CheckCounter checkAllTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            addCheckCounter(this.checkTicket(ticket));
        }

        return this.checkCounter;
    }

    private void addCheckCounter(int matchCount) {
        if (this.checkCounter.has(matchCount)) {
            this.checkCounter.countUp(matchCount);
            return;
        }

        this.checkCounter.setInitial(matchCount);
    }
}
