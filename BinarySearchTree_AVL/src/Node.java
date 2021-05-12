public class Node {

    int key;
    Node left, right;
    int height;

    public Node(int item) {
        key = item;
        left = right = null;
        height=1;
    }
}

