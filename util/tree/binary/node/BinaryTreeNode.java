package util.tree.binary.node;

import util.tree.node.TreeNode;

public class BinaryTreeNode<T> extends TreeNode<T> implements IBinaryTreeNode<T> {

    protected IBinaryTreeNode<T> left;

    protected IBinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        super(value);
    }

    public BinaryTreeNode(T value, IBinaryTreeNode<T> parent) {
        super(value, parent);
    }

    public BinaryTreeNode(T value, T parentValue) {
        super(value, parentValue);
    }

    @Override
    public IBinaryTreeNode<T> getLeft() {
        return left;
    }

    @Override
    public IBinaryTreeNode<T> getRight() {
        return right;
    }

}
