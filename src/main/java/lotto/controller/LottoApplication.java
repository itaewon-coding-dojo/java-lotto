package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        Money money;
        try {
            money = Money.newMoney(Input.getUserInputMoney());
        } catch (IllegalArgumentException e) {
            Output.showErrorMessage(e);
            money = Money.newMoney(1000);
        }

        LottoMachine lottoMachine = LottoMachine.newMachine(Input.getUserInputManualCount());
        lottoMachine.makeTicketsWithMoney(money);

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
