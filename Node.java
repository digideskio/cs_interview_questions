/**
 * @author Chris Arriola
 *
 * Class that represents a generic link list node.
 */
public class Node<V> {

    Node next = null;
    V data;

    public Node(V data) {
        this.data = data;
    }

    void appendToTail(V data) {

        Node curr = this;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);
    }

    public void print() {
        System.out.print(data);

        Node curr = this.next;
        while (curr != null) {
            System.out.print("->" + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
