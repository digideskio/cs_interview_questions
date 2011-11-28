/**
 * Class that implements 3 stacks using 1 array (Integer).
 * 2 implementations:
 *
 * (1) Functions with a "1" index is using the implementation wherein one stack
 *     gets the first third of the array, the second stack gets the next third,
 *     and the last stack gets the final third.
 *
 * (2) Functions with a "2" index is using the implementation where each element
 *     in a stack keeps track of it's previous elements index in the array.
 *
 * @author Chris Arriola
 */
public class ThreeStacksOneArray {

    int stackSize;    // Maximum size of stack  
    int[] buffer;     // Array containing 3 stacks.

    public ThreeStacksOneArray() {
        this.stackSize = 300;
        buffer = new int[stackSize * 3];
    }

    public ThreeStacksOneArray(int stackSize) {
        this.stackSize = stackSize;
        buffer = new int[stackSize * 3];
    }

    /**************************************************************************\
    * Implementation 1                                                         *
    \**************************************************************************/

    int stackIndices = { -1, -1, -1 };     // Indices of the top of each stack

    /**
     * Pushes a value to the top of the stack.
     */
    public void push1(int stackNumber, int value) {

        int top = stackIndices[stackNumber];
        
        // If stack is full, simply return
        if (top == this.stackSize-1) {
            return;
        }

        // Otherwise, push to the corresponding stack.
        stackIndices[stackNumber]++;
        buffer[(stackNumber * stackSize) + top] = value;
    }

    /**
     * Returns the top of the stack and decrements the pointer.
     */
    public int pop1(int stackNumber) {
        
        int top = stackIndices[stackNumber];

        // If stack is empty, return -1.
        if (stackIndices[stackNumber] == -1)) {
            return;
        }

        // Otherwise, return top of stack and decrement corresponding top.
        stackIndices[stackNumber]--;
        return buffer[(stackNumber * stackSize) + top]; 
    }

    /**
     * Peeks at top of a stack.
     */
    public int peek1(int stackNumber) {

        // If stack is empty, return -1.
        if (stackIndices[stackNumber] == -1) {
            return -1;
        }

        // Otherwise, simply return value at the top of the stack.
        return buffer[(stackNumber * stackSize) + top];
    }

    /**
     * Checks if a stack is empty.
     */
    public bool isEmpty1(int stackNumber) {
        if (stackIndices[stackNumber] == -1) {
            return true;
        }
        return false;
    }
    
    /**************************************************************************\
    * Implementation 2                                                         *
    \**************************************************************************/

    /**
     * Pushes a value to the top of the stack.
     */
    public void push2(int stackNumber, int value) {

        int top = stackIndices[stackNumber]++;
        
        // If stack is full, simply return
        if (top == this.stackSize) {
            // TODO
        }

        // Otherwise, push to the corresponding stack.
    }

    /**
     * Returns the top of the stack and decrements the pointer.
     */
    public int pop2(int stackNumber) {
        
        // If stack is empty, return -1.

        // Otherwise, return top of stack and decrement corresponding top.
    }

    /**
     * Peeks at top of a stack.
     */
    public int peek2(int stackNumber) {
        // If stack is empty, return -1.

        // Otherwise, simply return value at the top of the stack.
    }

    /**
     * Checks if a stack is empty.
     */
    public bool isEmpty2(int stackNumber) {
    }
}
