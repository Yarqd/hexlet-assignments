package exercise;

// BEGIN
public class Cottage implements Home {

    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("%d этажный коттедж площадью %.1f метров", floorCount, area);
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (area > anotherArea) {
            return 1;
        } else if (area < anotherArea) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
