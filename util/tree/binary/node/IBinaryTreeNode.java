package util.tree.binary.node;

import util.tree.node.ITreeNode;

public interface IBinaryTreeNode<T> extends ITreeNode<T> {

    default IBinaryTreeNode<T> getLeft() {
        return null;
    }

    default IBinaryTreeNode<T> getRight() {
        return null;
    }

}
