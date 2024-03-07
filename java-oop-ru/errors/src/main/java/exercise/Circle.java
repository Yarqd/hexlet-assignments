package exercise;

// BEGIN
public class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        if (radius < 0) {
            throw new NegativeRadiusException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double getSquare() {
        if (radius < 0) {
            throw new NegativeRadiusException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }
}
// END
