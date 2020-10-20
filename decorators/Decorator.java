package decorators;

public class Decorator<T> implements IDecorator<T> {

    private T target;

    protected T getTarget() {
        return target;
    }

    @Override
    public void decorate(T target) {
        this.target = target;
    }

}
