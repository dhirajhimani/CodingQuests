package hackerrank.tree;

// https://www.hackerrank.com/challenges/tree-huffman-decoding/problem

public class TreeHuffmanDecoding {

    void decode(String S ,Node root)
    {
        StringBuilder decodedString = new StringBuilder();
        Node node = root;

        for(int i = 0; i < S.length(); i++) {
            node = S.charAt(i) == '1' ? node.right : node.left;
            // if traversed to leaf, print it.
            if(node.left == null && node.right == null) {
                decodedString.append(node.data);
                node = root;
            }
        }
        System.out.println(decodedString);
    }
}
