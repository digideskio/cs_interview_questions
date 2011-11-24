/** 
 * Class that represents a Tower/Rod.
 *
 * @author Chris Arriola
 */
public class Tower {

    int index;
    Stack<Integer> stack;

    public Tower(int index) {
        this.index = index;
        this.stack = new Stack<Integer>();
    }

    /**
     * Adds a disc to this Tower
     */
    public void add(int disc) {

        if (stack.isEmpty()) {
            stack.push(disc);
            return;
        }

        if (stack.peek() < disc) {
            System.err.println("ERROR: Cannot push larger disc on a small disc.");
        } else {
            stack.push(disc);
        }
    }

    /**
     * Moves discs from this Tower to another Tower.
     */
    public void moveDiscs(int discs, Tower tempTower, Tower destTower) {

        if (discs <= 0) {
            return;
        }

        moveDiscs(discs-1, destTower, tempTower); 

        int discToMove = stack.pop();  
        destTower.add(discToMove);
        tempTower.moveDiscs(discs-1, this, destTower);
    }
}
