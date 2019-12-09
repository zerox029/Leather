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
import leather.LLC;

public class Main {

    public static void main(String[] args) throws IOException
    {
        LLC.toAssembly("testFile.lt");
        /*
        for(Token s : tokenQueue)
        {
            System.out.println("[" + s.getType() + "] " + s.getValue() + " -> " + s.getFileName());
        }*/

    }
}
