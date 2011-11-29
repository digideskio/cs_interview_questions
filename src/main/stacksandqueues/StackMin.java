package stacksandqueues;

import linkedlists.*;

/**
 * Stack implementation that also keeps track of the minimum value in the Stack.
 * Uses Integer.
 *
 * @author Chris Arriola
 */
public class StackMin {

    IntNode min = null;
    IntNode top = null;

    public int pop() {

        if (top == null) {
            return Integer.MAX_VALUE;
        }

        // Check if the value of top is the minimum in the stack, if so, pop
        // from minimum list.
        int returnVal = top.data;
        if (returnVal == min.data) {
            min = min.next;
        }
        top = top.next;        

        return returnVal; 
    }

    public void push(int value) {

        // Check if new value is less that the current min in the stack, if so,
        // push that value in the minimum stack too.
        if (min == null || value < min.data) {
            IntNode newMin = new IntNode(value);
            newMin.next = min;
            min = newMin;
        }
    
        // Update top
        IntNode n = new IntNode(value);
        n.next = top;
        top = n;
    }

    public int getMin() {

        if (min == null) {
            return Integer.MAX_VALUE;
        }
            
        return min.data;
    }
}
