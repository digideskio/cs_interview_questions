/**
 * Class that implements a queue using 2 stacks. 
 *
 * @author Chris Arriola
 */
public class MyQueue<V> {

    Stack<V> enqueueStack;    // Where we push elements when we enqueue
    Stack<V> dequeueStack;    // Where we pop elements when we dequeue

    public MyQueue() {
        enqueueStack = new Stack<V>();
        dequeueStack = new Stack<V>();
    }

    public void enqueue(V val) {

        if (dequeueStack.isEmpty()) {
            dequeueStack.push(val);
        } else {
            enqueueStack.push(val);
        }
    }

    public V dequeue() {
        
        if (dequeueStack.isEmpty()) {
            return null;
        }

        V returnVal = dequeueStack.pop();

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return returnVal;
    }
}
