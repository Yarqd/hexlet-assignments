package exercise;

// BEGIN
public class Segment {
    private Point one;
    private Point two;

    public Segment (Point one, Point two) {
        this.one = one;
        this.two = two;
    }

    public int getBeginPoint() {
        int a = one.getX();
        int b = two.getX();
        return (a+b)/2;
    }

    public int getEndPoint() {
        int a = one.getY();
        int b = two.getY();
        return (a+b)/2;
    }

    public Point getMidPoint() {
        int a = getBeginPoint();
        int b = getEndPoint();
        return (a+b)/2;
    }
}
// END
