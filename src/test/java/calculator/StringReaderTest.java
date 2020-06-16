package calculator;

import calculator.model.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringReaderTest {

    @Test
    @DisplayName("with multiple numbers parameter")
    public void multipleNumbers() {
        StringReader stringReader = new StringReader();
        assertThat(stringReader.read("1,2,3,4")).isEqualTo(new int[] { 1, 2, 3, 4 });
    }

    @Test
    @DisplayName("with only one number parameter")
    public void onlyOneNumber() {
        StringReader stringReader = new StringReader();
        assertThat(stringReader.read("5")).isEqualTo(new int[] { 5 });
    }
}
