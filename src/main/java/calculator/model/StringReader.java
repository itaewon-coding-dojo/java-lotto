package calculator.model;

import java.util.Arrays;

public class StringReader {

    public int[] read(String str) {
        String[] arr = str.split("[:,]");
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }
}
