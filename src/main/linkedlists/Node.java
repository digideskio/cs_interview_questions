package linkedlists;

/**
 * @author Chris Arriola
 *
 * Class that represents a generic link list node.
 */
public class Node<V> {

    Node<V> next = null;
    V data;

    public Node(V data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    void appendToTail(V data) {

        Node<V> curr = this;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node<V>(data);
    }

    @SuppressWarnings("unchecked")
    public void print() {
        System.out.print(data);

        Node<V> curr = this.next;
        while (curr != null) {
            System.out.print("->" + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
