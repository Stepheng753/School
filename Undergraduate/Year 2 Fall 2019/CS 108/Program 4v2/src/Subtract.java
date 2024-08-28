/**
 * Program: 4
 * Description : Mini Math Programming Language
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/10/2019
 **/

// A class called Subtract that inherits from abstract class Token
class Subtract extends Token
{

    // A constructor that takes in two input parameters each of type Token.
    // These input parameters should be passed into the inherited constructor from Token as arguments.
    // The first input parameter should be the first argument to the inherited Token constructor,
    // and the second input parameter should be the second argument to the inherited Token Constructor.
    Subtract (Token leftNum, Token rightNum){
        super(leftNum, rightNum);
    }

    // Implement the inherited abstract method evaluate.
    // Evaluate should return the String representation of the result from subtracting together the
    // integer representations of evaluate calls on the inherited fields of type Token that represents the left number and the right number.
    // Evaluate can also return an appropriate error message.
    @Override
    String evaluate() {
        try {
            int diffTokens = Integer.parseInt(leftNum.evaluate()) - Integer.parseInt(rightNum.evaluate());
            return Integer.toString(diffTokens);
        }
        catch (NumberFormatException ex) {
            // ex.getMessage() kept Displaying "For Input String: "ERROR: INVALID NUMBER:  LEFT/RIGHT""
            String errorString = ex.getMessage().replaceAll("For input string: ", "");  // This Gets rid of the "For input string: "
            errorString = errorString.replaceAll("\"", ""); // This Gets rid of the quotation marks around "ERROR: INVALID NUMBER:  LEFT/RIGHT"
            return errorString;
        }
    }

    // Override the toString method and have it return the left token's toString, the right token's toString, and the "-" symbol,
    // each separated by a single space. For example it might return: "5 6 -"
    @Override
    public String toString(){
        String mathLang =  leftNum.toString() + " " + rightNum.toString() + " " + "-";
        return mathLang;
    }


}
