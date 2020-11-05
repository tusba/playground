package util.array;

public class NullArrayException extends Exception {

    private static final long serialVersionUID = -7485136219318613721L;

    @Override
    public String getMessage() {
        return "The array cannot be null";
    }

}
