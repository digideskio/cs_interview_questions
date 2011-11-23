/**
 * @author Chris Arriola
 *
 * Class for Stack and Queue questions
 */
public class StacksAndQueues {

    /*
     * @args Not used.
     */
    public static void main(String[] args) {

        // Test Stack
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        s.push(20);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        // Test Queue
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(10);
        q.enqueue(20);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
