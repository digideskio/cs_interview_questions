package tree;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains Tree datastructure methods.
 */
public class Trees {

    /**
     * Checks if a Tree is balanced.
     */
    public static boolean isBalanced(Tree<Integer> tree) {
        return (maxDepth(tree) - minDepth(tree) < 2 ? true : false);
    }

    /**
     * Gets the maximum depth of a Tree.
     */
    public static int maxDepth(Tree<Integer> tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(tree.left), maxDepth(tree.right));
    }

    /**
     * Gets the minimum depth of a Tree.
     */
    public static int minDepth(Tree<Integer> tree) {
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
    
        if (array.length == 0) {
            return null;
        }

        // Middle of the array is the node and then we use
        // recursion for the left and the right child
        Tree<Integer> root;
        int mid;
        int[] leftArray, rightArray;

        mid = array.length/2;
        leftArray = Arrays.copyOfRange(array, 0, mid);
        rightArray = (mid+1 == array.length ? new int[0] : Arrays.copyOfRange(array, mid+1, array.length));
        root = new Tree<Integer>(array[mid], createMinBinaryTree(leftArray),
                                             createMinBinaryTree(rightArray));

        return root;
    }

    /**
     * Given a binary search tree, this function will create a linked list
     * of all the nodes at each depth. The index of the ArrayList represents
     * the depth in the tree.
     */
    public static ArrayList<Node<Integer>> createListAtDepth(Tree<Integer>) {

    }
}
