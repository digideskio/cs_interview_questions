/**
 * Class implementing a Set of Stacks. Essentially, a single stack is used but
 * if the stacks reaches a a certain threshold, a new stack will be created.
 * To do this, we use a link list of stacks.
 *
 * @author Chris Arriola
 */
public class SetOfStacks<V> {

    private Node<StackCount<V>> stacks;
    private int threshold;

    public SetOfStacks() {
        this.stacks = null;
        this.threshold = 5;
    }

    public SetOfStacks(int threshold) {
        this.stacks = null;
        this.threshold = threshold;
    }

    public void push(V value) {

        // if nothing on the stack or if the current stack is full, create
        // a new stack and at it to stacks.
        if (stacks == null || stacks.data.size() == threshold) {

            StackCount<V> s = new StackCount<V>();
            s.push(value);

            Node<StackCount<V>> newNode = new Node<StackCount<V>>(s);
            newNode.next = stacks;
            stacks = newNode;

            return;
        }

        // otherwise, simply push new data on top of the head of stacks.
        stacks.data.push(value);
    }

    @SuppressWarnings("unchecked")
    public V pop() {

        if (stacks == null) {
            return null;
        }

        // Pop from the stack at the head of stacks
        V returnVal = stacks.data.pop();
        
        // If after popping the stack is empty, move stacks to it's next stack.
        if (stacks.data.size() == 0) {
            stacks = stacks.next;
        }

        return returnVal;
    }

    @SuppressWarnings("unchecked")
    public V popAt(int index) {

        Node<StackCount<V>> prev = stacks;
        Node<StackCount<V>> curr = stacks;

        // Find which stack
        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return null;
            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return null;
        }

        // Pop from that stack
        V returnVal = curr.data.pop();
        
        // Check if curr is empty, if so, remove that stack.
        if (curr.data.size() == 0) {
            // Remove
            if (prev == curr) {
                stacks = stacks.next;
            } else {
                prev.next = curr.next;
            }
        }

        return returnVal;
    }

    /*
     * Stack that keeps track of how many elements it has.
     */
    private class StackCount<V> extends Stack<V> {

        int size;
        
        public StackCount() {
            size = 0;
        }

        public V pop() {
            V returnVal = super.pop();
            if (returnVal != null) {
                size--;
            }
            return returnVal;
        }

        public void push(V value) {
            size++;
            super.push(value);
        }

        public int size() {
            return size;
        }
    }
}
