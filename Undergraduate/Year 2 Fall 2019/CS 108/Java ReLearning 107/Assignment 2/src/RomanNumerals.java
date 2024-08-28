
//Needed for all Scanners (inputs)
import java.util.Scanner;  


public class RomanNumerals {

    public static void main (String[] args) {
        
        //declares the Scanner as something we will input
        Scanner Keyboard = new Scanner(System.in);
        
        double Number;
        
        System.out.print("Enter an integer from 1 - 10: ");
        
        Number = Keyboard.nextDouble();
        
        if (Number == 1)
            
                System.out.println('I');  
        
        if (Number == 2)
            
                System.out.println("II");
            
        if (Number == 3)
            
                System.out.println("III");
        
        if (Number == 4)
            
                System.out.println("IV");
        
        if (Number == 5)
            
                System.out.println('V');
        
        if (Number == 6)
            
                System.out.println("VI");
        
        if (Number == 7)
            
                System.out.println("VII");
        
        if (Number == 8)
            
                System.out.println("VIII");
        
        if (Number == 9)
        
                System.out.println("IX");
        
        if (Number == 10)
            
                System.out.println("X");
        
        else 
            
            System.out.println("Invalid");
                 
    }
    
}
