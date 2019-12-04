package leather.parse.structures;

import leather.lex.Token;
import leather.parse.ast.*;

public abstract class Structure {
    Node<Token> structure;

    public Node<Token> getStructure() { return structure; }
}
