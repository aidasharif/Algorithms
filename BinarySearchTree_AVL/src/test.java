
public class test {

    /**
     * testing avl and bst trees
     * @param args
     */
    public static void main(String[] args) {

        //making 2 arrays of size 100 to keep nodes of BST and AVL trees
        BST[] arrayOfBST = new BST[100];
        AVL[] arrayOfAVL = new AVL[100];

        System.out.println("'aida'");

        arrayOfBST[0] = new BST();
        arrayOfAVL[0] = new AVL();

        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, 5);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, 4);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, 3);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, 2);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, 1);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, 0);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, -1);
        System.out.println(arrayOfAVL[0].root.key);
        arrayOfAVL[0].root = arrayOfAVL[0].insert(arrayOfAVL[0].root, -2);
        System.out.println(arrayOfAVL[0].root.key);

    }



}
