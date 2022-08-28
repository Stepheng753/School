/**
 * Program: 4
 * Description : Mini Math Programming Language
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/10/2019
 **/

// A class called Constant that inherits from abstract class Token
class Constant extends Token
{

    // A constructor that takes in one input parameter of type String.
    // This input parameter should be passed into the inherited constructor from Token as an argument.
    Constant (String valToken){
        super(valToken);
    }

    // Implement the inherited abstract method evaluate.
    // Evaluate should return the inherited field of type String, representing the value of a token.
    // If the string is not an int then the appropriate error message should be returned instead
    @Override
    String evaluate() {
        try {
            Integer.parseInt(valToken);
            return valToken.trim();  // Trim for Good Measures
        } catch (NumberFormatException nfe){
            String errorString = "ERROR: Invalid number: " + valToken;
            return errorString;
        }
    }

    // Override the toString method and have it return the inherited field of type String that represents the value of a token
    @Override
    public String toString(){
        return valToken.trim();
    } // Trim for Good Measures





}
