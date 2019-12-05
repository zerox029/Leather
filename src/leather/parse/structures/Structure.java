package leather.parse.structures;

import leather.lex.Token;
import leather.parse.ast.*;

public abstract class Structure {
    Node<Token> structureRoot;

    public Node<Token> getStructureRoot() { return structureRoot; }

    public void addTokenIfValid(Token expected, Token actual, String errorMessage)
    {
        checkTokenValidity(expected, actual, errorMessage);
        structureRoot.addChild(expected);
    }

    public void checkTokenValidity(Token expected, Token actual, String errorMessage)
    {
        if(actual != expected)
        {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
