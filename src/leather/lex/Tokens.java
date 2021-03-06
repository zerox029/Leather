package leather.lex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Tokens {

    //Single char tokens
    OPEN_BRACE("\\{"),
    CLOSE_BRACE("\\}"),
    OPEN_PARENTHESIS("\\("),
    CLOSE_PARENTHESIS("\\)"),
    SEMI_COLON(";"),

    //Keyword tokens
    FUNC_KW("func"),
    RETURN_KW("return"),

    //Identifier tokens
    IDENTIFIER("[a-zA-Z]\\w*"),
    INTEGER_LITERAL("[0-9]+");

    private final Pattern mPattern;
    private final int mPatternLength;

    Tokens(String regex)
    {
        mPattern = Pattern.compile("^" + regex);

        //Removing the "\" used by regex, for an accurate length count
        if(regex.charAt(0) == '\\' && regex.length() > 1)
        {
            regex = regex.substring(1, regex.length());
        }

        mPatternLength = regex.length();
    }

    public boolean matches(String matchingCandidate)
    {
        Matcher matcher = mPattern.matcher(matchingCandidate);

        return matcher.matches();
    }

    public int getPatternLength() { return mPatternLength; }
}