package leather.parse.structures;

import leather.lex.*;
import leather.parse.ast.*;

public abstract class Structure {
    Node<Token> structureRoot;

    public Node<Token> getStructureRoot() { return structureRoot; }

    public void addTokenIfValid(Tokens expected, Token actual, String errorMessage)
    {
        checkTokenValidity(expected, actual, errorMessage);
        structureRoot.addChild(actual);
    }

    public void checkTokenValidity(Tokens expected, Token actual, String errorMessage)
    {
        if(actual.getType() != expected)
        {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
