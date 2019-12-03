package tests.ast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import leather.ast.Node;
import leather.ast.Tree;
import java.util.Queue;

class TreeTest {

    @Test
    void toQueuePreOrderDfsBinary()
    {
        //First test
        char[] expectedOutput = new char[]{'D', 'B', 'A', 'C', 'E', 'F'};
        Queue<Node<Character>> actualOutput = makeTestTreeOne().toQueuePreOrderDFS();

        assertEquals(expectedOutput.length, actualOutput.size());
        testContent(expectedOutput, actualOutput);
    }

    @Test
    void toQueuePreOrderDfsNonBinary()
    {
        //First test
        char[] expectedOutput = new char[]{'D', 'B', 'A', 'C', 'G', 'E', 'F', 'H'};
        Queue<Node<Character>> actualOutput = makeTestTreeTwo().toQueuePreOrderDFS();

        assertEquals(expectedOutput.length, actualOutput.size());
        testContent(expectedOutput, actualOutput);
    }

    @Test
    void toQueuePostOrderDfsBinary()
    {
        //First test
        char[] expectedOutput = new char[]{'A', 'C', 'B', 'F', 'E', 'D'};
        Queue<Node<Character>> actualOutput = makeTestTreeOne().toQueuePostOrderDFS();

        assertEquals(expectedOutput.length, actualOutput.size());
        testContent(expectedOutput, actualOutput);
    }

    @Test
    void toQueuePostOrderDfsNonBinary()
    {
        //First test
        char[] expectedOutput = new char[]{'A', 'C', 'G', 'B', 'H', 'F', 'E', 'D'};
        Queue<Node<Character>> actualOutput = makeTestTreeTwo().toQueuePostOrderDFS();

        assertEquals(expectedOutput.length, actualOutput.size());
        testContent(expectedOutput, actualOutput);
    }

    Tree<Character> makeTestTreeOne()
    {
        Tree<Character> testTree = new Tree<>('D');
        Node<Character> root = testTree.getRoot();
        root.addChild('B');
        root.addChild('E');
        root.getFirstChild().addChild('A');
        root.getFirstChild().addChild('C');
        root.getChildAtIndex(1).addChild('F');

        return testTree;
    }

    Tree<Character> makeTestTreeTwo()
    {
        Tree<Character> testTree = new Tree<>('D');
        Node<Character> root = testTree.getRoot();
        root.addChild('B');
        root.addChild('E');
        root.getFirstChild().addChild('A');
        root.getFirstChild().addChild('C');
        root.getFirstChild().addChild('G');
        root.getChildAtIndex(1).addChild('F');
        root.getChildAtIndex(1).getFirstChild().addChild('H');

        return testTree;
    }


    void testContent(char[] expected, Queue<Node<Character>> actual)
    {
        for(int i = 0; i < expected.length; i++)
        {
            assertEquals(actual.remove().getData(), expected[i]);
        }
    }
}