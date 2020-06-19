package lotto;

import lotto.domain.LottoChecker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    void convertToLottoNumber() {
        LottoChecker lottoChecker = LottoChecker.newChecker();
        String input = "1,2,3,4,5,6";

        List<Integer> lottoNumbers = lottoChecker.convertToLottoNumber(input);

        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
