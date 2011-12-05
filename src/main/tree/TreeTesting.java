package tree;

/**
 * Testing for Tree datastructure.
 *
 * @author Chris Arriola
 */
public class TreeTesting {

    public static void main(String[] args) {
        Tree<Integer> t1 = new Tree<Integer>(1);
        Tree<Integer> t2 = new Tree<Integer>(2);
        Tree<Integer> t3 = new Tree<Integer>(3);
        Tree<Integer> t4 = new Tree<Integer>(4);
        Tree<Integer> t5 = new Tree<Integer>(5);
        Tree<Integer> t6 = new Tree<Integer>(6);
        Tree<Integer> t7 = new Tree<Integer>(7);
        Tree<Integer> t8 = new Tree<Integer>(8);
        Tree<Integer> t9 = new Tree<Integer>(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.left = t5;
        t5.left = t6;
        t7.left = t8;
        t8.left = t9;

        System.out.println(Trees.isBalanced(t1));

        int[] a = { 1, 2, 3, 4, 5,
                  6, 7, 8, 9, 10, 
                };
        Tree<Integer> treeA = Trees.createMinBinaryTree(a);
        System.out.println(Trees.isBalanced(treeA));
        System.out.println(treeA.value);
        System.out.println(treeA.left.value);
        System.out.println(treeA.right.value);
    }

}
