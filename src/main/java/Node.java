/**
 * Created by Richard on 09/11/2015.
 */
public class Node {
    private final String key;
    private Object value;
    private Node left;
    private Node rightNode;

    public Node(String key, Object value) {
       this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Node getLeftNode() {
        return left;
    }

    public void setLeftNode(Node left) {
        this.left = left;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
