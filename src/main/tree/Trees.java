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

    /**
     * Given a sorted Integer array (increasing order), this function 
     * will create a binary tree with minimal height.
     */
    public static Tree<Integer> createMinBinaryTree(int[] array) {
    
        if (array == null) {
            return null;
        }

        // Middle of the array is the node and then we use
        // recursion for the left and the right child
        Tree<Integer> root;
        List<Integer> arrayList;
        int[] leftArray, rightArray;
        int mid;

        mid = array.length/2;
        arrayList = Arrays.asList(array).subList(0, mid);
        leftArray = arrayList.subList(0, mid);
        rightArray = (mid+1 == array.length ? null : arrayList.subList(mid+1, array.length));
        root = new Tree(array[mid], createMinBinaryTree(leftArray),
                                    createMinBinaryTree(rightArray));

        return root;
    }
}
