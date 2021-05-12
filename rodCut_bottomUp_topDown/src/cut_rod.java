
public class cut_rod {
    public static long startTime;
    public static long finishTime;


    /**
     * Naive method calculating the rod cut
     * @param p price array
     * @param n number of element to calculate
     * @return the max price
     */
    public int naive(int[] p, int n){

        int q;

        if (n<=0){
            return 0;
            }
        q=-1;

        for (int i=0;i<n;i++){
            q=Math.max(q,p[i]+ naive(p,n-i-1));
        }
        return q;
    }


    /**
     * top down method calculating the rod cut
     * @param p price array
     * @param n number of element to calculate
     * @return the max price
     */
    public int topDown(int[] p, int n){

        int[] memory = new int[n + 1];
        memory[0] = 0;

        for (int k = 1; k < n + 1; k++) {
            memory[k] = -1;
        }

        return aux(p, n, memory);

    }


    /**
     *
     * @param p price array
     * @param n number of element to calculate
     * @param memory array to save prices
     * @return the max price
     */
    private int aux(int[]p, int n, int[]memory){

        int q=0;

        //if already exists return it
        if (memory[n]>=0){
            return memory[n];
        }

        //when gets to 0 returns 0
        if (n<=0){
            q=0;
        }

        else{
            q=-1;

            //calling different values of n and saving the max value in q
            for (int i=0;i<n;i++){

                q=Math.max(q,p[i]+ aux(p, n-i-1,memory));
                //System.out.println(memory[i]);
            }

            memory[n]=q;
        }

        //System.out.println(memory[n]);
        return memory[n];
    }


    /**
     * top down method calculating the rod cut
     * @param p price array
     * @param n number of element to calculate
     * @return the max price
     */
    public int bottomUp(int[] p, int n){

        int[] memory= new int[n+1];
        memory[0]=0;


        //initializing array with -1
        for (int i=1;i<=n;i++){
            int q=-1;

            //getting the max value by checking all combinations less than n
            for (int j=0;j<i;j++){

                q=Math.max(q,p[j]+ memory[i-j-1]);
            }

            //saving each new length price
            memory[i]=q;
            //System.out.println(memory[i]);


        }
        //System.out.println(memory[n]);
        return memory[n];
    }


}
