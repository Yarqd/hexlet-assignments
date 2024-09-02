package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] two;
    private int maxValue;

    public Save2(int[] b) {
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
}
// END
