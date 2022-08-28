import java.util.Scanner;

public class ScannerCommas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How Many Codewords: ");
        int iterations = input.nextInt();
        System.out.println();

        String [] strArray = new String [iterations];
        for (int i = 0; i < iterations; i++) {
            input = new Scanner(System.in);
            String codeword;
            System.out.print("CodeWord: ");
            codeword = input.nextLine();
            System.out.println();
            strArray[i] = putCommas(codeword);
        }

        String finalString = "Matrix( [ ";
        for (int i = 0; i < iterations; i++) {
            if (i == iterations - 1) {
                finalString = finalString.concat(strArray[i]);
            } else {
                finalString = finalString.concat(strArray[i]).concat(", ");
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

