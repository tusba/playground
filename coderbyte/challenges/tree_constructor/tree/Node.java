package coderbyte.challenges.tree_constructor.tree;

import util.tree.binary.node.BinaryTreeNode;

public class Node extends BinaryTreeNode<Integer> {

    private void bindParent() throws NodeException {
        Node parent = this.getParent();

        if (parent.canAddLeft(value)) {
            parent.left = this;
            return;
        }

        if (parent.canAddRight(value)) {
            parent.right = this;
            return;
        }

        throw new NodeException();
    }

    private boolean canAddLeft(int value) {
        return left == null && value < this.value;
    }

    private boolean canAddRight(int value) {
        return right == null && value > this.value;
    }

    public Node(Integer value) {
        super(value);
    }

    public Node(Integer value, Node parent) throws NodeException {
        super(value, parent);
        bindParent();
    }

    @Override
    public Node getParent() {
        return (Node) super.getParent();
    }

}
