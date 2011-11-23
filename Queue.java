/**
 * @author Chris Arriola
 *
 * Class implementing a Queue
 */
public class Queue<V> {
    Node<V> first;
    Node<V> last;

    public Queue() {
        first = null;
        last = null;
    }

    public void enqueue(V data) {
        if (first == null) {
            first = new Node<V>(data);
            last = first;
        } else {
            last.next = new Node<V>(data);
            last = last.next;
        }
    }

    public V dequeue() {

        if (first == null)
            return null;

        V returnVal = first.data;
        first = first.next;

        // if first and last are the same value.
        if (first == null)
            last = null;

        return returnVal;
    }
}
