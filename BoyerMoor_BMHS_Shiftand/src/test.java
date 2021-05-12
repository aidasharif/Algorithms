import java.io.File;
import java.util.Random;

public class test {


    public void searchbf(File file,String pattern){

        brute_force bf=new brute_force();
        int result;
        int count=0;
        String s;

    }

    public int searchbmhs2(){

        BoyerMoore bm=new BoyerMoore("aida");
        int result;
        int count=0;
        String s;

        result=bm.search("of");
        if (result!=-1){
            System.out.println(result);
        }


        return count;

    }


    public int searchbmhs3(){

        bmhs bm=new bmhs("aida");
        int result;
        int count=0;
        String s;


        result=bm.search("aidaefcfredaida");
        if (result!=-1){
            System.out.println(result);
        }


        return count;

    }


    public int search4(){

        shiftand sa=new shiftand();
        int result;
        int count=0;
        String s;

        result=sa.findPattern("descry","whale");
        if (result!=-1){
            System.out.println(result);
        }


        return count;

    }
    public static void main (String[] args){

        test driver1=new test();


        Random random = new Random();
        String pattern="";
        int test_number=0;
        int result;
        String s;
        item item;

        //File file1 = new File("/Users/aidasharifrohani/Desktop/hw6b.txt");
        //File file2 = new File("/Users/aidasharifrohani/Desktop/pattern.txt");


        //result=driver1.search4();
        //result=driver1.searchbmhs2();
        result=driver1.searchbmhs3();


        //System.out.println(count);
    }
}
