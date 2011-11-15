/**
 * @author Chris Arriola
 *
 * Class for Array and String questions
 */
public class ArraysAndStrings {

    /**
     * Checks if a String has unique characters (using a buffer).
     */
    public static boolean hasUniqueChars(String s) {

        if (s == null || s.length() == 1)
            return true;

        int buffer[] = new int[256]; // Note: can also use bit indexing on another structure.
        for (int i = 0; i < s.length(); i++) {
            if (buffer[s.charAt(i)] != 0) {
                return false;
            } else {
                buffer[s.charAt(i)] = 1;
            }
        }
        return true;
    }

    /**
     * Checks if a String has unique characters (without using a buffer).
     */
    public static boolean hasUniqueChars2(String s) {

        if (s == null || s.length() == 1)
            return true;
        
        // Sort array
        s = sortString(s);

        // Check if there exists sArray[i] == sArray[i+1] from i = 0 until i = s.length-2
        // if so, then there is a character repeat, otherwise, all chars are unique.
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1))
                return false;
        }
        return true;
    }

    /**
     * Sorts a String
     */
    private static String sortString(String s) {
        
        if (s == null || s.length() == 1)
            return s;

        // Convert to char array
        char sArray[] = s.toCharArray();

        // Sort
        for (int i = 0; i < sArray.length-1; i++) {
            for (int j = i; j < sArray.length-i-1; j++) {
                if (sArray[j] > sArray[j+1]) {
                    char temp = sArray[j];
                    sArray[j] = sArray[j+1];
                    sArray[j+1] = temp;
                }
            }
        }

        return String.valueOf(sArray);
    }

    /**
     * @params args Not used.
     */
    public static void main(String[] args) {
        
        String testStrings[] = { 
            "abc", "this is not a unique string",
            "chris", "jackie", ""
        };

        //
        // Test hasUniqueChars()
        // 
        System.out.println("\nChecking if unique characters using a buffer...\n");
        for (int i = 0; i < testStrings.length; i++) {
            System.out.print("\"" + testStrings[i] + "\" : ");
            if (hasUniqueChars(testStrings[i])) {
                System.out.println("UNIQUE CHARS");
            } else {
                System.out.println("NOT UNIQUE CHARS");
            }
        }
        
        //
        // Test hasUniqueChars2()
        // 
        System.out.println("\nChecking if unique characters without using a buffer...\n");
        for (int i = 0; i < testStrings.length; i++) {
            System.out.print("\"" + testStrings[i] + "\" : ");
            if (hasUniqueChars2(testStrings[i])) {
                System.out.println("UNIQUE CHARS");
            } else {
                System.out.println("NOT UNIQUE CHARS");
            }
        }
    }
}
