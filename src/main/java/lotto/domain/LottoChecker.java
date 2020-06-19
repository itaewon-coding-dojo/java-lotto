package lotto.domain;

import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoChecker {

    private final Map<Integer, Integer> checkCounter;
    private final List<Integer> winningNumbers;

    public LottoChecker(String winnings) {
        this.checkCounter = new TreeMap<>();
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

    public Map<Integer, Integer> checkAllTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            addCheckCounter(this.checkTicket(ticket));
        }

        addTotalWinningMoney();

        return this.checkCounter;
    }

    private void addCheckCounter(int count) {
        if (this.checkCounter.containsKey(count)) {
            this.checkCounter.put(count, this.checkCounter.get(count) + 1);

            return;
        }

        this.checkCounter.put(count, 1);
    }

    private void addTotalWinningMoney() {
        int totalWinningMoney = (5_000 * this.checkCounter.getOrDefault(3, 0))
                + (50_000 * this.checkCounter.getOrDefault(4, 0))
                + (1_500_000 * this.checkCounter.getOrDefault(5, 0))
                + (2_000_000_000 * this.checkCounter.getOrDefault(6, 0));

        this.checkCounter.put(7, totalWinningMoney);
    }
}
