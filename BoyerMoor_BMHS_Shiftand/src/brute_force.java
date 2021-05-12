import java.util.Scanner;

public class brute_force {

    /**
     * return offset of first match or n if no match
     * @param pat
     * @param txt
     * @return -1 if not found
     */
        public static int search1(String pat, String txt) {
            int m = pat.length();
            int n = txt.length();

            for (int i = 0; i <= n - m; i++) {
                int j;
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }
                if (j == m) return i;            // found at offset i
            }
            return -1;                            // not found
        }

}
