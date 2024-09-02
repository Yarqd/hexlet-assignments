package exercise;

import java.util.logging.Logger;

// BEGIN
public class MaxThread extends Thread {
    private int[] two;
    private int maxValue;

    public MaxThread(int[] b) {
        this.two = b;
    }
    @Override
    public void run() {
        LOGGER.info("Thread " + getName() + " started");
        maxValue = findMax();
        LOGGER.info("Thread " + getName() + " finished");
    }

    private int findMax() {
        int max = two[0];
        for (int i : two) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
// END
