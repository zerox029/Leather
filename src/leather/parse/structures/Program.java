package leather.parse.structures;

import leather.lex.Token;
import leather.parse.ast.Node;

public class Program extends Structure {
    public Program()
    {
        structure = new Node<>(Token.IDENTIFIER);
    }
}
