package linkedlists;

/**
 * @author Chris Arriola
 *
 * Class that represents an integer link list node.
 */
public class IntNode {
    public IntNode next = null;
    public int data;

    public IntNode(int d) {
        data = d;
    }

    public void appendToTail(IntNode n) {

        IntNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
    }

    public void appendToTail(int d) {

        IntNode tail = new IntNode(d);

        IntNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
    }

    public void print() {
        System.out.print(data);

        IntNode curr = next;
        while (curr != null) {
            System.out.print("->" + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
