import java.util.Scanner;
import java.lang.Math;

public class Cosets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Codewords: ");
        String codes = input.nextLine();

        String [] words = codes.split(",");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace(" ", "");
        }
        int n = words[0].length();
        int size = (int)Math.pow(2, n);
        String [] knCodes = new String[size];
        int m = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        knCodes[m] = String.valueOf(i).concat(String.valueOf(j)).concat(String.valueOf(k)).concat(String.valueOf(l));
                        System.out.println(knCodes[m++]);
                    }
                }
            }
        }
        System.out.println();

        String [] coset = new String [words.length];
        for (int i = 0; i < knCodes.length; i++) {
            char [] knCodesArr = knCodes[i].toCharArray();
            for (int j = 0; j < words.length; j++) {
                char [] wordsArr = words[j].toCharArray();
                String add = "";
                for (int k = 0; k < n; k++) {
                    add = add.concat(String.valueOf((Integer.valueOf(wordsArr[k]) + Integer.valueOf(knCodesArr[k])) % 2));
                }
                coset[j] = add;
            }
            System.out.print(knCodes[i] + " : : : ");
            for (int j = 0; j < words.length; j++) {
                System.out.print(coset[j] + " ");
            }
            System.out.println();
        }





    }
}
