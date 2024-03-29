package exercise;

// BEGIN
public class Segment {
    private final Point one;
    private final Point two;

    public Segment(Point one, Point two) {
        this.one = one;
        this.two = two;
    }

    public Point getBeginPoint() {
        return one;
    }

    public Point getEndPoint() {
        return two;
    }

    public Point getMidPoint() {
        int a = (getBeginPoint().getX() + getEndPoint().getX()) / 2;
        int b = (getBeginPoint().getY() + getEndPoint().getY()) / 2;
        return new Point(a, b);
    }
}
// END
