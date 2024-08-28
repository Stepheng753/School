import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer
{
    private ArrayList<Token> tokenObjects;
    private ArrayList <String> stringArrayList;
    private TokenBuilder tokenBuilderObj;

    public Tokenizer() {
        tokenObjects = new ArrayList<Token>();
        stringArrayList = new ArrayList<>();
        stringArrayList.add("+");
        stringArrayList.add("-");
        stringArrayList.add("*");
        stringArrayList.add("/");
        stringArrayList.add("%");
        tokenBuilderObj = new TokenBuilder("\\s+", stringArrayList);
    }

    public void tokenizeFile (String filePath) throws IOException {
        FileInputStream fStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fStream);

        tokenObjects.clear();  // Clears values of ArrayList to implement different input Streams

        while ( scanner.hasNextLine()) {
            //Allows me to use the Value multiple times, Keyword Count, ArrayList
            String scannerNextLine = scanner.nextLine().trim();
            tokenObjects.add((Token) new TokenBuilder().build(scannerNextLine));
        }
        fStream.close();
    }

    public Token[] getTokens() {
        Token [] TokenArray = new Token[tokenObjects.size()];
        for (int i = 0; i < tokenObjects.size(); i++) {
            TokenArray [i] = tokenObjects.get(i);
        }

        return TokenArray;
    }


    public void writeTokens() throws IOException{
        //Creates a .txt file named output.txt that prints out the Tokens
        PrintWriter pWriter = new PrintWriter("output.txt");
        for (int i = 0; i < tokenObjects.size(); i ++){
//            System.out.println(tokenObjects.get(i).toString().trim());
            String [] str = tokenObjects.get(i).toString().trim().split("\\s+");
//            System.out.println(str[0] + " " + str[1] + " " +  str[2]);
//            System.out.println(str[2]);
            pWriter.println(new TokenBuilder().createToken(str).evaluate());
        }
        // Closes the output stream
        pWriter.flush();
        pWriter.close();

    }


}
