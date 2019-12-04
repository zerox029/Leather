package leather.parse.structures;

import leather.lex.Token;
import leather.parse.ast.*;

public class Return extends Structure {
    public Return(Token returnValue)
    {
        structure = new Node<>(Token.RETURN_KW);
        structure.addChild(returnValue);
    }
}
