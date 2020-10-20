package entities;

public interface IResult<T> {

    T getValue();

    void setValue(T value);

}
