package lotto.view;

import lotto.domain.CheckCounter;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;

public class Output {
    public static void showLottoTickets(List<LottoTicket> tickets) {
        System.out.println("");
        tickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
    }

    public static void showResult(CheckCounter counter, int money) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("----------------------------");
        System.out.printf("3개 일치 (5,000원) - %d개\n", counter.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개\n", counter.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", counter.get(5));
        System.out.printf("모두 일치 (2,000,000,000원) - %d개\n", counter.get(6));
        System.out.println("");

        System.out.printf("총 수익률은 %.2f입니다.\n\n\n", (double) counter.getTotalWinningMoney() / money);
    }
}
