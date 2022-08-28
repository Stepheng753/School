public class Subtract extends Token
{
    public Subtract(Token leftNum, Token rightNum){
        super(leftNum, rightNum);
    }

    @Override
    String evaluate() {
        try {
            int diffTokens = Integer.parseInt(leftNum.evaluate()) - Integer.parseInt(rightNum.evaluate());
            return Integer.toString(diffTokens);
        }
        catch (NumberFormatException ex) {
            String str = ex.getMessage().replaceAll("For input string: ", "");
            str = str.replaceAll("\"", "");
            return str;
        }
    }

    @Override
    public String toString() {
        String subtractString = leftNum.toString() + '\u0020' + rightNum.toString() + '\u0020' + "-";
        return subtractString;
    }

}
