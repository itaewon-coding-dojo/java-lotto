package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {

    private final List<Integer> numbers;

    public RandomGenerator() {
        this.numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i += 1) {
            numbers.add(i);
        }
    }

    public static RandomGenerator newGenerator() {
        return new RandomGenerator();
    }

    public List<Integer> getNumbers() {
        Collections.shuffle(numbers);
        List<Integer> sevenNumbers = numbers.subList(0, 7);
        Collections.sort(sevenNumbers);

        return sevenNumbers;
    }
}
