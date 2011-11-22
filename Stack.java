/**
 * @author Chris Arriola
 *
 * Class implementing a Stack
 */
public class Stack<V> {
    Node<V> top = null;

    /**
     * A pop from the stack.
     */
    public V pop() {

        if (top == null)
            return null;

        V returnVal = top.data;
        top = top.next;
        return returnVal;
    }

    public void push(V data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
}
