package lotto.controller;

import lotto.domain.CheckCounter;
import lotto.domain.LottoChecker;
import lotto.domain.LottoMachine;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        int money = Input.getUserInputMoney();

        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicketsWithMoney(money);

        Output.showLottoTickets(lottoMachine);

        String winningNumbers = Input.getWinningNumbers();
        int bonusBallNumber = Input.getBonusBallNumber();

        LottoChecker lottoChecker = LottoChecker.newChecker(winningNumbers, bonusBallNumber);
        CheckCounter counter = lottoChecker.checkAllTickets(lottoMachine);

        Output.showResult(counter, money);
    }
}
