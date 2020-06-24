package lotto.domain;

import java.util.List;

public class LottoBall implements Comparable{

    private final int ballNumber;

    public LottoBall(int number) {
        this.validate(number);
        this.ballNumber = number;
    }

    public static LottoBall newBall(int number) {
        return new LottoBall(number);
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 볼로 가능한 숫자는 1 ~ 45 입니다.");
        }
    }

    @Override
    public int compareTo(Object obj) {
        LottoBall next = (LottoBall) obj;
        return this.ballNumber - next.ballNumber;
    }

    @Override
    public boolean equals(Object obj) {
        LottoBall next = (LottoBall) obj;
        return this.ballNumber == next.ballNumber;
    }

    public boolean isElementOf(List<Integer> numbers) {
        return numbers.contains(this.ballNumber);
    }

    public boolean isSameWith(int number) {
        return number == this.ballNumber;
    }

    @Override
    public String toString() {
        return this.ballNumber + "";
    }
}
