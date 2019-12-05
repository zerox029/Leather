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
            Token top = tokens.peek();

            switch (top)
            {
                case RETURN_KW:
                    ast.getRoot().addChild(new Return(tokens).getStructureRoot());
                case FUNC_KW:
                    ast.getRoot().addChild(new Function(tokens).getStructureRoot());
            }
        }

        return ast;
    }
}
