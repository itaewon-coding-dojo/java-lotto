package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = Money.newMoney(Input.getUserInputMoney());

        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicketsWithMoney(money);

        Output.showLottoTickets(lottoMachine);

        String winningNumbers = Input.getWinningNumbers();
        LottoBall lottoBallNumber = LottoBall.newBall(Input.getBonusBallNumber());

        LottoChecker lottoChecker = LottoChecker.newChecker(winningNumbers, lottoBallNumber);
        CheckCounter counter = lottoChecker.checkAllTickets(lottoMachine);

        Output.showResult(counter, money);
    }
}
