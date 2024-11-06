package tuple;

public class SimpleTuple<F, S> {

    private final F first;
    private final S second;

    public SimpleTuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return "First value: " + first + "; " +
                "Second value: " + second;
    }
}
