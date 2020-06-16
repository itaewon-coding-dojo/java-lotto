package calculator.controller;

import calculator.model.Calculator;
import calculator.model.StringReader;
import calculator.view.Input;

public class StringCalculatorApp {
    public static void main(String[] args) {
        System.out.println("수식을 입력해주세요");
        String userInput = Input.getUserInput();

        StringReader stringReader = new StringReader();
        int[] arr = stringReader.read(userInput);

        Calculator calculator = new Calculator(arr);
        System.out.println(calculator.executeAddition());
    }
}
