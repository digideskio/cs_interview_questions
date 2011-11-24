/**
 * Class implementing a Stack
 *
 * @author Chris Arriola
 */
public class Stack<V> {
    Node<V> top = null;

    /**
     * A pop from the stack.
     */
    @SuppressWarnings("unchecked")
    public V pop() {

        if (top == null)
            return null;

        V returnVal = top.data;
        top = top.next;
        return returnVal;
    }

    public void push(V data) {

        // NOTE: not checking if data pushed is the same as data on top.
        Node<V> n = new Node<V>(data);
        n.next = top;
        top = n;
    }


    public V peek() {
        return (top == null ? null : top.data);
    }

    public boolean isEmpty() {
        return (top == null ? true : false);
    }
}
