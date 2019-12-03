package leather;

import leather.ast.Node;
import leather.ast.Tree;
import leather.lex.Lexer;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        //Lexer lexer = new Lexer();
        //lexer.lex("examples/HelloWorld.lt");

        Tree<String> testTree = new Tree<String>("D");
        testTree.getRoot().addChild("B");
        testTree.getRoot().addChild("E");
        testTree.getRoot().getFirstChild().addChild("A");
        testTree.getRoot().getFirstChild().addChild("C");
        testTree.getRoot().getChildAtIndex(1).addChild("F");



        Queue<Node<String>> q = testTree.PostOrderDFSTraversal();

        for(Node<String> node : q)
        {
            System.out.println(node.getData());
        }
    }
}
