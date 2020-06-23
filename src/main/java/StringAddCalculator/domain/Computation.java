package StringAddCalculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computation {
    public int getNumber(String s) {

        String sum = s;
        if(s == null || s.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(s);
        if(m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            sum = String.valueOf(addNumber(tokens));
            return Integer.parseInt(String.valueOf(sum));
        }

        return addNumber(s.split(",|:"));
    }
    
    static int addNumber(String[] arr) {
        return Arrays.stream(arr).map(item -> Integer.parseInt(item)).reduce(0, (a, b) -> a+b);
    }
}
