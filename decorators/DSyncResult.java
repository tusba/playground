package decorators;

import entities.IResult;

public class DSyncResult<T> extends Decorator<IResult<T>> implements IResult<T> {

    @Override
    public synchronized T getValue() {
        return getTarget().getValue();
    }

    @Override
    public synchronized void setValue(T value) {
        getTarget().setValue(value);
    }

}
