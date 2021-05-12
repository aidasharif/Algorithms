public class AVL {

    Node root;
    long comparisons;

    /**
     * constructor
     */
    public AVL() {
        root = null;
        comparisons=0;
    }

    /**
     *Inserting the new key into the tree
     * @param node
     * @param key
     * @return the node pointer
     */
    public Node insert(Node node, int key) {

        //first we insert the key the same way as BST
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key){
            node.right = insert(node.right, key);
        }
        else
            return node;

        //updating the height of ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        //checking if the ancestor got imbalanced
        int balance = balance(node);

        // in case it's imbalanced we considar these 4 cases:
        if (balance > 1 && key < node.left.key)
            return rotateright(node);

        if (balance < -1 && key > node.right.key)
            return rotateleft(node);

        if (balance > 1 && key > node.left.key) {
            node.left = rotateleft(node.left);
            return rotateright(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateright(node.right);
            return rotateleft(node);
        }

        //returning the node
        return node;
    }


    /**
     *getting the maximum value of the tree (it's not used in this HW)
     * @param node
     * @return the max value
     */
    public int maxValue(Node node) {
        /* loop down to find the rightmost leaf */
        Node current = node;
        while (current.right != null)
            current = current.right;

        return (current.key);
    }

    /**
     *getting the minimum value of the tree (it's not used in this HW)
     * @param node
     * @return the min value
     */
    public int minValue(Node node) {
        /* loop down to find the rightmost leaf */
        Node current = node;
        while (current.left != null)
            current = current.left;

        return (current.key);
    }

    /**
     *searching for a new value in the tree
     * @param root
     * @param key
     * @return the number of comparisons
     */
    public long search(Node root, int key) {

        comparisons++;
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return comparisons;

        // val is greater than root's key
        if (root.key > key)
            return search(root.left, key);

        // val is less than root's key
        return search(root.right, key);
    }

    /**
     *getting the height of the tree
     * @param N
     * @return the height of the tree
     */
    public int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }


    /**
     * rotating the subtree right
     * @param y
     * @return the new root
     */
    private Node rotateright(Node y) {
        Node x = y.left;
        Node z = x.right;

        // Perform rotation
        x.right = y;
        y.left = z;

        // updating the heights for y and x
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /**
     * rotating the subtree left
     * @param x
     * @return the new root
     */
    public Node rotateleft(Node x) {
        Node y = x.right;
        Node z = y.left;

        // Perform rotation
        y.left = x;
        x.right = z;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }


    /**
     * getting the balance for the tree
     * @param N
     * @return the balance value
     */
    private int balance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    /**
     *getting the maximum of 2 values
     * @param a
     * @param b
     * @return the max
     */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

}
