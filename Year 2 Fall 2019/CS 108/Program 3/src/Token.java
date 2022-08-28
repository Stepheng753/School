
public class Token
{
    private String tokenString;  // Private String Variable

    /**
     * Default Constructor
     * @param tokenString
     */
    public Token(String tokenString)
    {
        this.tokenString = tokenString;
    }

    /**
     * @return Token Value
     */
    public String getValue()
    {
        return tokenString;
    }

    /**
     * Changes Value of Token
     * @param tokenString
     */
    public void setValue(String tokenString)
    {
        this.tokenString = tokenString;
    }

    /*
    Converts it into a String
     */
    @Override
    public String toString()
    {
        return tokenString;
    }
}
