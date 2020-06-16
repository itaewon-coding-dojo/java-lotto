package calculator.controller;

import calculator.model.Calculator;
import calculator.model.StringReader;
import calculator.view.Input;
import calculator.view.Result;

public class StringCalculatorApp {
    public static void main(String[] args) {
        Result.showStartMessage();
        String userInput = Input.getUserInput();

        StringReader stringReader = new StringReader();
        int[] arr = stringReader.read(userInput);

        Calculator calculator = new Calculator(arr);
        Result.showResult(calculator.executeAddition());
    }
}
