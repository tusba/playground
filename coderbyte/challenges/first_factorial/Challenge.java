package coderbyte.challenges.first_factorial;

public class Challenge implements IChallenge {

    @Override
    public int firstFactorial(int num) throws OutOfRangeException {
        if (!FactorialRange.isValid(num)) {
            throw new OutOfRangeException();
        }

        return num == 1 ? 1 : num * firstFactorial(num - 1);
    }

}
