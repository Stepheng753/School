
//Needed for input and message box
import javax.swing.JOptionPane;


public class CaseRomanNumerals {
    
    public static void main (String[] args) {
       
       String Stringinput;
       int Number;
       
       Stringinput = JOptionPane.showInputDialog("Enter a Number in between 1 and 10");
       
       Number = Integer.parseInt(Stringinput);
       
       String RomanNumber = RomanConversion(Number);
       
       JOptionPane.showMessageDialog(null, "The Number: " + Number + " is " + RomanNumber + " in Roman Numerals.");
      
       
    }
    
    static String RomanConversion(Integer number){
        
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
                return "IIX";
                
            case 9:
                return "IX";  
                
            case 10:
                return "X";
                
            default:
                return "INVALID";
        }
    }
}
