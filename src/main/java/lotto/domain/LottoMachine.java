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

    public void makeTickets(Money money, List<LottoTicket> manualTickets) {
        int manualLottoCount = manualTickets.size();
        int autoLottoCount = money.getAutoLottoCount(manualLottoCount);

        makeAutoLottos(autoLottoCount);
        makeManualLottos(manualTickets);
    }

    private void makeAutoLottos(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i += 1) {
            List<LottoBall> randomNumbers = RandomGenerator.newGenerator().getNumbers();
            this.makeTicket(randomNumbers);
        }
    }

    private void makeManualLottos(List<LottoTicket> manualTickets) {
        this.lottoTickets.addAll(manualTickets);
    }
}
