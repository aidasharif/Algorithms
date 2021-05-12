
public class BST {

    Node root;
    long comparisons;

    /**
     *constructor
     */
    public BST() {
        root = null;
        comparisons=0;
    }

    /**
     *Inserting a new key into the BST
     * @param root
     * @param key
     * @return
     */
    public Node insert(Node root, int key) {

        //If the tree is empty, it makes a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        //if there is a root it traverses through
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        //returns the node
        return root;
    }

    /**
     *Searching for a key
     * @param root
     * @param key
     * @return the number of comparisons to reach to the key
     */
    public long search(Node root, int key) {

        comparisons++;
        // when root is null or is the key
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
     * @param node
     * @return the height of the tree
     */
    public int height(Node node) {
        if (node == null)
            return 0;
        else
        {
            //calculating the depth of subtrees
            int leftdepth = height(node.left);
            int rightdepth = height(node.right);

            /* use the larger one */
            if (leftdepth > rightdepth)
                return (leftdepth + 1);
            else
                return (rightdepth + 1);
        }
    }

    /**
     *getting the maximum value of the tree (it's not used in this HW)
     * @param node
     * @return the maximum value in tree
     */
    public int maxValue(Node node) {

        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return (current.key);
    }

    /**
     *getting the minimum value of the tree (it's not used in this HW)
     * @param node
     * @return the min value in tree
     */
    public int minValue(Node node) {
        /* loop down to find the rightmost leaf */
        Node current = node;
        while (current.left != null)
            current = current.left;

        return (current.key);
    }


}

