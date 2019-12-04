package leather.lex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    //Single char tokens
    OPEN_BRACE("\\{"),
    CLOSE_BRACE("\\}"),
    OPEN_PARENTHESIS("\\("),
    CLOSE_PARENTHESIS("\\)"),
    SEMI_COLON(";"),

    //Keyword tokens
    INT_KW("int"),
    RETURN_KW("return"),

    //Identifier tokens
    IDENTIFIER("[a-zA-Z]\\w*"),
    INTEGER_LITERAL("[0-9]+");

    private final Pattern mPattern;
    private final int mPatternLength;

    private String mValue;

    Token(String regex)
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

    public void setValue(String val) { mValue = val; }
    public String getValue() { return mValue; }

    public int getPatternLength() { return mPatternLength; }
}