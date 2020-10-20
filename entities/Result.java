package entities;

public class Result<T> implements IResult<T> {

    private T value;

    public Result(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

}
