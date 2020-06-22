package calculator;

import calculator.model.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("with zero parameter")
    public void nullParameter() {
        Calculator calculator = Calculator.newCalculator(new int[] { 0 });

        int answer = calculator.executeAddition();

        assertThat(answer).isEqualTo(0);
    }

    @Test
    @DisplayName("with only one number parameter")
    public void oneParameter() {
        Calculator calculator = Calculator.newCalculator(new int[] { 3 });

        int answer = calculator.executeAddition();

        assertThat(answer).isEqualTo(3);
    }

    @Test
    @DisplayName("with array parameter")
    public void arrayParameter() {
        Calculator calculator = Calculator.newCalculator(new int[] { 1, 2, 3, 4 });

        int answer = calculator.executeAddition();

        assertThat(answer).isEqualTo(10);
    }

    @Test
    @DisplayName("with minus parameter")
    public void minusParameter() {
        assertThatThrownBy(() -> Calculator.newCalculator(new int[] { -5 })).isInstanceOf(RuntimeException.class);
    }
}
