package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String original;

    public ReversedSequence(String str) {
        this.original = str;
    }

    @Override
    public int length() {
        return original.length();
    }

    @Override
    public char charAt(int index) {
        return original.charAt(original.length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new StringBuilder(original.substring(start, end)).reverse().toString();
    }

    @Override
    public String toString() {
        return new StringBuilder(original).reverse().toString();
    }
}
// END
