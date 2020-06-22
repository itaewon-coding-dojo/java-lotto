package lotto.view;

import lotto.domain.CheckCounter;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;

import java.util.List;

public class Output {
    public static void showLottoTickets(LottoMachine lottoMachine) {
        System.out.println("");
        List<LottoTicket> tickets = lottoMachine.getTickets();
        tickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
    }

    public enum ShowWinner {
        FIRST {
            @Override
            public void showCount(CheckCounter counter) {
                System.out.printf("모두 일치 (2,000,000,000원) - %d개\n", counter.get(6));
            }
        },
        SECOND {
            @Override
            public void showCount(CheckCounter counter) {
                System.out.printf("5개 일치, 보너스 볼 일치(30_000_000원) - %d개\n", counter.get(7));
            }
        },
        THIRD {
            @Override
            public void showCount(CheckCounter counter) {
                System.out.printf("5개 일치 (1,500,000원) - %d개\n", counter.get(5));
            }
        },
        FOURTH {
            @Override
            public void showCount(CheckCounter counter) {
                System.out.printf("4개 일치 (50,000원) - %d개\n", counter.get(4));
            }
        },
        FIFTH {
            @Override
            public void showCount(CheckCounter counter) {
                System.out.printf("3개 일치 (5,000원) - %d개\n", counter.get(3));
            }
        };

        abstract public void showCount(CheckCounter counter);
    }

    public static void showResult(CheckCounter counter, int money) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("----------------------------");
        ShowWinner.FIFTH.showCount(counter);
        ShowWinner.FOURTH.showCount(counter);
        ShowWinner.THIRD.showCount(counter);
        ShowWinner.SECOND.showCount(counter);
        ShowWinner.FIRST.showCount(counter);
        System.out.println("");

        System.out.printf("총 수익률은 %.2f입니다.\n\n\n", (double) counter.getTotalWinningMoney() / money);
    }
}
