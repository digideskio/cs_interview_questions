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

    public void print() {
        top.print();
    }

    public V peek() {
        return (top == null ? null : top.data);
    }

    public boolean isEmpty() {
        return (top == null ? true : false);
    }

    /**
     * Sorts an integer stack in ascending order
     */
    public static Stack<Integer> sort(Stack<Integer> stack) {
        
        if (stack == null) {
            return null;
        }

        Stack<Integer> returnStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int currElem = stack.pop();
            if (returnStack.isEmpty() || returnStack.peek() <= currElem) {
                returnStack.push(currElem);
            } else {
                while (returnStack.peek() > currElem) {
                    stack.push(returnStack.pop());
                    if (returnStack.isEmpty()) {
                        break;
                    }
                }
                returnStack.push(currElem);
            }
        }
        return returnStack;
    }
}
