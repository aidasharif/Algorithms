public class item {

    int length;
    String S;
    long timebf;
    long timebmhs;
    long timesa;

    public item(String word, long t1, long t2, long t3){

        this.length=word.length();
        this.S=word;
        this.timebf=t1;
        this.timebmhs=t2;
        this.timesa=t3;

    }
}
