package hackerrank;

// This solution is only for balanced binary tree.
public class TopViewTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }


    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
//        root.right.right.right = new Node(9);

        root.right.left.right.right = new Node(10);
        root.right.left.right.right.right = new Node(11);

        System.out.println("Top View of Tree is");
        topView(root);
    }

    static void topView(Node root)
    {
        left_view(root.left);
        System.out.print(root.data + " ");
        right_view(root.right);
    }

    static void left_view(Node root) {
        if (root == null) return;
        left_view(root.left);
        System.out.print(root.data + " ");
    }

    static void right_view(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        right_view(root.right);
    }
}
