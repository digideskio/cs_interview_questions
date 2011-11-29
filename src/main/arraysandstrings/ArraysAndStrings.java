package arraysandstrings;

/**
 * @author Chris Arriola
 *
 * Class for Array and String questions
 */
public class ArraysAndStrings {

    /**
     * Checks if a String has unique characters (using a buffer).
     *
     * @param s The string to check
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
     *
     * @param s The string to reverse.
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
     * Reverses a string.
     *
     * @param s The string to reverse.
     */
    public static String reverseString(String s) {
        
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;

        char sArray[] = s.toCharArray();

        // In place reversal - swap both ends until you get to the middle.
        int end = sArray.length-1;
        for (int head = 0; head < sArray.length/2; head++) {
            
            int tail = end-head;

            // Swap front and end
            char temp = sArray[head];
            sArray[head] = sArray[tail];
            sArray[tail] = temp;
        }

        return String.valueOf(sArray);
    }

    /**
     * Removes duplicate characters in a string, in place.
     */
    public static String removeDuplicates(String s) {
        
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;

        // Convert to char array
        char sArray[] = s.toCharArray();

        // Have 2 loops
        // Outer loop looks at each character starting from index 0 until s.length()-1
        int tail = 1;
        for (int curr = 1; curr < sArray.length; curr++) {
            // Inner loop starts from the index outer loop is looking at + 1 and then loops
            // from index 0 until index outer loop is looking at. if that char exists, we
            // overwrite it with the next char over.
            for (int head = 0; head < tail; head++) {
                
                // Not unique character
                if (sArray[curr] == sArray[head]) {
                    break;
                } 

                // Unique character
                if (head == tail-1) {
                    sArray[tail]  = sArray[curr];
                    tail++;
                }
            }
        }
       
        // Get character array before tail 
        String sUnique = String.valueOf(sArray);
        return sUnique.substring(0, tail); 
    }

    /**
     * Checks if 2 strings are anagrams or not.
     */
    public static boolean areAnagrams(String s1, String s2) {

        if (s1 == null || s2 == null)
            return false;

        // Sort s1 and s2, if they are equal, they are anagrams
        String sortedS1 = sortString(s1);
        String sortedS2 = sortString(s2);
        System.out.println("s1 sorted: " + sortedS1 + ", s2 sorted: " + sortedS2);
        return (sortedS1.equals(sortedS2) ? true : false);
    }

    /**
     * Replace all spaces in a string.
     */
    public static String replaceSpaces(String s, String newSpace) {
        
        if (s == null || s.length() == 0)
            return s;  

        // Convert to char array
        char sArray[] = s.toCharArray();
        char sNewArray[];

        // Count spaces in the string.
        int spaceCount = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == ' ')
                spaceCount++;
        }

        // Create a new string that is size (s.length() - spaceCount) + (newSpace.length() * spaceCount)
        sNewArray = new char[(sArray.length-spaceCount) + (newSpace.length()*spaceCount)];

        // Loop through original string, and for each space encountered, copy String newSpace
        int currNew = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == ' ') {
                for (int j = 0; j < newSpace.length(); j++) {
                    sNewArray[currNew++] = newSpace.charAt(j);
                }
            } else {
                sNewArray[currNew++] = sArray[i];
            }
        }

        return String.valueOf(sNewArray);
    }

    /**
     * Rotates a matrix by 90 degree
     */
    public static void rot90(int[][] matrix) {

        if (matrix.length == 0)
            return;

        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {

                // Store top
                int temp = matrix[i][j];

                // left->top
                matrix[i][j] = matrix[n-1-j][i];

                // bottom->left
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];

                // right->bottom
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    
                // top->right
                matrix[j][n-1-i] = temp;
            
            }
        }
    }

    /**
     * If an element is zero, it's row and column will be set to zero.
     */
    public static void setRowAndColToZero(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        // Find elements that are zero and raise a flag
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        // Do a second pass and set the necessary zeroes.
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Sorts a String
     */
    private static String sortString(String s) {
        
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;

        // Convert to char array
        char sArray[] = s.toCharArray();

        // Sort
        for (int i = 0; i < sArray.length; i++) {
            for (int j = 0; j < sArray.length-1-i; j++) {
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
            "chris", "jackie", "", "angel", "angle",
            "glean", "hello world"
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
        
        //
        // Test reverseString()
        // 
        System.out.println("\nReversing strings...\n");
        for (int i = 0; i < testStrings.length; i++) {
            System.out.print("\"" + testStrings[i] + "\" : ");
            System.out.println(reverseString(testStrings[i]));
        }

        //
        // Test removeDuplicates()
        // 
        System.out.println("\nRemoving duplicates in the String...\n");
        for (int i = 0; i < testStrings.length; i++) {
            System.out.print("\"" + testStrings[i] + "\" : ");
            System.out.println(removeDuplicates(testStrings[i]));
        }
        
        //
        // Test areAnagrams()
        // 
        System.out.println("\nChecking if 2 strings are anagrams...\n");
        for (int i = 0; i < testStrings.length-1; i++) {
            System.out.print("\"" + testStrings[i] + "\" & \"" + testStrings[i+1] + "\" : ");
            System.out.println(areAnagrams(testStrings[i], testStrings[i+1]));
        }

        //
        // Test replaceSpaces()
        // 
        System.out.println("\nReplaces spaces...\n");
        for (int i = 0; i < testStrings.length; i++) {
            System.out.print("\"" + testStrings[i] + "\" : ");
            System.out.println(replaceSpaces(testStrings[i], "%20"));
        }

        //
        // Test rot90()
        //
        int array[][] = {
            { 1,   2,  3,  4 },
            { 5,   6,  7,  8 },
            { 9,  10, 11, 12 },
            { 13, 14, 15, 16 }
        };
        
        // Original
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("\t" + array[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Rotated by 90 degrees
        rot90(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("\t" + array[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        //
        // Test setRowAndColToZero()
        //
        int array2[][] = {
            { 0,   2,  3,  4 },
            { 5,   6,  7,  8 },
            { 9,  10,  0, 12 },
            { 13, 14, 15, 16 }
        };

        // Original
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                System.out.print("\t" + array2[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Row and column zeroed
        setRowAndColToZero(array2);
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                System.out.print("\t" + array2[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
