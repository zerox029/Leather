package leather;

import leather.ast.Tree;
import leather.lex.Lexer;

public class Main {

    public static void main(String[] args) {
        //Lexer lexer = new Lexer();
        //lexer.lex("examples/HelloWorld.lt");

        Tree<String> testTree = new Tree<String>("Root");
        testTree.getRoot().addChild("Child 1");
        testTree.getRoot().addChild("Child 2");
        testTree.getRoot().getFirstChild().addChild("Grand-child 1");
    }

    private void TraverseTree(Tree<String> tree)
    {
        System.out.println(tree.getRoot())
    }
}
