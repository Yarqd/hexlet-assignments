package exercise;

import java.util.logging.Logger;

// BEGIN
public class MinThread extends Thread {
    private int[] one;
    private int minValue;
    private static final Logger LOGGER = Logger.getLogger(MinThread.class.getName());

    public MinThread(int[] a) {
        this.one = a;
    }
    @Override
    public void run() {
        LOGGER.info("Thread " + getName() + " started");
        minValue = findMin();
        LOGGER.info("Thread " + getName() + " finished");
    }

    private int findMin() {
        int min = one[0];
        for (int i : one) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public int getMinValue() {
        return minValue;
    }
}
// END
