package tree;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import linkedlists.*;

/**
 * Contains Tree datastructure methods.
 */
public class Trees {

    private Trees() {}

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
    public static List<ArrayList<Integer>> createListForEachDepth(Tree<Integer> tree) {
    
        if (tree == null) {
            return null;
        }

        List<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
        List<TreeNodeAndDepth> buffer = new LinkedList<TreeNodeAndDepth>();

        // TODO: create returnLIst
        int depth = maxDepth(tree);
        for (int i = 0; i < depth; i++) {
            returnList.add(new ArrayList<Integer>());
        }

        addToQueue(tree, buffer, 0);

        for (TreeNodeAndDepth node : buffer) {
            returnList.get(node.depth).add(node.value);
        }

        return returnList;
    }

    private static void addToQueue(Tree<Integer> tree, List<TreeNodeAndDepth> queue, int depth) {
       
        if (tree == null) {
            return;
        }

        TreeNodeAndDepth elem = new TreeNodeAndDepth(tree.value, depth);
        queue.add(elem);

        addToQueue(tree.left, queue, depth+1);
        addToQueue(tree.right, queue, depth+1);
    }

    private static class TreeNodeAndDepth {
        
        int value;
        int depth;
        TreeNodeAndDepth(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}
