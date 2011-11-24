/**
 * Towers of Hanoi
 *
 * @author Chris Arriola
 */
public class TowersOfHanoi {

    public static void main(String[] args) {

        // Create rods
        int numOfDiscs = 10;
        Tower[] towers = new Tower[3];

        // Add Towers
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        // Add discs to towers
        for (int i = numOfDiscs; i > 0; i--) {
            towers[0].add(i);
        }

        // Solve towers of hanoi
        towers[0].moveDiscs(numOfDiscs, towers[1], towers[2]);
    }
}
