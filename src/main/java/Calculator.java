import java.util.stream.Stream;

public class Calculator {
    public static int getSum(String[] inputs) {
        return Stream.of(inputs).mapToInt(x-> Integer.parseInt(x)).reduce((a,b)-> a+b).getAsInt();
    }
}
