package calculator.model;

import java.util.Arrays;

public class StringReader {

    public int[] read(String str) {
        String[] arr = str.split("n");

        if (arr.length == 1) {
            String[] numbers = arr[0].split("[:,]");

            return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        }

        String customSeparator = Character.toString(arr[0].charAt(2));
        String regex = "[:," + customSeparator + "]";
        String[] numbers = arr[1].split(regex);

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }
}
