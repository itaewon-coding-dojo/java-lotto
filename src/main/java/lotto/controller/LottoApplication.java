package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Money money;
        try {
            money = Money.newMoney(Input.getUserInputMoney());
        } catch (IllegalArgumentException e) {
            Output.showErrorMessage(e);
            money = Money.newMoney(1000);
        }

        ManualLottoTicketWriter manualWriter = ManualLottoTicketWriter.newWriter();
        List<LottoTicket> manualTickets = manualWriter.write(Input.getUserInputManualCount());

        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTickets(money, manualTickets);

        Output.showLottoTickets(lottoMachine);

        String winningNumbers = Input.getWinningNumbers();

        LottoBall lottoBallNumber;
        try {
            lottoBallNumber = LottoBall.newBall(Input.getBonusBallNumber());
        } catch (IllegalArgumentException e) {
            Output.showErrorMessage(e);
            lottoBallNumber = LottoBall.newBall(45);
        }

        LottoChecker lottoChecker = LottoChecker.newChecker(winningNumbers, lottoBallNumber);
        CheckCounter counter = lottoChecker.checkAllTickets(lottoMachine);

        Output.showResult(counter, money);
    }
}
