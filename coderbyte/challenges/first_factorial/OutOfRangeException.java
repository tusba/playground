package coderbyte.challenges.first_factorial;

public class OutOfRangeException extends Exception {

    @Override
    public String getMessage() {
        return "The value is out of range";
    }

}
