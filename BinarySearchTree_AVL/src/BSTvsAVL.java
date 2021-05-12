import java.util.Random;
import java.lang.Math;

public class BSTvsAVL {

    /**
     * testing avl and bst trees
     * @param args
     */
    public static void main(String[] args) {
        int value;

        //making 2 arrays of size 100 to keep nodes of BST and AVL trees
        BST[] arrayOfBST = new BST[100];
        AVL[] arrayOfAVL = new AVL[100];

        //define Random to generate random numbers
        Random rand = new Random();

        //adding 100 BST and 100 AVL trees to their arrays
        for (int i = 0; i < 100; i++) {

            arrayOfBST[i] = new BST();
            arrayOfAVL[i] = new AVL();

        }

        //testing for the average, min, max tree heights
        //first we need to make a loop for adding 65536 items
        for (int j = 1; j < 65537; j++) {

            //adding a random number for every 2 BST, AVL trees to make every two identical in terms of
            //values
            for (int i = 0; i < 100; i++) {
                value = rand.nextInt(100000);
                arrayOfBST[i].root = arrayOfBST[i].insert(arrayOfBST[i].root, value);
                arrayOfAVL[i].root = arrayOfAVL[i].insert(arrayOfAVL[i].root, value);
            }

            //when size of trees gets more than 1024 for all powers of 2 we calculate min, max, avg height
            if ((Math.log(j) / Math.log(2)) % 1 == 0 && j > 1023) {
                // System.out.println(j);

                int bstHeight=0;
                int avlHeight=0;
                int bstmax=0;
                int avlmax=0;
                int bstmin=100000;
                int avlmin=100000;

                //tracking the heights for all trees
                for (int k = 0; k < 100; k++) {

                    bstHeight += arrayOfBST[k].height(arrayOfBST[k].root);
                    avlHeight += arrayOfAVL[k].height(arrayOfAVL[k].root);

                    bstmax = Math.max(bstmax, arrayOfBST[k].height(arrayOfBST[k].root));
                    avlmax = Math.max(avlmax, arrayOfAVL[k].height(arrayOfAVL[k].root));
                    bstmin = Math.min(bstmin, arrayOfBST[k].height(arrayOfBST[k].root));
                    avlmin = Math.min(avlmin, arrayOfAVL[k].height(arrayOfAVL[k].root));
                }

                //printing the results
                System.out.println("BSTDepth is "+bstHeight/100);
                System.out.println("AVLDepth is "+avlHeight/100);
                System.out.println("BSTMax is "+bstmax);
                System.out.println("AVLMax is "+avlmax);
                System.out.println("BSTMin is "+bstmin);
                System.out.println("AVLMin is "+avlmin);
                System.out.println("  ");
            }
        }


        long bstsearch=0;
        long avlsearch=0;
        long avgbst=0;
        long avgavl=0;

        //testing for number of searches, we search for 1 million different integers
        //every 100,000 searches I track the average number of searches for both AVL and BST trees
            for (int numSearch = 1; numSearch < 10; numSearch++){

                value = rand.nextInt(1000);

                for (int k = 0; k < 100; k++) {

                    bstsearch = arrayOfBST[k].search(arrayOfBST[k].root, value);
                    avlsearch = arrayOfAVL[k].search(arrayOfAVL[k].root, value);

                    avgbst = (bstsearch + (numSearch - 1) * avgbst) / (numSearch);
                    avgavl = (avlsearch + (numSearch - 1) * avgavl) / (numSearch);

                }

                //printing the results
                if (numSearch % 1 == 0) {

                    System.out.println("Average BST is " + avgbst);
                    System.out.println("Average AVL is " + avgavl);

                }
            }


    }

}
