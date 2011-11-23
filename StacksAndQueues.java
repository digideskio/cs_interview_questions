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

        // Test SetOfStacks
        SetOfStacks<Integer> stacks = new SetOfStacks<Integer>();
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);

        System.out.println(stacks.popAt(1));
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}
