package StringAddCalculator.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String askAddNumber() {
        System.out.println("입력해주세요");
        String AddText = scanner.nextLine();
        return AddText;
    }

}
