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
        Calculator calculator = new Calculator(new int[] { 0 });
        assertThat(calculator.executeAddition()).isEqualTo(0);
    }

    @Test
    @DisplayName("with only one number parameter")
    public void oneParameter() {
        Calculator calculator = new Calculator(new int[] { 3 });
        assertThat(calculator.executeAddition()).isEqualTo(3);
    }

    @Test
    @DisplayName("with array parameter")
    public void arrayParameter() {
        Calculator calculator = new Calculator(new int[] { 1, 2, 3, 4 });
        assertThat(calculator.executeAddition()).isEqualTo(10);
    }

    @Test
    @DisplayName("with minus parameter")
    public void minusParameter() {
        assertThatThrownBy(() -> new Calculator(new int[] { -5 })).isInstanceOf(RuntimeException.class);
    }
}
