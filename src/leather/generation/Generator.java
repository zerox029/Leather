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

    public void generateAssembly(Tree<Token> ast, String path) throws IOException {
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

        assembly.append("\n");

        Path filePath = Paths.get(path + "/../assembly.s");
        Files.write(filePath, assembly.toString().getBytes());
    }

    public String generateFunction()
    {
        String functionName = tokenQueue.remove().getValue();

        StringBuilder toAppend = new StringBuilder(".globl ");
        toAppend.append(functionName + "\n" + functionName + ":\n  ");

        return toAppend.toString();
    }

    public String generateReturn()
    {
        StringBuilder toAppend = new StringBuilder("movl  ");
        toAppend.append("$" + tokenQueue.remove().getValue() + ", %eax\n  ret");

        return toAppend.toString();
    }
}
