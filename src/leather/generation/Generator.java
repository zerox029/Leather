package leather.generation;

import leather.lex.Token;
import leather.parse.ast.Tree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class Generator {
    Queue<Token> tokenQueue = new LinkedList<>();
    StringBuilder assembly = new StringBuilder();

    public void generateAssembly(Tree<Token> ast) throws IOException {
        tokenQueue = ast.toQueuePreOrderDFS();

        while (tokenQueue.size() > 0)
        {
            switch (tokenQueue.remove().getType())
            {
                case FUNC_KW:
                    assembly.append(generateFunction());
                    break;
                case RETURN_KW:
                    assembly.append(generateReturn());
                    break;
                default:
                    break;
            }
        }

        Path filePath = Paths.get("assembly.s");
        Files.write(filePath, assembly.toString().getBytes());
    }

    public String generateFunction()
    {
        StringBuilder toAppend = new StringBuilder(".globl ");
        toAppend.append("_" + tokenQueue.remove().getValue() + ":\n  ");

        return toAppend.toString();
    }

    public String generateReturn()
    {
        StringBuilder toAppend = new StringBuilder("movl  ");
        toAppend.append("$" + tokenQueue.remove().getValue() + ", %eax\n  ret");

        return toAppend.toString();
    }
}
