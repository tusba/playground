package coderbyte.challenges.tree_constructor;

import java.util.HashMap;
import java.util.Map;

import coderbyte.challenges.tree_constructor.tree.Node;
import coderbyte.challenges.tree_constructor.tree.NodeException;
import coderbyte.challenges.tree_constructor.util.Pairs;

public class Challenge implements IChallenge {

    private final Map<Integer, Node> nodes = new HashMap<>();

    private void reset() {
        if (nodes.size() > 0) {
            nodes.clear();
        }
    }

    private Node obtainNode(int value) {
        if (nodes.containsKey(value)) {
            return nodes.get(value);
        }

        Node node = new Node(value);
        nodes.put(value, node);

        return node;
    }

    private boolean validateTree() {
        int roots = 0;

        for (Node node : nodes.values()) {
            if (node.getParent() == null) {
                roots++;
            }

            if (roots > 1) {
                return false;
            }
        }

        return roots == 1;
    }

    @Override
    public boolean treeConstructor(String[] pairs) {
        Pairs converter = new Pairs();
        return treeConstructor(converter.convert(pairs));
    }

    @Override
    public boolean treeConstructor(int[][] pairs) {
        reset();

        for (int[] pair : pairs) {
            Node node = obtainNode(pair[0]);
            Node parent = obtainNode(pair[1]);
            try {
                node.bindParent(parent);
            } catch (NodeException e) {
                return false;
            }
        }

        return validateTree();
    }

}
