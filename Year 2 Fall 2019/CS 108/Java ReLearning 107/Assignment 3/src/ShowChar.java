
public class ShowChar {
    public static void ShowChar(String WordGiven, int NumberGiven)
    {

     if ((0 > NumberGiven) || (NumberGiven > WordGiven.length() -1 ))
     {
         System.out.print("You Typed in: " + NumberGiven + "\n" +
                         "For the Word: " + WordGiven + 
                          "\nThis Position Does Not Exist" + 
                          "\nPlease Type In a Number In Between 0 and " + (WordGiven.length() -1) + " for the Word: " + WordGiven + "\n" );
     }
     else 
     {
         System.out.print("For the Word: " + WordGiven + "\nThe Letter in Position: " + NumberGiven + " \n is: " + WordGiven.charAt(NumberGiven)+ "\n" );
     }
    }
    
    public static void main (String [] args)
    {
        
        ShowChar("HIPPOPOTUMUS", -12);
        
        
    }
}
