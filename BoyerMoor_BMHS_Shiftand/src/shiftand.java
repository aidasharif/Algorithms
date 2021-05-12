

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class shiftand {

    /** function findPattern **/
    public int findPattern(String pat,String txt) {

        char[] txt1=txt.toCharArray();
        for (int i=0; i<txt1.length;i++){
            if(((int)txt1[i])>256) {
                txt1[i]=(char)39;
            }
        }
        txt=String.valueOf(txt1);

        int[] B = new int[256]; // zero filled by default

        for (int j = 0; j < pat.length(); j++) {
            B[(int) pat.charAt(j)] = B[(int) pat.charAt(j)] | (1 << j);
        }

        int D = 0;

        for (int i = 0; i < txt.length(); i++) {
            D = ((D << 1) | 1) & B[(int) txt.charAt(i)];
            if ((D & (1 << (pat.length()-1))) != 0) {
                //System.out.println("Pattern found at position " + (i-pat.length()+1));
                return 0;
            }
        }

        //System.out.println("Not found!");
        return -1;
    }

}