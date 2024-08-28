import java.util.*;

class MagicSquare
{
    public static void main (String[] args)
    {
        int [][] square = new int [3][3];
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please Enter Magic Sqaure:");
        System.out.println(" ---------------------------");
        System.out.println("Rules: ");
        System.out.println("Only Enter Integers from 1 - 9");
        System.out.println("Do not Repeat Any Numbers");
        System.out.println(" ---------------------------");
        System.out.println("Seperate Numbers in a row  by Pressing [TAB]");
        System.out.println("Go Down a row by Pressing [Enter]");
        System.out.println("For Example: ");
        System.out.println("1 [TAB] 2 [TAB] 3    [ENTER]");
        System.out.println("4 [TAB] 5 [TAB] 6    [ENTER]");
        System.out.println("7 [TAB] 8 [TAB] 9 ");
        System.out.println(" ---------------------------");
        
        
        for (int i=0; i< 3; i++)
           for (int j=0; j<3; j++) 
               square [i][j] = input.nextInt();
        
        if (Sums(square) && NoRepeats(square))
            System.out.println("THAT IS A MAGIC SQUARE!");
        else 
            System.out.println("THAT IS NOT A MAGIC SQUARE!");   
    }    
        
    private static boolean Sums(int [][] square )
    {
        //row 0 
        if (square [0][0] + square [0][1] + square [0][2] != 15)
             return false;
         
        //row 1
         if (square [1][0] + square [1][1] + square [1][2] != 15)
             return false;
         
         //row 2
         if (square [2][0] + square [2][1] + square [2][2] != 15)
             return false;
         
         //column 1
         if (square [0][0] + square [1][0] + square [2][0] != 15)
             return false;
            
         //column 2
         if (square [0][1] + square [1][1] + square [2][1] != 15)
             return false;
         
         //column 3
         if (square [0][2] + square [1][2] + square [2][2] != 15)
             return false;
         
         //diagonal "x"
         if (square [0][0] + square [1][1] + square [2][2] != 15)
             return false;
         
         //diagonal "-x"
         if (square [2][0] + square [1][1] + square [0][2] != 15)
             return false;
         
         return true;
    }
    
    private static boolean NoRepeats (int [][] square)
    {
        int [] repeat = new int [10];
        
        for (int i = 1; i < 10; i++)
            repeat [i] = 0;
        
        // Numbers 1-9
        for (int i =0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (square [i][j] < 1 || square [i][j] > 9)
                    return false;  
                
                repeat[square [i][j]]++;
            }
        }
        
        //No Repeats
        for (int i = 1; i < 10; i++)
            if (repeat [i] != 1)
                return false;
        
        return true;
    }
}
    

