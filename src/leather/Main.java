package leather;

import leather.generation.Generator;
import leather.lex.Lexer;
import leather.lex.Token;
import leather.parse.ast.Tree;
import leather.parse.structures.*;
import org.junit.jupiter.engine.descriptor.ClassTestDescriptor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.lex("examples/testFile.lt");

        Tree<Token> ast = AbstractSyntaxTree.generateTreeFromTokenQueue(new LinkedList<>(tokens));
        Generator gen = new Generator();
        gen.generateAssembly(ast);

        /*
        for(Token s : tokenQueue)
        {
            System.out.println("[" + s.getType() + "] " + s.getValue() + " -> " + s.getFileName());
        }*/

    }
}
