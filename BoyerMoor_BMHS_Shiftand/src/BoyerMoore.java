public class BoyerMoore {

    private final int R;     // the radix
    private int[] right;     // the bad-character skip array
    private char[] pattern;  // store the pattern as a character array
    private String pat;      // or as a string


    /**
     * Preprocesses the pattern string.
     * @param pat the pattern string
     */
    public BoyerMoore(String pat) {

        char[] pat1=pat.toCharArray();

        for (int i=0; i<pat1.length;i++){
            if(((int)pat1[i])>256) {
                pat1[i]=(char)39;
            }
        }

        this.pat =String.valueOf(pat1);
        //System.out.println(pat);
        this.R = 256;

        // position of rightmost occurrence of c in the pattern
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pat.length(); j++){
            if (pat.charAt(j)>256 || pat.charAt(j)<0){
            right[39] = j;
            }

            right[pat.charAt(j)] = j;
        }
    }

    /**
     * Returns the index of the first occurrrence of the pattern string
     * in the text string.
     *
     * @param  txt the text string
     * @return the index of the first occurrence of the pattern string
     *         in the text string; n if no such match
     */
    public int search(String txt) {
        char[] txt1=txt.toCharArray();

        for (int i=0; i<txt1.length;i++){
            if(((int)txt1[i])>256) {
                txt1[i]=(char)39;
            }
        }

        txt=String.valueOf(txt1);
        //System.out.println(txt);
        int m = pat.length();
        int n = txt.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                        break;

                }
            }
            if (skip == 0) return i;    // found
        }
        return -1;                       // not found
    }


}