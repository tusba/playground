package coderbyte.challenges.tree_constructor.tree;

import util.tree.binary.node.BinaryTreeNode;

public class Node extends BinaryTreeNode<Integer> {

    private void bindParent() throws NodeException {
        bindParent(getParent());
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

    public void bindParent(Node parentNode) throws NodeException {
        if (parentNode.canAddLeft(value)) {
            parentNode.left = this;
            parent = parentNode;
            return;
        }

        if (parentNode.canAddRight(value)) {
            parentNode.right = this;
            parent = parentNode;
            return;
        }

        throw new NodeException();
    }

    @Override
    public Node getParent() {
        return (Node) super.getParent();
    }

}
