package leather.parse.structures;

import leather.lex.Token;
import leather.parse.ast.Node;
import leather.parse.ast.Tree;

import java.util.Queue;

public class AbstractSyntaxTree {
    public static Tree<Token> generateTreeFromTokenQueue(Queue<Token> tokens)
    {
        Tree<Token> ast = new Tree<>(Token.IDENTIFIER);

        while(tokens.size() > 0)
        {
            Token top = tokens.remove();

            if(top == Token.RETURN_KW)
            {
                if(tokens.peek() == Token.INTEGER_LITERAL)
                {
                    Return ret = new Return(tokens.remove());
                    ast.getRoot().addChild(ret.getStructure());
                }
                else
                {
                    System.out.println("Invalid code");
                    break;
                }
            }
        }

        return ast;
    }
}
