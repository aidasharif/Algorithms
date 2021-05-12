import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class driver {

    public int searchsa(File file,String pattern){

        shiftand sa=new shiftand();
        int result;
        int count=0;
        String s;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                s = scanner.next();
                //System.out.println(s);
                result=sa.findPattern(pattern,s.toLowerCase());
                if (result!=-1){
                    //System.out.println("text is: "+s);
                    count++;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println("Count is: "+count);
        return count;

    }

    public int searchbf(File file,String pattern){

        brute_force bf=new brute_force();
        int result;
        int count=0;
        String s;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                s = scanner.next();
                //System.out.println(s);
                result=bf.search1(pattern,s.toLowerCase());
                if (result!=-1){
                    count++;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return count;

    }


    public int searchbmhs2(File file,String pattern){

        bmhs bm=new bmhs(pattern);
        int result;
        int count=0;
        String s;


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                s = scanner.next();
                //System.out.println(s);
                result=bm.search(s.toLowerCase());
                if (result!=-1){
                    //System.out.println(s);
                    count++;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println(count);
        return count;

    }

    /**
     *
     * @param args
     */
    public static void main (String[] args){

        driver driver1=new driver();
        List <String> patterns = new ArrayList<>();
        List <item> tested_words = new ArrayList<>();

        Random random = new Random();
        String pattern="";
        int test_number=0;
        int resultbf;
        int resultsa;
        int resultbmhs;
        String s;
        item item;
        long Timebf=0;
        long Timesa=0;
        long Timebmhs=0;
        long startTime=0;
        long endTime=0;
        int upto=0;


        File file1 = new File("/Users/aidasharifrohani/Desktop/hw6b.txt");
        File file2 = new File("/Users/aidasharifrohani/Desktop/pattern.txt");

        try {
            Scanner scanner = new Scanner(file2);
            while (scanner.hasNext()) {
                s = scanner.next();
                patterns.add(s);
                //System.out.println(s);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (test_number<1000){

            pattern = patterns.get(random.nextInt(patterns.size())).toLowerCase();


            if(pattern.length()<=10 && pattern.length()>=1){
                upto++;

                if (upto%10==0){
                    System.out.println("up to is: " + upto);

                }
                System.out.println("pattern is: " + pattern);
                //result=driver1.searchbmhs(file1,pattern);


                startTime = System.nanoTime();
                resultbf=driver1.searchbf(file1,pattern);
                endTime= System.nanoTime();

                Timebf=(endTime-startTime)/1000;


                startTime = System.nanoTime();
                resultbmhs=driver1.searchbmhs2(file1,pattern);
                endTime= System.nanoTime();

                Timebmhs=(endTime-startTime)/1000;

                startTime = System.nanoTime();
                resultsa=driver1.searchsa(file1,pattern);
                endTime= System.nanoTime();

                Timesa=(endTime-startTime)/1000;


                //System.out.println("count is: "+result);
                item=new item(pattern,Timebf,Timebmhs,Timesa);
                test_number++;
                tested_words.add(item);
            }

        }


        for (int j=0;j<tested_words.size();j++){

            System.out.println(tested_words.get(j).S);
        }

        System.out.println("\n\n\n\n");



        for (int j=0;j<tested_words.size();j++){

            System.out.println(tested_words.get(j).S.length());
        }


        System.out.println("\n\n\n\n");

        for (int j=0;j<tested_words.size();j++){

            System.out.println(tested_words.get(j).timebf);

        }


        System.out.println("\n\n\n\n");


        for (int j=0;j<tested_words.size();j++){

            System.out.println(tested_words.get(j).timebmhs);
        }

        System.out.println("\n\n\n\n");


        for (int j=0;j<tested_words.size();j++){

            System.out.println(tested_words.get(j).timesa);
        }


    }
}
