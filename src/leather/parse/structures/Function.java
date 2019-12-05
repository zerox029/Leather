package leather.parse.structures;

import leather.lex.Token;
import leather.parse.ast.Node;

import java.util.Queue;

public class Function extends Structure {
    public Function(Queue<Token> tokens)
    {
        //Function keyword
        structureRoot = new Node<>(tokens.remove());

        //Identifier
        addTokenIfValid(Token.IDENTIFIER, tokens.remove(), "Identifier expected");

        //Arguments - not supported for now
        if (tokens.remove() != Token.OPEN_PARENTHESIS) {
            throw new IllegalArgumentException("Cannot resolve function");
        }
        if (tokens.remove() != Token.CLOSE_PARENTHESIS) {
            throw new IllegalArgumentException("Cannot resolve function");
        }

        //Body
        checkTokenValidity(Token.OPEN_BRACE, tokens.remove(), "Cannot resolve function body");
        Return body = new Return(tokens);
        structureRoot.addChild(body.getStructureRoot());
        checkTokenValidity(Token.CLOSE_BRACE, tokens.remove(), "Cannot resolve function body");

    }
}
