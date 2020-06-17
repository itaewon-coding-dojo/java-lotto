import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    private Validator validator;
    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("더하기")
    @Test
    public void getSum() {
        assertThat(validator.checkIfEmpty(new String[] {"1","2","3"})).isEqualTo(true);
        assertThat(validator.checkIfEmpty(new String[] {""})).isEqualTo(false);
    }
}
