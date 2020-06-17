package calculator.view;

public class Result {

    public static void showStartMessage() {
        System.out.println("숫자들을 입력해주세요");
    }

    public static void showResult(int result) {
        System.out.printf("합계: %d", result);
    }
}
