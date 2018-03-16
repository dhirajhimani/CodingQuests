package hackerrank.tree;

public class InsertNodeInBinaryTree {

    public static Node dummyBinaryTree() {
        Node<Integer> root = new Node<Integer>(4);
        Node<Integer> n11 = new Node<Integer>(2);
        Node<Integer> n12 = new Node<Integer>(7);
//        Node<Integer> n21 = new Node<Integer>(1);
        Node<Integer> n22 = new Node<Integer>(3);

        root.left = n11;
        root.right = n12;

//        n11.left = n21;
        n11.right = n22;

        return root;
    }

    public static void main(String[] args) {
        Node root = dummyBinaryTree();
        BTreePrinter.printNode(root);

        Node nodeToInsert = new Node(8);
        insertNode(root, nodeToInsert);
        BTreePrinter.printNode(root);


        nodeToInsert = new Node(6);
        insertNode(root, nodeToInsert);
        BTreePrinter.printNode(root);

        nodeToInsert = new Node(1);
        insertNode(root, nodeToInsert);
        BTreePrinter.printNode(root);
    }

    private static Node insertNode(Node<Integer> root, Node<Integer> nodeToInsert) {
        if (root == null) {
            return nodeToInsert;
        }

        if (nodeToInsert.data < root.data) {
            root.left = insertNode(root.left, nodeToInsert);
        } else {
            root.right = insertNode(root.right, nodeToInsert);
        }
        return root;

    }

}
