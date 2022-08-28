import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
         Tokenizer tokenizer = new Tokenizer();
         tokenizer.tokenizeFile("C:\\Users\\steph.SKINRSF\\Google Drive\\School\\Fall 2019\\CS 108\\Program 4\\src\\test.txt");
         tokenizer.getTokens();
         tokenizer.writeTokens();
}
}
