public class Divide extends Token
{
    public Divide(Token leftNum, Token rightNum){
        super(leftNum, rightNum);
    }

    @Override
    String evaluate() {
        try {
        int quotientTokens = Integer.parseInt(leftNum.evaluate()) / Integer.parseInt(rightNum.evaluate()) ;
        return Integer.toString(quotientTokens);
        }
        catch (NumberFormatException ex) {
            String str = ex.getMessage().replaceAll("For input string: ", "");
            str = str.replaceAll("\"", "");
            return str;
        }
        catch (ArithmeticException ae){
            return "Cannot Divide By 0";
        }
    }

    @Override
    public String toString() {
        String quotientString = leftNum.toString() + '\u0020' + rightNum.toString() + '\u0020' + "/";
        return quotientString;
    }




}
