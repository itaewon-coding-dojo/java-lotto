import java.util.stream.Stream;

public class ArithmeticOperator {
    public static int sum(String[] inputs) {
        return Stream.of(inputs).mapToInt(x-> Integer.parseInt(x)).reduce((a, b)-> a+b).getAsInt();
    }
}
