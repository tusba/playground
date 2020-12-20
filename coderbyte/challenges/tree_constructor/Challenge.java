package coderbyte.challenges.tree_constructor;

import coderbyte.challenges.tree_constructor.util.Pairs;

public class Challenge implements IChallenge {

    @Override
    public boolean treeConstructor(String[] pairs) {
        Pairs convertor = new Pairs();
        return treeConstructor(convertor.convert(pairs));
    }

    @Override
    public boolean treeConstructor(int[][] pairs) {
        return false;
    }

}
