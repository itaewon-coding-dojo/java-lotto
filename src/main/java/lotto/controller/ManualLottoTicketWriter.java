package lotto.controller;

import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTicketWriter {

    public ManualLottoTicketWriter() {}

    public static ManualLottoTicketWriter newWriter() {
        return new ManualLottoTicketWriter();
    }

    public List<LottoTicket> write(int manualLottoCount) {
        ArrayList<LottoTicket> manualTickets = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i += 1) {
            String numberString = Input.getManualLottoNumber();
            LottoTicket ticket = convertToLottoTickets(numberString);

            manualTickets.add(ticket);
        }

        return manualTickets;
    }

    private LottoTicket convertToLottoTickets(String numberString) {
        int[] numbers = Arrays.stream(numberString.split(",")).mapToInt(Integer::parseInt).toArray();
        List<LottoBall> lottoNumbers = Arrays.stream(numbers).mapToObj(LottoBall::newBall).collect(Collectors.toList());

        return LottoTicket.newTicket(lottoNumbers);
    }
}
