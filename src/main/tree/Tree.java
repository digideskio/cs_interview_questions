package tree;

import java.util.ArrayList;

/**
 * Tree datastructure implementation.
 */
public class Tree<V> {
    V value;
    ArrayList<Tree<V>> children;

    public Tree(V val, Tree<V>... children) {
        this.value = val;
        this.children = new ArrayList<Tree<V>>();

        for (Tree<V> child : children) {
            this.children.add(child);
        }
    }

    public void setValue(V val) {
        value = val;
    }

    public V getValue() {
        return value;
    }

    public boolean isLeaf() {
        return (children.isEmpty() ? true : false);
    }

    public Tree<V> child(int index) {

        if (index > children.size()-1) {
            return null;
        }

        return children.get(index);
    }

    public int numberOfChildren() {
        return children.size();
    }
}
