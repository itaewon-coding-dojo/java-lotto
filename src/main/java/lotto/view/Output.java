package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class Output {
    public static void showLottoTickets(List<LottoTicket> tickets) {
        System.out.println("");
        tickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
    }
}
