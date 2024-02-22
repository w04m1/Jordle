import java.util.function.Predicate;

public enum Status implements Predicate<Status> {
    MISSING("\u001B[31m"),
    WRONGPOS("\u001B[33m"),
    CORRECT("\u001B[32m");

    private final String s;

    Status(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return this.s;
    }

    @Override
    public boolean test(Status status) {
        return this == status;
    }
}
