package tree;

/**
 * Contains Tree datastructure methods.
 */
public class Trees {

    /**
     * Checks if a Tree is balanced.
     */
    public static boolean isBalanced(Tree tree) {
        return (maxDepth(tree) - minDepth(tree) < 2 ? true : false);
    }

    /**
     * Gets the maximum depth of a Tree.
     */
    public static int maxDepth(Tree tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(tree.left), maxDepth(tree.right));
    }

    /**
     * Gets the minimum depth of a Tree.
     */
    public static int minDepth(Tree tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(tree.left), minDepth(tree.right));
    }
}
