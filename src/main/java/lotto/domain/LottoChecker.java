package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoChecker {
    public static LottoChecker newChecker() {
        return new LottoChecker();
    }

    public List<Integer> convertToLottoNumber(String input) {
        return Arrays.asList(
                Arrays.stream(input.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new)
        );
    }
}
