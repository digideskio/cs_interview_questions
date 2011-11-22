/**
 * @author Chris Arriola
 *
 * Class for Array and String questions
 */
public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public void appendToTail(Node n) {

        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
    }

    public void appendToTail(int d) {

        Node tail = new Node(d);

        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
    }

    public void print() {
        System.out.print(data);

        Node curr = next;
        while (curr != null) {
            System.out.print("->" + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
