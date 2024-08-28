import java.util.Scanner;

public class Commas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Codewords: ");
        String codes = input.nextLine();

        String [] words = codes.split(",");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            words[i] = putCommas(words[i]);
        }

        String finalString = "Matrix( [ ";
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                finalString = finalString.concat(words[i]);
            } else {
                finalString = finalString.concat(words[i]).concat(", ");
            }
        }
        finalString = finalString.concat(" ] )");

        System.out.println(finalString);

    }

    public static String putCommas(String codeword) {
        codeword = codeword.replace(" ","");
        char [] copyPaste = codeword.toCharArray();

        String printStr = "[ ";
        for (int i = 0; i < copyPaste.length; i++) {
            if (i == copyPaste.length - 1) {
                printStr = printStr.concat(String.valueOf(copyPaste[i])).concat(" ]");
            } else {
                printStr = printStr.concat(String.valueOf(copyPaste[i])).concat(", ");
            }

        }
        return printStr;
    }

}
