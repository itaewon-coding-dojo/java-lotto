package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        int money = Input.getUserInputMoney();

        LottoMachine lottoMachine = LottoMachine.newMachine();
        lottoMachine.makeTicketsWithMoney(money);

        Output.showLottoTickets(lottoMachine.getTickets());
    }
}
