package leather;

import leather.lex.Lexer;
import leather.lex.Token;
import leather.parse.ast.Tree;
import leather.parse.structures.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.lex("examples/testFile.lt");

        Tree<Token> ast = AbstractSyntaxTree.generateTreeFromTokenQueue(new LinkedList<>(tokens));
        Queue<Token> tokenQueue = ast.toQueuePreOrderDFS();

        for(Token s : tokenQueue)
        {
            System.out.println("[" + s + "] " + s.getValue());
        }

    }
}
