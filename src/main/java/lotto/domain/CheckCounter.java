package lotto.domain;

import java.util.Map;
import java.util.TreeMap;

public class CheckCounter {
    private final Map<Integer, Integer> checkCounter;

    public CheckCounter() {
        this.checkCounter = new TreeMap<>();
    }

    public void setInitial(int key) {
        this.checkCounter.put(key, 1);
    }

    public int get(int key) {
        return this.checkCounter.getOrDefault(key, 0);
    }

    public boolean has(int key) {
        return this.checkCounter.containsKey(key);
    }

    public void countUp(int key) {
        int previousValue = this.checkCounter.get(key);
        this.checkCounter.put(key, previousValue + 1);
    }

    public int getTotalWinningMoney() {
        return (5_000 * this.checkCounter.getOrDefault(3, 0))
                + (50_000 * this.checkCounter.getOrDefault(4, 0))
                + (1_500_000 * this.checkCounter.getOrDefault(5, 0))
                + (2_000_000_000 * this.checkCounter.getOrDefault(6, 0));
    }
}
