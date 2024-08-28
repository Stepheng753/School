
/**
 * Program: 3
 * Description : Tokenizer, Takes Tokens from .txt files
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 10/13/2019
 **/


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;

public class Tokenizer
{
    private ArrayList <Token> tokenObjects = new ArrayList<>();  // Arraylist of Token Objects
    private int keyWordCount;  //KeyWord Counter
    String keyWord = "Public"; // Keyword Declaration

    /**
     * Default Constructor to "Default String"
     */
    public Tokenizer() {
        tokenObjects.add( new Token("Default String"));
    }

    /**
     * Takes in input from filepaths' and takes each token separated by the deliminator '_'
     * and adds it into an ArrayList
     * If the input is 'Public', then the counter adds one to itself
     * @param filePath
     * @throws IOException
     */
    public void tokenizeFile (String filePath) throws IOException {
        FileInputStream fStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fStream);

        tokenObjects.clear();  // Clears values of ArrayList to implement different input Streams
        keyWordCount = 0;  // Clears the value of the KeywordCount to restart count for each input Stream

        while ( scanner.hasNext()) {
            //Allows me to use the Value multiple times, Keyword Count, ArrayList
            String scannerNext = scanner.next();
            tokenObjects.add( new Token(scannerNext));

            // Ignores the casing on the keyword 'Public'
            if (scannerNext.equalsIgnoreCase(keyWord)){
                keyWordCount++;
            }
        }
    }

    /**
     * Takes in Token ArrayList and converts it into an Array
     * @return Token Array
     */
    public Token[] getTokens() {
        Token [] TokenArray = new Token[tokenObjects.size()];
        for (int i = 0; i < tokenObjects.size(); i++) {
            TokenArray [i] = tokenObjects.get(i);
        }
        return TokenArray;
    }

    /**
     * Needed for getting private variables
     * @return Keyword Count
     */
    public int getKeywordCount(){
        return keyWordCount;
    }

    /**
     * Converts the Arraylist into an Array of String Values
     * @return String Array ie. [abc,xyz,123]
     */
    @Override
    public String toString() {
        String toStringSTR = "[";
        for (int i = 0; i < tokenObjects.size() - 1; i++) {
            toStringSTR += tokenObjects.get(i) + ", ";
        }
        //This Line is to make sure the last value does not have a comma following it
        toStringSTR += tokenObjects.get(tokenObjects.size() - 1) + "]";
        return toStringSTR;
    }

    /**
     * This will print out the tokens to a .txt file called Output
     * @throws IOException
     */
    public void writeTokens() throws IOException{
        //Creates a .txt file named output.txt that prints out the Tokens
        PrintWriter pWriter = new PrintWriter("output.txt");

        for (int i = 0; i < tokenObjects.size(); i++) {
            pWriter.println(tokenObjects.get(i));
        }
        // Closes the output stream
        pWriter.close();
    }


}
