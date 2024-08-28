public class Multiply extends Token
{
    public Multiply(Token leftNum, Token rightNum){
        super(leftNum, rightNum);
    }

    @Override
    String evaluate() {
        try{
        int productTokens = Integer.parseInt(leftNum.evaluate()) * Integer.parseInt(rightNum.evaluate()) ;
        return Integer.toString(productTokens);
        }
        catch (NumberFormatException ex) {
            String str = ex.getMessage().replaceAll("For input string: ", "");
            str = str.replaceAll("\"", "");
            return str;
        }

    }

    @Override
    public String toString() {
        String productString = leftNum.toString() + '\u0020' + rightNum.toString() + '\u0020' + "*";
        return productString;
    }




}
