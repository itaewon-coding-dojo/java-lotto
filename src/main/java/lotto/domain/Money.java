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

    private void validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("1000원 이상 구매하셔야 합니다.");
        }
    }

    public int getAutoLottoCount(int manualLottoCount) {
        return (this.money / 1000) - manualLottoCount;
    }

    public double getRevenueRate(int totalWinningMoney) {
        return (double) totalWinningMoney / this.money;
    }
}
