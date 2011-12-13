package bitmanipulation;

/**
 * Class containing bit manipulation questions.
 *
 * @author Chris Arriola
 */
public class BitManipulation {

    /**
     * Given a decimal number, this function will return the binary
     * representation of that number as a String.
     */
    public static String printBinary(String number) {
        int integer = Integer.parseInt(number.substring(0, number.indexOf(".")));
        double decimal = Double.parseDouble(number.substring(number.indexOf(".")));

        StringBuilder integerResult = new StringBuilder();
        StringBuilder decimalResult = new StringBuilder();
        int i = 0;

        // Get binary representation of integer
        while (integer != 0) {
            i = integer % 2;
            integer = integer / 2;
            integerResult.insert(0, i);
        }

        // Get binary representation of decimal
        while (decimal > 0) {
            decimal = decimal*2;
            if (decimal >= 1) {
                i = 1;
                decimal--;
            } else {
                i = 0;
            }
            decimalResult.append(i);

            if (decimalResult.length() > 32) return "ERROR";
        }

        return integerResult.toString() + "." + decimalResult.toString();
    }

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
        System.out.println(printBinary("4.5"));
    }
}
