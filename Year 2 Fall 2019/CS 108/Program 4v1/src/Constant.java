public class Constant extends Token
{
    public Constant (String valToken){
        super(valToken);
    }

    @Override
    String evaluate() {
        try {
            Integer.parseInt(valToken);
            return valToken;
        } catch (NumberFormatException ex) { return "ERROR: Invalid number: " + valToken;}

    }

    @Override
    public String toString(){
        return valToken;
    }


}
