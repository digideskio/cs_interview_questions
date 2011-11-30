package tree;

import java.util.ArrayList;

/**
 * Tree datastructure implementation.
 */
public class Tree<V> {
    public V value;
    public Tree<V> left = null;
    public Tree<V> right = null;

    public Tree(V val) {
        this.value = val;
    }

    public Tree(V val, Tree<V> left, Tree<V> right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }
}
