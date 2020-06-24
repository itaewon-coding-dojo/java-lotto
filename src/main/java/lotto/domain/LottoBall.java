package lotto.domain;

public class LottoBall implements Comparable{

    private final int ballNumber;

    public LottoBall(int number) {
        this.validate(number);
        this.ballNumber = number;
    }

    public static LottoBall newBall(int number) {
        return new LottoBall(number);
    }

    public int get() {
        return this.ballNumber;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 볼로 가능한 숫자는 1 ~ 45 입니다.");
        }
    }

    @Override
    public int compareTo(Object o) {
        LottoBall next = (LottoBall) o;
        return this.ballNumber - next.ballNumber;
    }
}
