/**
 * Program: 4
 * Description : Mini Math Programming Language
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/10/2019
 **/

import java.util.ArrayList;

// A class called TokenBuilder that inherits from the abstract class Parser and implements the interface Builder
class TokenBuilder extends Parser implements Builder <Token>
{

    // A private field of type String that will holder the delimiter used for creating tokens
    private String delimiter;

    // A default constructor that assigns the private field of type String to a comma
    TokenBuilder(){
        this.delimiter = ",";
    }

    // A constructor that has two input parameters, the first of type String and the second of type ArrayList of Strings.
    // private field of type String should be assigned to the input parameter of type String.
    // The inherited ArrayList of Strings called "keywords" should be assigned to the second input parameter that is also of type ArrayList of Strings.
    TokenBuilder(String delimiter, ArrayList<String> keywords){
        this.delimiter = delimiter;
        this.keywords = keywords;
    }

    // Implement the inherited method "createToken".
    // The input argument is an Array of Strings, starting at index zero it should hold
    // the first number of a mathematical expression, the second number, and the operator, in that order.
    // Depending on the operator return the appropriate Token type. For example if the operator is a plus symbol "+", then return an Add object.
    // The input arguments to the operator Token constructor should be two objects of type Constant,
    // each holding one of the numbers from the mathematical expression.
    @Override
    Token createToken(String[] tokens) {
        if (tokens[2].contains("+")){
            return new Add(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("-")){
            return new Subtract(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("*")){
            return new Multiply(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("/")){
            return new Divide(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        if (tokens[2].contains("%")){
            return new Modulo(new Constant(tokens[0]), new Constant(tokens[1]));
        }
        else {
            return parse(tokens); // Displays "INVALID OPERATOR" or "INVALID EXPRESSION"
        }
    }

    // Implement the "build" method. Return the result from calling the inherited method "parse".
    // Where the input to parse should be an array of Strings formed by delimiting the String input to the build method.
    @Override
    public <E> E build(String tokenString) {
        delimiter = "\\s+";
        String [] tokens = tokenString.trim().split(delimiter);
        return (E) parse(tokens);
    }

    // Implement setters for the inherited keywords variable and for the private field of type String holding the specified delimiter
    void setKeyWords(ArrayList <String> keyWords){ this.keywords = keyWords;}
    void setDelimiter(String delimiter){ this.delimiter = delimiter;}


}
