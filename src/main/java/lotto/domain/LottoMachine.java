package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<LottoTicket> lottoTickets;

    public LottoMachine() {
        lottoTickets = new ArrayList<>();
    }

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
            this.makeTicket(List.of(1, 2, 3, 4, 5, 6));
        }
    }
}
