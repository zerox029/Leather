package leather.parse.structures;

import leather.lex.*;
import leather.parse.ast.Node;

public class Program extends Structure {
    public Program()
    {
        structureRoot = new Node<>(new Token(Tokens.IDENTIFIER, "PROGRAM"));
    }
}
