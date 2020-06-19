package lotto.controller;

import lotto.domain.LottoChecker;
import lotto.domain.LottoMachine;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        int money = Input.getUserInputMoney();

        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicketsWithMoney(money);

        Output.showLottoTickets(lottoMachine.getTickets());

        String winningNumbers = Input.getWinningNumbers();
        LottoChecker lottoChecker = LottoChecker.newChecker(winningNumbers);
        Map<Integer, Integer> counter = lottoChecker.checkAllTickets(lottoMachine.getTickets());

        Output.showResult(counter, money);
    }
}
