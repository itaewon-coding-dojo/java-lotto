package calculator.model;

import java.util.Arrays;

public class Calculator {
    private final int result;

    public Calculator(int[] numbers) {
        int minusCount = Arrays.stream(numbers).filter(v -> v < 0).toArray().length;
        if (minusCount > 0) {
            throw new RuntimeException();
        }

        this.result = Arrays.stream(numbers).reduce(Integer::sum).orElse(0);
    }

    public static Calculator newCalculator(int[] numbers) {
        return new Calculator(numbers);
    }

    public int executeAddition() {
        return this.result;
    }
}
