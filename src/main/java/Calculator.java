public class Calculator {

    public static int getSum(String[] inputs) {
        if(Validator.checkIfEmpty(inputs) == false){
            return 0;
        }
        return ArithmeticOperator.sum(inputs);
    }
}
