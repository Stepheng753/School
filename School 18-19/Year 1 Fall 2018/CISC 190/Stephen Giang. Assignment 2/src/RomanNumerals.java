import java.util.*;
public class RomanNumerals {
    public static void main(String[] args) {
    
    //Create a Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    
    //Get a Number from the user
    System.out.print("Enter a number in the range of 1 - 10: ");
    
    int number = keyboard.nextInt();  //User's Inputted Number
    
    //Close Stream
    keyboard.close();
    
    //Get Roman Numeral.
    String romanNumerals = convertNumberToRomanNumeral(number);
    
    //Output to user
    System.out.println(romanNumerals);
}
    
static String convertNumberToRomanNumeral(Integer number){
    
    switch (number){
        case 1:
            return "I";
        case 2:
            return "II";
        case 3:
            return "III";
        case 4:    
            return "IV";
        case 5:
            return "V";
        case 6:
            return "VI";
        case 7:
            return "VII";
        case 8:
            return "VIII";
        case 9:
            return "IV";
        case 10:
            return "X";
            
        default:
            return "INVALID NUMBER";
              
    }
}
 }   