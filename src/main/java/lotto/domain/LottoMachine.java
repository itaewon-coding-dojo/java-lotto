package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoMachine() {}

    public static LottoMachine newMachine() {
        return new LottoMachine();
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTickets;
    }

    public void makeTicket(List<LottoBall> numbers) {
        LottoTicket newTicket = LottoTicket.newTicket(numbers);
        this.lottoTickets.add(newTicket);
    }

    public void makeTicketsWithMoney(Money money) {
        for (int i = 0; i < money.get() / 1000; i += 1) {
            List<LottoBall> randomNumbers = RandomGenerator.newGenerator().getNumbers();
            this.makeTicket(randomNumbers);
        }
    }
}
