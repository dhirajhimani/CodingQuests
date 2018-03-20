package hackerrank.tree;

import static hackerrank.tree.BTreePrinterTest.test1;
import static hackerrank.tree.PrintTreeLevelWise.*;

// TODO - Also do calculate Left and Right Tree Height
public class HeightOFTree {

    public static void main(String[] args) {

        Node rootTest1 = test1();

        BTreePrinter.printNode(rootTest1);
        System.out.println("Full Tree Height -> " + getHeight(rootTest1));
        System.out.println("Left Tree Height -> " + (getTreeLeftPartHeight(rootTest1) + 1));
        System.out.println("Right Tree Height -> " + (getTreeRightPartHeight(rootTest1) + 1));


//        BTreePrinter.printNode(BTreePrinterTest.test1());
//        System.out.println(getHeight(BTreePrinterTest.test1()));



        // One more solution
        System.out.println(new HeightOFTree().height(test1()));


    }

    public static int getHeight(Node root){
        if (root == null){
            return -1;
        }
        else{
            return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
        }
    }

    public static int getTreeLeftPartHeight(Node root) {
        return getHeight(root.left);
    }

    public static int getTreeRightPartHeight(Node root) {
        return getHeight(root.right);
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
