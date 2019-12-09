package leather;

import leather.generation.Generator;
import leather.lex.Lexer;
import leather.lex.Token;
import leather.parse.ast.Tree;
import leather.parse.structures.AbstractSyntaxTree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LLC {
    public static void toAssembly(String path) throws IOException
    {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.lex(path);

        Tree<Token> ast = AbstractSyntaxTree.generateTreeFromTokenQueue(new LinkedList<>(tokens));
        Generator gen = new Generator();
        gen.generateAssembly(ast, path);
    }

    public static void toExecutable(String path) throws IOException
    {
        toAssembly(path);
    }

    public static void compileAndRun(String path) throws IOException
    {

    }
}
