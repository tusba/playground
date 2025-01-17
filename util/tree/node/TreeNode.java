package util.tree.node;

public class TreeNode<T> implements ITreeNode<T> {

    protected ITreeNode<T> parent;

    protected T value;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, ITreeNode<T> parent) {
        this(value);
        this.parent = parent;
    }

    @Override
    public ITreeNode<T> getParent() {
        return parent;
    }

    @Override
    public T valueOf() {
        return value;
    }

}
