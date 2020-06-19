package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    private final List<Integer> winningNumbers;

    public LottoChecker(String winnings) {
        this.winningNumbers =
                Arrays.asList(
                    Arrays.stream(winnings.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new)
                );
    }

    public static LottoChecker newChecker(String winnings) {
        return new LottoChecker(winnings);
    }

}
