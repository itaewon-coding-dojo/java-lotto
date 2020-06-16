import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciferer {

    public static String[] extractElements (String input) {
        Pattern pattern = Pattern.compile("(//([^\\d])\\\\n)(\\p{Alnum}+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String customSeparator = matcher.group(2);
            String otherString = matcher.group(3);
            return otherString.split(customSeparator);
        }

        return input.split(",|;");
    }
}
