package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public NegativeRadiusException() {
        super("Radius cannot be negative");
    }
}
// END
