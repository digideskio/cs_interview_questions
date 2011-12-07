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

    /**
     * Finds the next node (in-order succesor) of a given node in a binary search tree where
     * each node has a link to its parent.
     */
    public static Tree<Integer> inOrderSuccessor(Tree<Integer> tree) {

        Tree<Integer> curr = tree;
        Tree<Integer> parent = tree.parent;

        if (curr.right != null) {
            curr = curr.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        if (curr == parent.right) {
            while (parent != null && curr != parent.left) {
                curr = parent;
                parent = curr.parent;
            }

            return parent;
        }

        // If it is the left node of it's parent, simply return the parent.
        return parent;
    }

    /**
     * Finds the FIRST common ancestor of 2 nodes in a tree.
     */
    public static Tree<Integer> commonAncestor(Tree<Integer> tree, Tree<Integer> t1, Tree<Integer> t2) {
        if (!contains(tree, t1) && !contains(tree, t2)) {
            return null;
        }

        Tree<Integer> curr = tree;
        while (true) {
            if (contains(tree.left, t1) && contains(tree.left, t2)) {
                curr = tree.left;
            } else if (contains(tree.right, t1) && contains(tree.right, t2)) {
                curr = tree.right;
            }
            break;
        }
        return curr;
    }

    /**
     * Checks if tree contains t.
     */
    private static boolean contains(Tree<Integer> tree, Tree<Integer> t) {
        
        if (tree == null || t == null) {
            return false;
        }

        if (tree == t) {
            return true;
        }

        return (contains(tree.left, t) || contains(tree.right, t));
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
