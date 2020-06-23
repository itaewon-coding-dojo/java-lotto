package StringAddCalculator.controller;

import StringAddCalculator.domain.Computation;
import StringAddCalculator.view.InputView;


public class StringAddCalculator {
    final static private Computation computation = new Computation();
    public static void main(String[] args){
        InputView inputView = new InputView();
        computation.getNumber(inputView.askAddNumber());
    }
}
