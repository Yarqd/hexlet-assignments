package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] one;
    private int minValue;

    public Save1(int[] a) {
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
}
// END
