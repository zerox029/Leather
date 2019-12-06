package leather.lex;

public class Token
{
    Tokens type;
    String value;

    String fileName;

    public Token(Tokens type, String value)
    {
        this.type = type;
        this.value = value;
    }

    public Token(Tokens type, String value, String fileName)
    {
        this.type = type;
        this.value = value;
        this.fileName = fileName;
    }

    public String getValue() { return value; }
    public void setValue(String val) { value = val; }

    public Tokens getType() { return type; }
    public void setType(Token token) { this.type = type; }

    public String getFileName() { return fileName; }
}
