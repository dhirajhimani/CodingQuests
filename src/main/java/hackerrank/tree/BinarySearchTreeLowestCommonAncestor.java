package hackerrank.tree;

import static hackerrank.tree.BTreePrinterTest.*;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem

public class BinarySearchTreeLowestCommonAncestor {

    public static void main(String[] args) {
        Node rootTest1 = binaryTreeTestData1();

        BTreePrinter.printNode(rootTest1);

//        System.out.println(getParent(rootTest1, 4).data);
//        System.out.println(getParent(rootTest1, 2).data);
//        System.out.println(getParent(rootTest1, 7).data);
//        System.out.println(getParent(rootTest1, 1).data);
//        System.out.println(getParent(rootTest1, 3).data);
//        System.out.println(getParent(rootTest1, 6).data);
//        System.out.println(getParent(rootTest1, 8).data);

        System.out.println(lca(rootTest1, 1,2).data);
    }

    static Node lca(Node<Integer> root, int v1, int v2) {
        if (root == null) {
            return null;
        }
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }
        if (root.data > v1 && root.data > v2) {
            return lca(root.right, v1, v2);
        }
       return root;
    }


//    static Node getParent(Node<Integer> root, int val) {
//        Node parent;
//        if (root.data == val) {
//            return root;
//        }
//        if(((root.left != null && root.left.data == val) ||
//                (root.right != null && root.right.data == val))) {
//            return root;
//        }
//        if (val < root.data){
//            parent = getParent(root.left, val);
//        } else {
//            parent = getParent(root.right, val);
//        }
//
//        return parent;
//    }


}
