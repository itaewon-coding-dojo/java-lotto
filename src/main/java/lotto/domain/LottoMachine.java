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

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public void makeLottoTicket(List<Integer> numbers) {
        LottoTicket newTicket = LottoTicket.newLotto(numbers);
        lottoTickets.add(newTicket);
    }
}
