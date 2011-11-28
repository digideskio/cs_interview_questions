/**
 * Class that implements 3 stacks using 1 array (Integer).
 *
 * 2nd implementation:
 *
 * Each element in the stack keeps track of it's previous elements' index in the array.
 *
 * @author Chris Arriola
 */
public class ThreeStacksOneArray2 {
    
    int[] stackIndices = { -1, -1, -1 };
    StackElem[] buffer;     // Integer array containing the 3 stacks.
    int maxStackSize;       // Max size of a stack
    IntNode freeSpaces;     // Link list containing index where to push elements

    public ThreeStacksOneArray2() {
        this(300);
    }

    public ThreeStacksOneArray2(int maxStackSize) {

        buffer = new StackElem[maxStackSize * 3];
        maxStackSize = maxStackSize; 

        // Fill in freespaces
        freeSpaces = new IntNode(0);
        for (int i = 1; i < buffer.length; i++) {
            freeSpaces.appendToTail(i);
        }
    }

    public void push(int data, int whichStack) {

        if (freeSpaces == null) {
            return;
        }

        // Create a StackElem
        StackElem elem = new StackElem();
        elem.data = data;
        elem.prevLocation = stackIndices[whichStack];

        // Push StackElem to buffer
        buffer[freeSpaces.data] = elem;

        // Update stackIndices
        stackIndices[whichStack] = freeSpaces.data;

        // Update freeSpaces
        freeSpaces = freeSpaces.next;
    }

    public int pop(int whichStack) {

        // Return -1 if the stack is empty
        if (stackIndices[whichStack] == -1) {
            return -1;
        }

        // Otherwise
        // Obtain data from top of stack
        int currTop = stackIndices[whichStack];
        StackElem elem = buffer[currTop]; 
        int returnVal = elem.data;

        // Set the value of that location to null
        buffer[stackIndices[whichStack]] = null;

        // Update freeSpaces
        if (freeSpaces == null) {
            freeSpaces = new IntNode(currTop);
        } else {
            freeSpaces.appendToTail(currTop);
        }

        // Update stackIndices
        stackIndices[whichStack] = elem.prevLocation;

        return returnVal;
    }

    public int peek(int whichStack) {
        
        int stackTop = stackIndices[whichStack];
        if (stackTop == -1) {
            return -1;
        }

        return buffer[stackTop].data;
    }

    public boolean isEmpty(int whichStack) {
        return (stackIndices[whichStack] == -1 ? true : false);
    }

    private class StackElem {
        int data;
        int prevLocation;
    }
}
