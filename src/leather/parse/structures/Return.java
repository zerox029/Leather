package leather.parse.structures;

import leather.lex.*;
import leather.parse.ast.*;

import java.util.Queue;

public class Return extends Structure {
    public Return(Queue<Token> tokens)
    {
        structureRoot = new Node<>(tokens.remove());

        addTokenIfValid(Tokens.INTEGER_LITERAL, tokens.remove(), "Return value must be integer");

        checkTokenValidity(Tokens.SEMI_COLON, tokens.remove(), "'; expected'");
    }
}
