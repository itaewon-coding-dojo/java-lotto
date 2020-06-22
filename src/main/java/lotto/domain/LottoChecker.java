package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    private final CheckCounter checkCounter = new CheckCounter();
    private final List<Integer> winningNumbers;

    public LottoChecker(String winnings) {
        this.winningNumbers = convertToList(winnings);
    }

    public static LottoChecker newChecker(String winnings) {
        return new LottoChecker(winnings);
    }

    public int countMatchedNumber(LottoTicket ticket) {
        List<Integer> ticketNumbers = ticket.getLottoNumbers();

        int count = 0;
        for (Integer number : this.winningNumbers) {
            count = plusCount(ticketNumbers, count, number);
        }

        return count;
    }

    private int plusCount(List<Integer> ticketNumbers, int count, Integer number) {
        if (ticketNumbers.contains(number)) {
            count += 1;
        }

        return count;
    }

    public CheckCounter checkAllTickets(LottoMachine lottoMachine) {
        List<LottoTicket> tickets = lottoMachine.getTickets();
        for (LottoTicket ticket : tickets) {
            addToCheckCounter(this.countMatchedNumber(ticket));
        }

        return this.checkCounter;
    }

    private void addToCheckCounter(int matchCount) {
        if (this.checkCounter.has(matchCount)) {
            this.checkCounter.countUp(matchCount);
            return;
        }

        this.checkCounter.setInitial(matchCount);
    }

    private List<Integer> convertToList(String string) {
        return Arrays.asList(
                Arrays.stream(string.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new)
        );
    }
}
