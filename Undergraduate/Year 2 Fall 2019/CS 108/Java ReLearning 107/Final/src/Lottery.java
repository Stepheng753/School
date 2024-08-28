
import javax.swing.JOptionPane;
import java.util.Random;

public class Lottery 
{
    public static void showArrays(int[] Random, int[] User)
    {
        System.out.print("\n");
        System.out.println("Random Array: ");
        for (int index=0; index <5; index++)
        {
            System.out.print("      " + Random[index]);
        }
        System.out.print("\n");
        System.out.println("Your Array: ");
        for (int index=0; index <5; index++)
        {
            System.out.print("      " + User[index]);
        }  
        System.out.print("\n");
    }
    
    public static void Equals(int[] Random, int[] User)
    {
        System.out.print("\n");
       for (int index=0; index <5; index++)
        {
            if (Random[index] == User[index])
            {
                System.out.println("The Two Arrays share: " + User[index] + "\n"
                                 + "    in Position: " + (index +1));
            }
        }
    }
    
    public static void LotteryWinner(int[] Random, int[] User)
    {
        
        if (Random[0] == User[0] &&
            Random[1] == User[1] &&
            Random[2] == User[2] &&
            Random[3] == User[3] &&
            Random[4] == User[4])
            {
                System.out.println("You are the Grand Prize Winner!");
            }
        if (Random[0] != User[0] &&
            Random[1] != User[1] &&
            Random[2] != User[2] &&
            Random[3] != User[3] &&
            Random[4] != User[4])
            {
                System.out.println("You are NOT the Grand Prize Winner!" + "\n" 
                                  +"    No Number's Matched Togther");
            }
        System.out.print("\n");
        System.out.print("-----------------------------------------");
    }
    
    public static void main(String[] args)
    {
                
        String Again;
        
        do 
        {
            Random rand = new Random();
        
        int[] Random = new int [5];
        
        for (int index=0; index <5; index++)
        {
        Random [index] = rand.nextInt(10);
        }
        
        int[] User = new int [5];
        String Input;
        
        for (int index=0; index <5; index++)
        {
            Input = JOptionPane.showInputDialog((index+1) + ": Enter a Number from 0-9");
            User [index] =  Integer.parseInt(Input);
            while (User [index] < 0 || User [index] > 9)
            {
                Input = JOptionPane.showInputDialog((index+1) + ": Enter a Number from 0-9");
                User [index] =  Integer.parseInt(Input); 
            }
        }
        
        showArrays(Random, User);
        Equals(Random, User);
        
        LotteryWinner(Random, User);
        
        Again = JOptionPane.showInputDialog("Would You Like to Try Again?\n" + 
                                            "Type 'YES' or 'No'");
        
        }
        while (Again.equalsIgnoreCase("Yes"));
    }
}
