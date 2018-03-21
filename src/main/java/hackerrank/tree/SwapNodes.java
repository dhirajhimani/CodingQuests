package hackerrank.tree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem

public class SwapNodes {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BNodeChild[] bNodeChildren = new BNodeChild[N];
        final int totalValues = N;
        while (N > 0) {
            bNodeChildren[totalValues - N] = new BNodeChild(scanner.nextInt(), scanner.nextInt());
            N--;
        }

        Node root = createTreebyBNodes(bNodeChildren);
//        BTreePrinter.printNode(root);
        int T = scanner.nextInt();
        int[] depths = new int[T];
        int count = 0;
        while (T > 0) {
            depths[count++] = scanner.nextInt();
            T--;
        }
        startSwappingNodes(root, depths);
    }

    private static Node createTreebyBNodes(BNodeChild[] bNodeChildren) {
        Node<Integer> root = new Node<Integer>(1);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        for (BNodeChild bNodeChild: bNodeChildren) {
            addChildToTree(queue, root, bNodeChild.leftVal, bNodeChild.rightVal);
        }
        return root;
    }


    private static void addChildToTree(Queue<Node> queue, Node<Integer> root, int leftVal, int rightVal) {
        Node node = queue.poll();

        if (leftVal != -1) {
            Node leftNode = new Node(leftVal);
            node.left = leftNode;
            queue.add(leftNode);
        }

        if (rightVal != -1) {
            Node rightNode = new Node(rightVal);
            node.right = rightNode;
            queue.add(rightNode);
        }
    }

    private static void startSwappingNodes(Node<Integer> root, int[] depths) {
        for (int depth : depths) {
            swapTreeNode(root, depth);
//            BTreePrinter.printNode(root);
            PreInPostOrder.printInorder(root);
            System.out.println();
        }
    }

    private static void swapTreeNode(Node<Integer> root, int depth) {
        int depthTree = HeightOFTree.getHeight(root);
        for (int i = depth; i <= depthTree; i += depth) {
            swapTreeNodeDepthWise(root, i);
        }
    }

    private static void swapTreeNodeDepthWise(Node<Integer> root, int depth) {
        if (root == null)
            return;
        if (depth == 1) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (depth > 1) {
            swapTreeNodeDepthWise(root.left, depth - 1);
            swapTreeNodeDepthWise(root.right, depth - 1);
        }
    }

    private static class BNodeChild {
        int leftVal;
        int rightVal;

        public BNodeChild(int leftVal, int rightVal) {
            this.leftVal = leftVal;
            this.rightVal = rightVal;
        }
    }
}
