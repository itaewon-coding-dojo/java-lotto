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

    public void makeTicket(List<Integer> numbers) {
        LottoTicket newTicket = LottoTicket.newLotto(numbers);
        this.lottoTickets.add(newTicket);
    }

    public void makeTicketsWithMoney(int money) {
        for (int i = 0; i < money / 1000; i += 1) {
            List<Integer> randomNumbers = RandomGenerator.newGenerator().getNumbers();
            this.makeTicket(randomNumbers);
        }
    }
}
