package leather;

import leather.lex.Lexer;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        lexer.lex("examples/testFile.lt");
    }
}
