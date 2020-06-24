package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        this.validate(money);
        this.money = money;
    }

    public static Money newMoney(int money) {
        return new Money(money);
    }

    public int get() {
        return this.money;
    }

    private void validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("1000원 이상 구매하셔야 합니다.");
        }
    }
}
