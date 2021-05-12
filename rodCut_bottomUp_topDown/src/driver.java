import java.util.Arrays;
import java.util.Random;


public class driver {
    public static long startTime;
    public static long finishTime;


    /**
     * Main function to call our 3 functions
     * @param args
     * @throws IllegalArgumentException
     */
    public static void main(String[] args ){

        driver drive=new driver();
        cut_rod cut=new cut_rod();

        //parameters to save the return values of methods
        int r1;
        int r2;
        int r3;
        //arrays to save the results of eaxch method
        int res1[]=new int[100000];
        int res2[]=new int[100000];
        int res3[]=new int[100000];
        Random random= new Random();
        int[] myArray=new int[100000];
        //saving the time laps for each method
        long[] timeNavive=new long[100000];
        long[] timeTop=new long[100000];
        long[] timeBot =new long[100000];


        for (int j=0;j<100000;j++){
            timeNavive[j]=0;
            timeTop[j]=0;
            timeBot[j]=0;
            res1[j]=0;
            res2[j]=0;
            res3[j]=0;
            //filling element array by 100 random values between 1-20
            myArray[j]=(random.nextInt(20)+1);
        }

        //printing the element array
        System.out.println(Arrays.toString(myArray));


        /**

        //calling methods to calculate max price for elements
        for (int j=1;j<100001;j++){

            r1=cut.naive(myArray,j);
            startTime = System.nanoTime();
            r1=cut.naive(myArray,j);
            finishTime=System.nanoTime();

            res1[j-1]=r1;

            //if function takes more than 60 stop
            if ((finishTime-startTime)>60*Math.pow(10,9)){
                break;
            }
            //getting micro seconds
            timeNavive[j-1]=(finishTime-startTime)/1000;
            System.out.println(timeNavive[j-1]);

        }
        */

        //calling methods to calculate max price for elements
        for (int j=1;j<100001;j++){

            r2=cut.bottomUp(myArray,j);
            startTime = System.nanoTime();
            r2=cut.bottomUp(myArray,j);
            finishTime=System.nanoTime();

            res2[j-1]=r2;
            if ((finishTime-startTime)>60*Math.pow(10,9)){
                break;
            }
            //getting micro seconds
            timeBot[j-1]=(finishTime-startTime)/1000;

            if (j%1000==0){
            System.out.println(timeBot[j-1]);}

        }


        System.out.println(' ');

        //calling methods to calculate max price for elements
        for (int j=1;j<100001;j++){

            r3=cut.topDown(myArray,j);
            startTime = System.nanoTime();
            r3=cut.topDown(myArray,j);
            finishTime=System.nanoTime();

            res3[j-1]=r3;

            if ((finishTime-startTime)>60*Math.pow(10,9)){
                break;
            }
            //getting micro seconds
            timeTop[j-1]=(finishTime-startTime)/1000;
            if (j%1000==0){
            System.out.println(timeTop[j-1]);}
        }

        //printing out results
        System.out.println("Time table for Naive in ms:");
        System.out.println(Arrays.toString(timeNavive));
        System.out.println("Time table for Bottom Up in ms:");
        System.out.println(Arrays.toString(timeBot));
        System.out.println("Time table for Top Down in ms:");
        System.out.println(Arrays.toString(timeTop));

        System.out.println("Results in Naive:");
        System.out.println(Arrays.toString(res1));
        System.out.println("Results in Bottom Up:");
        System.out.println(Arrays.toString(res2));
        System.out.println("Results in Top Down:");
        System.out.println(Arrays.toString(res3));
    }


}
