import java.util.ArrayList;

public class TokenBuilder extends Parser implements Builder
{

    private String delimiter;

    public TokenBuilder() {
        this.delimiter = ",";
    }

    public TokenBuilder(String delimiter, ArrayList <String> keywords){
        this.delimiter = delimiter;
        this.keywords = keywords;
    }

    @Override
    Token createToken(String[] tokens) {
        if (tokens[2].contains("+")) {
            return new Add(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("-")) {
            return new Subtract(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("*")) {
            return new Multiply(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("/")) {
            return new Divide(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("%")) {
            return new Modulo(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        else { return new Constant("ERROR");}
    }


    @Override
    public Object build(String str) {
        delimiter = "\\s+";
        String [] stringArray = str.trim().split(delimiter);
        return parse(stringArray);
    }

    public void setKeyWords(ArrayList <String> keyWords){ this.keywords = keyWords;}
    public void setDeliminator(String delimiter){ this.delimiter = delimiter;}



}
