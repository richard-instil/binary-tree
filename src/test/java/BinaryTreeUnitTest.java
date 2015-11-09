import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Richard on 09/11/2015.
 */
public class BinaryTreeUnitTest {

    private static String rootNodeKey = "rootNodeKey";
    private BinaryTree target;
    private Node rootNode;

    @Before
    public void setUp() {
        rootNode = new Node(rootNodeKey, null);
        target = new BinaryTree();
    }

    @Test
    public void shouldBeEmptyWhenNoNodes() {
        assertThat(target.isEmpty(), is(true));
    }

    @Test
    public void shouldNotBeEmptyWhenContainsNodes() {
        target.addNode(rootNode);

        assertThat(target.isEmpty(), is(false));
    }

    @Test
    public void shouldGetNodeByKey() {
        target.addNode(rootNode);

        assertThat(target.getNode(rootNodeKey), is(rootNode));
    }

    @Test
    public void shouldAddNodeOnLeftOfRootWhenKeyIsLessThanRoot() {
        Node leftNode = new Node("leftNode", null);

        target.addNode(rootNode);
        target.addNode(leftNode);

        assertThat(rootNode.getLeftNode(), is(leftNode));
    }

    @Test
    public void shouldAddNodeOnRightOfRootWhenKeyIsGreaterThanRoot() {
        Node rightNode = new Node("theKeyIsGreaterThanRoot", null);

        target.addNode(rootNode);
        target.addNode(rightNode);

        assertThat(rootNode.getRightNode(), is(rightNode));
    }
    
    @Test
    public void shouldAddTwoNodesToRootWithKeysLessThanRoot() {
        Node leftNodeOne = new Node("keyLessThanRoot", null);
        Node leftNodeTwo = new Node("aKeyLessThanLeftNodeOne", null);

        target.addNode(rootNode);
        target.addNode(leftNodeOne);
        target.addNode(leftNodeTwo);

        Node firstNodeAdded = target.getNode("keyLessThanRoot");
        assertThat(firstNodeAdded, is(leftNodeOne));
        assertThat(firstNodeAdded.getLeftNode(), is(leftNodeTwo));
    }

    @Test
    public void shouldAddTwoNodesToRootWithFirstKeyLessAndSecondKeyMore() {
        Node leftNodeOne = new Node("keyLessThanRoot", null);
        Node rightNodeTwo = new Node("keyMoreThanFirstNode", null);

        target.addNode(rootNode);
        target.addNode(leftNodeOne);
        target.addNode(rightNodeTwo);

        Node firstNodeAdded = target.getNode("keyLessThanRoot");
        assertThat(firstNodeAdded, is(leftNodeOne));
        assertThat(firstNodeAdded.getRightNode(), is(rightNodeTwo));
    }
}
