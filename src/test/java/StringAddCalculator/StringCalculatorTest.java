package StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import StringAddCalculator.controller.StringAddCalculator;
import StringAddCalculator.domain.Computation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private Computation computation;

    @BeforeEach
    void setUp() {
        computation = new Computation();
    }

    @DisplayName("널이나 빈값체크")
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = computation.getNumber(null);
        assertEquals(0, result);

        result = computation.getNumber("");
        assertEquals(0, result);
    }

    @DisplayName("숫자 하나 체크")
    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = computation.getNumber("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분문자 체크")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = computation.getNumber("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표 또는 콜론 구분자")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = computation.getNumber("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("구분자")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = computation.getNumber("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
