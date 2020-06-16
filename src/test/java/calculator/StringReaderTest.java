package calculator;

import calculator.model.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringReaderTest {

    StringReader stringReader;

    @BeforeEach
    void init() {
        stringReader = new StringReader();
    }

    @Test
    @DisplayName("with multiple numbers parameter")
    public void multipleNumbers() {
        assertThat(stringReader.read("1,2,3,4")).isEqualTo(new int[] { 1, 2, 3, 4 });
    }

    @Test
    @DisplayName("with only one number parameter")
    public void onlyOneNumber() {
        assertThat(stringReader.read("5")).isEqualTo(new int[] { 5 });
    }

    @Test
    @DisplayName("with custom separator")
    public void withSeparator() {
        assertThat(stringReader.read("//;\\n1:2;3,4")).isEqualTo(new int[] { 1, 2, 3, 4 });
    }
}
