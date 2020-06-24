package lotto.domain;

import lotto.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {

    private final List<LottoTicket> lottoTickets = new ArrayList<>();
    private final int manualLottoCount;

    public LottoMachine(int number) {
        this.manualLottoCount = number;
    }

    public static LottoMachine newMachine(int number) {
        return new LottoMachine(number);
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTickets;
    }

    public void makeTicket(List<LottoBall> numbers) {
        LottoTicket newTicket = LottoTicket.newTicket(numbers);
        this.lottoTickets.add(newTicket);
    }

    public void makeTicketsWithMoney(Money money) {
        makeAutoLottos(money);
        makeManualLottos();
    }

    private void makeAutoLottos(Money money) {
        int autoLottoCount = (money.get() / 1000) - this.manualLottoCount;
        for (int i = 0; i < autoLottoCount; i += 1) {
            List<LottoBall> randomNumbers = RandomGenerator.newGenerator().getNumbers();
            this.makeTicket(randomNumbers);
        }
    }

    private void makeManualLottos() {
        for (int i = 0; i < this.manualLottoCount; i += 1) {
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
