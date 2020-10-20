package decorators;

import entities.IResult;

public interface IDSyncResult<T, U> extends IResult<T>, IDecorator<U> {
}
