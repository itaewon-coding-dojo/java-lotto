package lotto.domain;

import lotto.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void makeTickets(Money money, int manualLottoCount) {
        int autoLottoCount = (money.get() / 1000) - manualLottoCount;

        makeAutoLottos(autoLottoCount);
        makeManualLottos(manualLottoCount);
    }

    private void makeAutoLottos(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i += 1) {
            List<LottoBall> randomNumbers = RandomGenerator.newGenerator().getNumbers();
            this.makeTicket(randomNumbers);
        }
    }

    private void makeManualLottos(int manualLottoCount) {
        for (int i = 0; i < manualLottoCount; i += 1) {
            String numbers = Input.getManualLottoNumber();
            List<LottoBall> lottoNumbers = convertToList(numbers);
            this.makeTicket(lottoNumbers);
        }
    }

    private List<LottoBall> convertToList(String string) {
        return Arrays.asList(
                Arrays.stream(string.split(","))
                        .map(Integer::parseInt)
                        .map(LottoBall::newBall)
                        .toArray(LottoBall[]::new)
        );
    }
}
