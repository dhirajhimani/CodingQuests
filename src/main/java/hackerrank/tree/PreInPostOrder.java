package hackerrank.tree;

public class PreInPostOrder {

    public static void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.left);

        printPostorder(node.right);

        System.out.print(node.data + " ");
    }

    public static void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);

        System.out.print(node.data + " ");

        printInorder(node.right);
    }

    public static void printPreorder(Node node)
    {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        printPreorder(node.left);

        printPreorder(node.right);
    }


}
