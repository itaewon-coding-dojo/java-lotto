package calculator.model;

import java.util.Arrays;

public class StringReader {
    public int[] read(String str) {
        String[] arr = str.split("n");

        return arr.length == 1
                ? withNoCustomSeparator(arr[0])
                : withCustomSeparator(arr[0], arr[1]);
    }

    private int[] withNoCustomSeparator(String str) {
        String[] numbers = str.split("[:,]");

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }

    private int[] withCustomSeparator(String separatorPart, String numberPart) {
        String customSeparator = Character.toString(separatorPart.charAt(2));
        String regex = "[:," + customSeparator + "]";
        String[] numbers = numberPart.split(regex);

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }
}
