/**
 * Program: 4
 * Description : Mini Math Programming Language
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/10/2019
 **/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// A class called: Tokenizer
class Tokenizer {

    // A private variable that is an ArrayList of Token objects.
    private ArrayList<Token> tokenObjects = new ArrayList<>();

    // A private variable that is an ArrayList of Strings. This will hold the various operators to our mini math programming language
    private ArrayList<String> keywords = new ArrayList<>();

    // A private variable of type TokenBuilder.
    private TokenBuilder tokenBuilderObject;

    // A default constructor that initializes the ArrayList of Token objects.
    // Initializes the ArrayList of Strings and adds all of the necessary math operators to that ArrayList of Strings.
    // Initializes the TokenBuilder object and sets it's keywords field and its private String field to a space delimiter
    Tokenizer() {
        tokenObjects = new ArrayList<Token>();
        keywords = new ArrayList<String>();
        keywords.add("+");
        keywords.add("-");
        keywords.add("*");
        keywords.add("/");
        keywords.add("%");
        tokenBuilderObject = new TokenBuilder("\\s+", keywords);
    }

    // Tokenizer should have a public method called: tokenizeFile. This method is the EXACT SAME as your previous program,
    // the only difference is now you should read in from the file one line at a time (not one word at a time) and
    // pass each line to the TokenBuilder and store the token it returns in a similar manner as last program.
    // You might also want to check for empty lines here.
    public void tokenizeFile(String filePath) throws IOException {
        FileInputStream fStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fStream);
        tokenObjects.clear();
        while (scanner.hasNextLine()) {
                String scannerNextLine = scanner.nextLine();
                tokenObjects.add(tokenBuilderObject.build(scannerNextLine));
                if (scannerNextLine.isEmpty()){
                    tokenObjects.remove(tokenObjects.size() - 1); // If Empty, it adds it to ArrayList, then Removes it, then Carries On
                }
        }
        fStream.close();
    }

    // Tokenizer should have only a getter for the ArrayList of Token objects (not a setter)
    // This method should be the same as last programs
    public Token[] getTokens() {
        Token [] TokenArray = new Token[tokenObjects.size()];
        for (int i = 0; i < tokenObjects.size(); i++) {
            TokenArray [i] = tokenObjects.get(i);
        }
        return TokenArray;
    }

    // Tokenizer should have a method called: writeTokens
    // This method is identical to your last programs with the exception of what you are writing out to the file now is
    // the result of calling the evaluate method on each token.
    public void writeTokens() throws IOException{
        PrintWriter pWriter = new PrintWriter(new FileOutputStream("output.txt"));
        for (int i = 0; i < tokenObjects.size(); i++) {
            pWriter.println(tokenObjects.get(i).evaluate());
        }
        pWriter.flush();
        pWriter.close();
    }

    // Override the toString method inherited from the Object class,
    // have it return the same value as calling the toString method on the ArrayList of Token objects (This should also be the same as the last program)
    @Override
    public String toString() {
        String toStringSTR = "[";
        for (int i = 0; i < tokenObjects.size() - 1; i++) {
            toStringSTR += tokenObjects.get(i) + ", ";
        }
        toStringSTR += tokenObjects.get(tokenObjects.size() - 1) + "]";
        return toStringSTR;
    }



}
