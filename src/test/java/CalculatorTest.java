import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("더하기")
    @Test
    public void getSum() {
        assertThat(calculator.getSum(new String[] {"1","2","3"})).isEqualTo(6);
        assertThat(calculator.getSum(new String[] {""})).isEqualTo(0);
    }
}
