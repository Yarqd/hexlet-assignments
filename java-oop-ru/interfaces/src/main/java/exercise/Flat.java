package exercise;

// BEGIN
public class Flat implements Home {

    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat (double area, double balconyArea, int floor){
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public String toString() {
        return String.format("Квартира площадью %.1f метров на %d этаже", getArea(), floor);
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (area > another) {
            return 1;
        } else if (area < another) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
