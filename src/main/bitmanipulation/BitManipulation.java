package bitmanipulation;

/**
 * Class containing bit manipulation questions.
 *
 * @author Chris Arriola
 */
public class BitManipulation {

    /**
     * Method that sets all bits between i and j in N equal to M.
     */
    public static int setSubBits(int N, int M, int i, int j) {

        // invalid bit indices
        if (i < 0 || i > 31 || j < 0 || j > 31) {
            return -1;
        }

        // M is larger than alloted indices
        if ((M >>> j-i+1) != 0) {
            return -1;
        }

        // Set all index positions in N from i to j to 0
        int mask = 0;
        for (int x = i; x < j+1; x++) {
            mask = mask | (1 << x);
        }
        mask = ~mask;

        // Apply mask to N then AND N with M
        N = N & mask;
        N = N | (M << i);
        
        return N;
    }

    public static void main(String[] args) {
        System.out.println(setSubBits(256, 5, 1, 3));
    }
}
