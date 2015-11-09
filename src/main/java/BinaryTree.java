/**
 * Created by Richard on 09/11/2015.
 */
public class BinaryTree {

    private Node rootNode;

    public boolean isEmpty() {
        return rootNode == null;
    }

    public void addNode(Node node) {
        if (isEmpty()) {
            rootNode = node;
        } else {
            addNodeToTree(rootNode, node);
        }
    }

    private void addNodeToTree(Node currentNode, Node node) {
        if (isKeyLessThan(node.getKey(), currentNode.getKey())) {
            addNodeToLeftBranch(currentNode, node);
        } else {
            addNodeToRightBranch(currentNode, node);
        }
    }

    private void addNodeToLeftBranch(Node currentNode, Node node) {
        if (currentNode.getLeftNode() == null) {
            currentNode.setLeftNode(node);
        } else {
            addNodeToTree(currentNode.getLeftNode(), node);
        }
    }

    private void addNodeToRightBranch(Node currentNode, Node node) {
        if (currentNode.getRightNode() == null) {
            currentNode.setRightNode(node);
        } else {
            addNodeToTree(currentNode.getRightNode(), node);
        }
    }

    private boolean isKeyLessThan(String key, String keyToCompare) {
        return key.compareToIgnoreCase(keyToCompare) < 0;
    }

    public Node getNode(String key) {
        return findNode(key, rootNode);
    }

    private Node findNode(String key, Node node) {
        if (node.getKey().equals(key)) {
            return node;
        } else if (isKeyLessThan(key, node.getKey())) {
            return findNode(key, node.getLeftNode());
        } else {
            return findNode(key, node.getRightNode());
        }
    }

}
