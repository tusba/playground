package coderbyte.challenges.tree_constructor.tree;

public class NodeException extends Exception {

    private static final long serialVersionUID = -750463033371261991L;

    @Override
    public String getMessage() {
        return "Invalid binary tree node";
    }

}
