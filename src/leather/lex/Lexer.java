package leather.lex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lexer {
    private String program;
    private List<Token> tokens = new ArrayList<>();
    private Set<Character> blankChars = new HashSet<Character>();

    public List<Token> lex(String filePath)
    {
        readFile(filePath);

        fillBlankCharset();

        int currentCharIndex = 0;
        StringBuilder currentCheck = new StringBuilder();
        while(program.length() > 0)
        {
            //Check next char, if in single char tokens, add current check to tokens, then add current char to token.
            //If space, add current char to tokens
            char currentChar = program.charAt(currentCharIndex);
            Token token = matchSingleCharacterToken(currentChar);

            if(token != null)
            {
                if(currentCheck.length() > 0) { tokens.add(matchMultiCharacterToken(currentCheck.toString())); }
                tokens.add(token);
            }
            else if(!isBlankCharacter(currentChar))
            {
                currentCheck.append(program.charAt(currentCharIndex));
                currentCharIndex++;

                continue;
            }
            else if(isBlankCharacter(currentChar) && currentCheck.length() > 0)
            {
                token = matchMultiCharacterToken(currentCheck.toString());
                if(token != null) { tokens.add(token); }
            }

            program = program.substring(currentCharIndex + 1, program.length());
            currentCharIndex = 0;
            currentCheck.setLength(0);
        }

        return tokens;
    }

    private void readFile(String filePath)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            program = bufferedReader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        }
        catch(Exception e)
        {
            System.out.println("Could not read from the specified file");
        }
    }

    private void fillBlankCharset()
    {
        blankChars.add('\r');
        blankChars.add('\n');
        blankChars.add((char) 8);
        blankChars.add((char) 9);
        blankChars.add((char) 11);
        blankChars.add((char) 12);
        blankChars.add((char) 32);
    }

    private boolean isBlankCharacter(char c)
    {
        if(blankChars.contains(c))
            return true;
        else
            return false;
    }
    
    private Token matchSingleCharacterToken(char token)
    {
        for(Token t : Token.values())
        {
            if(t.getPatternLength() == 1 && t.matches(String.valueOf(token)))
            {
                t.setValue(String.valueOf(token));
                return t;
            }
        }

        return null;
    }

    private Token matchMultiCharacterToken(String token)
    {
        for(Token t : Token.values())
        {
            if(t.getPatternLength() > 1 && t.matches(token))
            {
                t.setValue(token);
                return t;
            }
        }

        return null;
    }
}