package stacksandqueues;

/**
 * Class that implements 3 stacks using 1 array (Integer).
 *
 * 1st implementations:
 *
 * One stack gets the first third of the array, the second stack gets the next third,
 * and the last stack gets the final third.
 *
 * @author Chris Arriola
 */
public class ThreeStacksOneArray1 {

    int[] stackIndices = { -1, -1, -1 };     // Indices of the top of each stack
    int stackSize;                         // Maximum size of stack  
    int[] buffer;                          // Array containing 3 stacks.

    public ThreeStacksOneArray1() {
        this.stackSize = 300;
        buffer = new int[stackSize * 3];
    }

    public ThreeStacksOneArray1(int stackSize) {
        this.stackSize = stackSize;
        buffer = new int[stackSize * 3];
    }

    /**
     * Returns the top value of the stack.
     */
    public int peek(int stackNumber) {

        // If stack is empty, return -1.
        int top = stackIndices[stackNumber];
        if (top == -1) {
            return -1;
        }

        // Otherwise, simply return value at the top of the stack.
        return buffer[(stackNumber * stackSize) + top];
    }

    /**
     * Pushes a value to the top of the stack.
     */
    public void push(int stackNumber, int value) {

        int top = stackIndices[stackNumber] + 1;
        
        // If stack is full, simply return
        if (top == this.stackSize) {
            return;
        }

        // Otherwise, push to the corresponding stack.
        stackIndices[stackNumber]++;
        buffer[(stackNumber * stackSize) + top] = value;
    }

    /**
     * Returns the top of the stack and decrements the pointer.
     */
    public int pop(int stackNumber) {
        
        int top = stackIndices[stackNumber];

        // If stack is empty, return -1.
        if (stackIndices[stackNumber] == -1) {
            return -1;
        }

        // Otherwise, return top of stack and decrement corresponding top.
        stackIndices[stackNumber]--;
        return buffer[(stackNumber * stackSize) + top]; 
    }

    /**
     * Checks if a stack is empty.
     */
    public boolean isEmpty(int stackNumber) {
        if (stackIndices[stackNumber] == -1) {
            return true;
        }
        return false;
    }
}
