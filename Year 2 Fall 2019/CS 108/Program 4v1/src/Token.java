public abstract class Token
{
    protected Token leftNum;
    protected Token rightNum;
    protected String valToken;

    public Token (String valToken){
        this.valToken = valToken;
    }

    public Token (Token leftNum, Token rightNum){
        this.leftNum = leftNum;
        this.rightNum = rightNum;
    }

    abstract String evaluate();
















}
