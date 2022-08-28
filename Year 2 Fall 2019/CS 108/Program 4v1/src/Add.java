public class Add extends Token
{
    public Add(Token leftNum, Token rightNum){
        super(leftNum, rightNum);
    }

    @Override
    String evaluate() {
        try {
            int sumTokens = Integer.parseInt(leftNum.evaluate()) + Integer.parseInt(rightNum.evaluate());
            return Integer.toString(sumTokens);
        }
        catch (NumberFormatException ex) {
            String str = ex.getMessage().replaceAll("For input string: ", "");
            str = str.replaceAll("\"", "");
            return str;
        }
    }

    @Override
    public String toString(){
        String addString = leftNum.toString() + '\u0020' + rightNum.toString() + '\u0020' + "+";
        return addString;
    }



}
