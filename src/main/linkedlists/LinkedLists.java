package linkedlists;

import java.util.HashMap;

/**
 * @author Chris Arriola
 *
 * Class for Linked List questions.
 */
public class LinkedLists {

    /**
     * Removes duplicates from an unsorted linked list using a buffer as storage.
     */
    public static void removeDuplicates(IntNode head) {

        if (head == null || head.next == null)
            return;

        // Create new buffer
        HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();
       
        // Loop through each IntNode and look if the node is in the hashmap, 
        // if so, delete. otherwise, add to hashmap.
        buffer.put(head.data, 1);
        IntNode prev = head;
        IntNode curr = head.next;
        while (curr != null) {
            if (buffer.containsKey(curr.data)) {
                // delete
                prev.next = curr.next;
            } else {
                buffer.put(curr.data, 1);
                prev = curr;
            }

            curr = curr.next;
        }
    }

    /**
     * Remove duplicates from an unsorted linked list without using a buffer.
     */
    public static void removeDuplicates2(IntNode head) {

        if (head == null || head.next == null)
            return;

        // We have 3 pointers, one at the head of the link list (head),
        // one pointing at the current (prev), and the other pointing
        // at the next node over (curr). We look at the value of curr and compare
        // it to values starting from head until prev, if it exists, remove,
        // otherwise, don't remove. Thereafter, we increment prev and curr by 1.
        IntNode prev = head;
        IntNode curr = prev.next;
        
        while (curr != null) {
            IntNode temp = head;
            while (temp != prev.next) {
                if (curr.data == temp.data) {
                    // delete
                    prev.next = curr.next;
                    curr = prev.next;
                    break;
                } 
                // no match
                temp = temp.next;
            }
            if (temp == curr) {
                prev = curr;
                curr = curr.next;
            }
        }

    }

    /**
     * Retrieves the nth to last element of a singly linked list.
     */
    public static IntNode nthToLast(IntNode head, int n) {
        
        if (head == null)
            return null;

        IntNode n1 = head;
        IntNode n2 = head;

        // Move n2 so that n1 and n2 are n-1 distance apart
        for (int i = 0; i < n-1; i++) {
            n2 = n2.next;
        }

        // Move until n2.next == null, return n1 when it is.
        while (n2.next != null) {
            n2 = n2.next;
            n1 = n1.next;
        }

        return n1;
    }

    /**
     * Deletes a node in the middle of a single linked list, given only
     * access to that node.
     */
    public static void deleteMiddleIntNode(IntNode node) {
        
        if (node == null)
            return;

        // Tail case
        if (node.next == null) {
            node = null;
            return;
        }

        // Standard case
        node.data = node.next.data;
        node.next = node.next.next;
    }

    /**
     * Generates 'n' random IntNodes.
     */
    private static IntNode generateRandomIntNodes(int n) {    	

        if (n == 0)
            return null;

        IntNode newIntNode = new IntNode((int)(Math.random()*10));
    	for (int i = 1; i < n; i++) {
            newIntNode.appendToTail((int)(Math.random()*10));
    	}

        return newIntNode;
    }

    /**
     * Adds 2 link lists where the head of the link list represents
     * the 1's digit, next is the 10's digit, etc.
     *
     * ex.
     * input: (3->1->5) + (5->9->2)
     * output: 8->0->8
     */
    public static IntNode addLinkLists(IntNode n1, IntNode n2) {

        // null cases
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        // start addition
        IntNode nodeSum = null;
        int carry = 0;
        while (n1 != null || n2 != null) {
            int digitSum = 0;
            
            // Compute sum of digits
            if (n1 != null) {
                digitSum += n1.data;
            }
            if (n2 != null) {
                digitSum += n2.data;
            }
            digitSum += carry; 

            // Add to nodeSum
            int digitData = (digitSum+carry) % 10;
            carry = digitSum / 10;
            if (nodeSum == null) {
                nodeSum = new IntNode(digitData);
            } else {
                nodeSum.appendToTail(digitData);
            }

            // Increment
            if (n1 != null) {
                n1 = n1.next;
            } 
            if (n2 != null) {
                n2 = n2.next;
            } 
        }

        // if we have a remaining carry. happens when for ex.
        // (9->9) + (1) = (0->0->1)
        if (carry != 0) {
            nodeSum.appendToTail(carry);
        }

        return nodeSum;
    }

    /**
     * Given a circular linked list, this function will return the node
     * at the beginning of the loop.
     *
     * Ex.
     * input: (A->B->C->D->E->C)
     * output: C
     */
    public static IntNode findBeginningOfLoop(IntNode n) {

        if (n == null)
            return null;

        IntNode nSingle = n;
        IntNode nDouble = n;

        // Keep looping until nSingle == nDouble
        do {
            nSingle = nSingle.next;
            nDouble = nDouble.next.next;
        } while (nSingle != nDouble);

        // Once they are equal, set one at head, and then keep incrementing
        // each pointer by one until they are equal. The position when they are
        // equal is the beginning of the loop.
        nDouble = n;
        while (nDouble != nSingle) {
            nDouble = nDouble.next;
            nSingle = nSingle.next;
        }

        return nSingle;
    }

    /**
     * @args Not used.
     */
    public static void main(String[] args) {
        IntNode n1 = new IntNode(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);

        IntNode n2 = new IntNode(9);
        n2.appendToTail(9);
        n2.appendToTail(9);

        IntNode nBeginning = new IntNode(4);
        IntNode nEnd = new IntNode(8);
        IntNode nLoop = new IntNode(1);
        nLoop.appendToTail(2);
        nLoop.appendToTail(3);
        nLoop.appendToTail(nBeginning);
        nLoop.appendToTail(5);
        nLoop.appendToTail(6);
        nLoop.appendToTail(7);
        nLoop.appendToTail(nEnd);
        nEnd.next = nBeginning;

        IntNode nodes[] = {
            generateRandomIntNodes(5),
            generateRandomIntNodes(8),
            generateRandomIntNodes(12)
        };

        //
        // Test removeDuplicates2()
        //
        System.out.println("\nOriginal...\n");
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].print();
        }

        //System.out.println("\nRemoving Duplicates...\n");
        //for (int i = 0; i < nodes.length; i++) {
        //    removeDuplicates2(nodes[i]);
        //    nodes[i].print();
        //}

        // 
        // Test nthToLast()
        //
        System.out.println("\nRetrieving nth to last...\n");
        for (int i = 0; i < nodes.length; i++) {
            nthToLast(nodes[i], i+1).print();
        }

        //
        // Test deleteMiddleIntNode()
        //
        System.out.println("\nDeleting middle node...\n");
        System.out.print("Original: ");
        n1.print();
        deleteMiddleIntNode(n1.next.next);
        System.out.print("Output: ");
        n1.print();

        //
        // Test addLinkLists()
        //
        System.out.println("\nTesting addLinkLists()...\n");
        n1.print();
        System.out.println("+");
        n2.print();
        System.out.println("=");
        addLinkLists(n1, n2).print();

        //
        // Test findBeginningOfLoop()
        //
        System.out.println("\nTesting findBeginningOfLoop()...\n");
        IntNode nResult = findBeginningOfLoop(nLoop);
        System.out.println("Beginning of Loop: " + nResult.data);
    }
}
