/**
 * @author Chris Arriola
 *
 * Class for Array and String questions
 */
public class Node {
    Node next;
    int data;

    public Node() {
        next = null;
    }

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node tail = new Node(d);

        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
    }
}
