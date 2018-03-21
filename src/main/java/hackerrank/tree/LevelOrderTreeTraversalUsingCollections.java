package hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeTraversalUsingCollections {

    private static Queue<Node> queue = new LinkedList<Node>();

    public static void levelOrder(Node root){
        if( root != null ){
            queue.add(root);
        }
        while( !queue.isEmpty() ){
            Node tree = queue.remove();
            System.out.print(tree.data + " ");

            if( tree.left != null ){
                queue.add( tree.left );
            }
            if( tree.right != null ){
                queue.add( tree.right );
            }
        }
    }

    private static Node createDummyTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        return root;
    }


    public static void main(String[] args) {
        Node root = createDummyTree();

        levelOrder(root);

    }
}

