package hackerrank.tree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem

// https://github.com/dhirajhimani/CodingQuests/blob/master/src/main/java/hackerrank/tree/SwapNodes.java

public class SwapNodes {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        NodeLeftRightVal[] vals = readNodeVals(scanner);
        Node root = createTreebyBNodes(vals);
//        BTreePrinter.printNode(root);
        int[] depths = getDepthsOfTreeToSwap(scanner);
        startSwappingNodesAndPrintInorder(root, depths);
        scanner.close();
    }

    private static NodeLeftRightVal[] readNodeVals(Scanner scanner) {
        final int totalValues = scanner.nextInt();
        int counter = totalValues;
        NodeLeftRightVal[] vals = new NodeLeftRightVal[totalValues];
        while (counter > 0) {
            int index = totalValues - counter;
            vals[index] = new NodeLeftRightVal(scanner.nextInt(), scanner.nextInt());
            counter--;
        }
        return vals;
    }

    private static Node createTreebyBNodes(NodeLeftRightVal[] leftRightVals) {
        Node<Integer> root = new Node<Integer>(1);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        for (NodeLeftRightVal leftRightVal: leftRightVals) {
            addChildToTree(queue, root, leftRightVal.leftVal, leftRightVal.rightVal);
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

    private static int[] getDepthsOfTreeToSwap(Scanner scanner) {
        int N = scanner.nextInt();
        int[] depths = new int[N];
        int count = 0;
        while (N > 0) {
            depths[count++] = scanner.nextInt();
            N--;
        }
        return depths;
    }

    private static void startSwappingNodesAndPrintInorder(Node<Integer> root, int[] depths) {
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

    private static class NodeLeftRightVal {
        int leftVal;
        int rightVal;

        public NodeLeftRightVal(int leftVal, int rightVal) {
            this.leftVal = leftVal;
            this.rightVal = rightVal;
        }
    }


}
