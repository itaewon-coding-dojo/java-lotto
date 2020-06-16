import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecifererTest {
    private Deciferer deciferer;
    @BeforeEach
    void setUp() {
        deciferer = new Deciferer();
    }

    @Test
    public void extractElements() {
        assertThat(deciferer.extractElements("3;3;3")).isEqualTo(new String[] {"3","3","3"});
        assertThat(deciferer.extractElements("3,3;3")).isEqualTo(new String[] {"3","3","3"});
        assertThat(deciferer.extractElements("//a\\n3a3a3")).isEqualTo(new String[] {"3","3","3"});
        assertThat(deciferer.extractElements("3,3;3")).isEqualTo(new String[] {"3","3","3"});
    }
}
