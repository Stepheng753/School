import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        Constant five = new Constant("5");
        Constant six = new Constant("6");
        System.out.println(new Add(five, six).evaluate());
        System.out.println(new Subtract(five, six).evaluate());
        System.out.println(new Multiply(five, six).evaluate());
        System.out.println(new Divide(five, six).evaluate());
        System.out.println(new Modulo(five, six).evaluate());

        Tokenizer tokenizer = new Tokenizer();
        tokenizer.tokenizeFile("C:\\Users\\Stephen Giang\\Google Drive\\School\\Fall 2019\\CS 108\\Program 4v2\\src\\test.txt");
        tokenizer.getTokens();
        tokenizer.writeTokens();



    }
}
