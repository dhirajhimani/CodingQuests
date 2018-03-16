package hackerrank;

import static hackerrank.PrintTreeLevelWise.*;

// TODO - Also do calculate Left and Right Tree Height
public class HeightOFTree {

    public static void main(String[] args) {
        System.out.println(getHeight(createDummyTree()));
        // One more solution
        System.out.println(new HeightOFTree().height(createDummyTree()));
    }

    public static int getHeight(Node root){
        if (root == null){
            return -1;
        }
        else{
            return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
        }
    }

    int max = 0;
    int count = -1;
    int height(Node root) {
        // Write your code here.
        traverseTree(root);
        return max;
    }

    void traverseTree(Node root) {
        count++;
        if (root.left != null) {
            traverseTree(root.left);
            count--;
        }

        if (root.right != null) {
            traverseTree(root.right);
            count--;
        }
        if (root.left == null && root.right == null) {
            if(count > max) {
                max = count;
            }
        }

    }

}
