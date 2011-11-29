package stacksandqueues;

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
        s.push(15);
        s.push(12);

        System.out.println("Before sorting...");
        s.print();
        System.out.println("\nAfter sorting...");
        Stack<Integer> sSorted = Stack.sort(s);
        sSorted.print();

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

        // Test MyQueue
        MyQueue<Integer> myqueue = new MyQueue<Integer>();
        myqueue.enqueue(1); 
        myqueue.enqueue(2);
        myqueue.enqueue(3);

        System.out.println(myqueue.dequeue());

        myqueue.enqueue(4);
        myqueue.enqueue(5);

        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());

        // Test ThreeStacksOneArray1
        ThreeStacksOneArray1 threeStacks1 = new ThreeStacksOneArray1(5);
        threeStacks1.push(0, 1); 
        threeStacks1.push(0, 2); 
        threeStacks1.push(0, 3); 
      
        threeStacks1.push(1, 1); 
        threeStacks1.push(1, 2); 
        threeStacks1.push(1, 3); 
        threeStacks1.push(1, 4); 
        threeStacks1.push(1, 5); 
        threeStacks1.push(1, 6);  // shouldn't work

        threeStacks1.push(2, 1); 
        threeStacks1.push(2, 2); 
        threeStacks1.push(2, 3); 

        System.out.println("stack0 top: " + threeStacks1.peek(0));
        System.out.println("stack1 top: " + threeStacks1.peek(1));
        System.out.println("stack2 top: " + threeStacks1.peek(2));

        // Test ThreeStacksOneArray2
        ThreeStacksOneArray2 threeStacks2 = new ThreeStacksOneArray2(5);
        threeStacks2.push(0, 1); 
        threeStacks2.push(0, 3); 
        threeStacks2.push(0, 2); 
        threeStacks2.push(0, 4); 
        threeStacks2.push(0, 5); 
        threeStacks2.push(0, 6); 
        threeStacks2.pop(0);

        threeStacks2.push(1, 1); 
        threeStacks2.push(1, 2); 
        threeStacks2.push(1, 3); 
        threeStacks2.push(1, 4); 
        threeStacks2.push(1, 5); 
        threeStacks2.push(1, 6);  // shouldn't work

        threeStacks2.push(2, 1); 
        threeStacks2.push(2, 2); 
        threeStacks2.push(2, 3); 

        System.out.println("stack0 top: " + threeStacks2.peek(0));
        System.out.println("stack1 top: " + threeStacks2.peek(1));
        System.out.println("stack2 top: " + threeStacks2.peek(2));
    }
}
