
import javax.swing.JOptionPane;

public class MagicSquare 
{
    public static void getSum(int[][] MagicSqr)
    {
        int[] rsum = new int [3];
        rsum[0] = 0;
        
        for (int rws=0; rws<3; rws++)
        {
            for (int clms=0; clms<3; clms++)
            {
                rsum[rws] = MagicSqr[rws][clms] + rsum[rws];
            }
        }
        
        int[] csum = new int [3];
        csum[0] = 0;
        
        for (int clms=0; clms<3; clms++)
        {
            for (int rws=0; rws<3; rws++)
            {
                csum[clms] = MagicSqr[rws][clms] + csum[clms];
            }
        }
        
        int[] dsum = new int [2];
        dsum[0] = (MagicSqr[0][0]) + (MagicSqr[1][1]) + (MagicSqr[2][2]);
        dsum[1] = (MagicSqr[0][2]) + (MagicSqr[1][1]) + (MagicSqr[2][0]);
        
        for (int x=0; x<3; x++)
        {
        System.out.println("Sum of Row " + (x+1) + " : " + rsum[x] );
        }
        System.out.print("\n");
        for (int x=0; x<3; x++)
        {
        System.out.println("Sum of Column " + (x+1) + " : " + csum[x] );
        }
        System.out.print("\n");
        for (int x=0; x<2; x++)
        {
        System.out.println("Sum of Diagonal " + (x+1) + " : " + csum[x] );
        }
        System.out.print("\n");
        
        if ((rsum[0] == rsum[1]) && (rsum[1] == rsum[2]) &&
            (csum[0] == csum[1]) && (csum[1] == csum[2]) &&
            (dsum[0] == dsum[1]) &&
            (rsum[0] == csum[0]) && (csum[0] == dsum[0]))
        {
            System.out.println("This is a MAGIC SQUARE!\n");
        }
        else
        {
            System.out.println("This is NOT a MAGIC SQUARE!\n");
        }
    }
    public static void main(String[] args)
    {
        final int columns = 3;
        final int rows = 3;
        int[][] MagicSqr = new int[rows][columns];
        
        JOptionPane.showMessageDialog(null, "Welcome to the Lo Shu Magic Square Calculator");
        
        String Input;
        
        for (int rws=0; rws<3; rws++)
        {
            for (int clms=0; clms<3; clms++)
            {
                Input = JOptionPane.showInputDialog(null, "Enter in a Number 1 - 9" + "\n"
                                                         +"Row " + (rws+1) + " Column" + (clms+1));
                MagicSqr[rws][clms] = Integer.parseInt(Input);
                
                while (MagicSqr[rws][clms] < 1 || MagicSqr[rws][clms] > 9)
                {
                    Input = JOptionPane.showInputDialog(null, "Enter in a Number 1 - 9" + "\n"
                                                         +"Row " + (rws+1) + " Column" + (clms+1));
                    MagicSqr[rws][clms] = Integer.parseInt(Input);  
                }
            }
        }
        

                System.out.println("-------------------" + "\n" 
                                 + "    " + MagicSqr[0][0] + "    " + MagicSqr[0][1] + "    " + MagicSqr[0][2]);
                System.out.println("    " + MagicSqr[1][0] + "    " + MagicSqr[1][1] + "    " + MagicSqr[1][2]);
                System.out.println("    " + MagicSqr[2][0] + "    " + MagicSqr[2][1] + "    " + MagicSqr[2][2] + "\n"
                                 + "-------------------");

        getSum(MagicSqr);          
    }
}
