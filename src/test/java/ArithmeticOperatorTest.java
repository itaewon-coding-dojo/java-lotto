import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticOperatorTest {
    private ArithmeticOperator arithmeticOperator;
    @BeforeEach
    void setUp() {
        arithmeticOperator = new ArithmeticOperator();
    }

    @DisplayName("더하기")
    @Test
    public void getSum() {
        assertThat(arithmeticOperator.sum(new String[] {"1","2","3"})).isEqualTo(6);
    }
}
