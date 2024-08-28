public class Modulo extends Token
{
    public Modulo(Token leftNum, Token rightNum){
        super(leftNum, rightNum);
    }

    @Override
    String evaluate() {
        try {
        int modTokens = Integer.parseInt(leftNum.evaluate()) % Integer.parseInt(rightNum.evaluate()) ;
        return Integer.toString(modTokens);
        }
        catch (NumberFormatException ex) {
            String str = ex.getMessage().replaceAll("For input string: ", "");
            str = str.replaceAll("\"", "");
            return str;
        }
        catch (ArithmeticException ae) {
            return "Cannot Divide By 0";
        }
    }

    @Override
    public String toString() {
        String modString = leftNum.toString() + '\u0020' + rightNum.toString() + '\u0020' + "%";
        return modString;
    }
}
