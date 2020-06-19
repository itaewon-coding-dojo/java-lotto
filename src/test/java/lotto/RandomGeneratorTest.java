package lotto;

import lotto.domain.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    void getNumbers() {
        RandomGenerator randomGenerator = RandomGenerator.newGenerator();

        List<Integer> numbers = randomGenerator.getNumbers();

        assertThat(numbers).hasSize(6);
    }
}
