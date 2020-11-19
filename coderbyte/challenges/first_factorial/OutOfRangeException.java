package coderbyte.challenges.first_factorial;

public class OutOfRangeException extends Exception {

    private static final long serialVersionUID = -4636475791088317303L;

    @Override
    public String getMessage() {
        return "The value is out of range";
    }

}
