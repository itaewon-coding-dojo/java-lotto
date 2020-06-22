package lotto.view;

import java.util.Scanner;

public class Input {
    public static int getUserInputMoney() {
        System.out.println("로또 구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        int money = scanner.nextInt();
        System.out.printf("%d개를 구매하셨습니다.\n", money / 1000);

        return money;
    }

    public static String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static int getBonusBallNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
