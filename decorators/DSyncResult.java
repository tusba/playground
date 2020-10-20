package decorators;

import entities.IResult;

public class DSyncResult<T, U extends IResult<T>> extends Decorator<U> implements IResult<T> {

    @Override
    public synchronized T getValue() {
        return getTarget().getValue();
    }

    @Override
    public synchronized void setValue(T value) {
        getTarget().setValue(value);
    }

}
