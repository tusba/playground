package util.tree.node;

public interface ITreeNode<T> {

    default ITreeNode<T> getParent() {
        return null;
    }

    T valueOf();

}
