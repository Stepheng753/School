/**
 * Program: 4
 * Description : Mini Math Programming Language
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/10/2019
 **/

// An abstract class called Token
abstract class Token
{

    // A protected field of type Token that represents the left number in a mathematical expression
    protected Token leftNum;

    // A protected field of type Token that represents the right number in a mathematical expression
    protected Token rightNum;

    // A protected field of type String that represents the value of a token
    protected String valToken;

    // A constructor that takes in one input argument of type string. The protected field of type String should be assigned to (set equal to) this input.
    Token(String valToken){
        this.valToken = valToken;
    }

    // A constructor that takes in two input arguments, each of type Token.
    // The protected field of type Token representing the left number should be assigned to the first input argument.
    // The protected field of type Token representing the right number should be assigned to the second input argument.
    Token (Token leftNum, Token rightNum){
        this.leftNum = leftNum;
        this.rightNum = rightNum;
    }

    // Declare an abstract method called evaluate, that have no input parameters and returns type string
    abstract String evaluate();


}
