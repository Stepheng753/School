
import javax.swing.JOptionPane;

public class TicTacToe 
{
    public static void main(String[] args)
    {
        System.out.println("    R1C1    R1C2    R1C3    \n"
                        +  "    R2C1    R2C2    R2C3    \n"
                        +  "    R3C1    R3C1    R3C3    \n");
        
        String Input;
        
        int [][] Row = new int [5][2];
        int [][] Column = new int [5][2];
        char [][] TTT = new char [3][3];  
        
        for (int move=0; move<4; move++)
        {
            for (int player=0; player<2; player++)
            {
                Input = JOptionPane.showInputDialog("Player " + (player+1) + ": \n"
                                                  + "   What Row Would You Like to Put the X? ");
                Row[move][player] = Integer.parseInt(Input);
                while (Row[move][player] < 1 || Row[move][player] > 3 )
                {
                    Input = JOptionPane.showInputDialog("Player " + (player+1) + ": \n"
                                                      + "   What Row Would You Like to Put the X? ");
                    Row[move][player] = Integer.parseInt(Input); 
                }       
        
                Input = JOptionPane.showInputDialog("Player " + (player+1) + ": \n"
                                                  + "   What Column Would You Like to Put the X? ");
                Column[move][player] = Integer.parseInt(Input);
                while (Column[move][player] < 1 || Column[move][player] > 3 )
                {
                    Input = JOptionPane.showInputDialog("Player " + (player+1) + ": \n"
                                                      + "    What Column Would You Like to Put the X? ");
                    Column[move][player] = Integer.parseInt(Input); 
                }
   
            }
            
                TTT [(Row[move][0])-1][(Column[move][0])-1] = 'X';
                TTT [(Row[move][1])-1][(Column[move][1])-1] = 'O';
        }
        
                Input = JOptionPane.showInputDialog("Player " + 1 + ": \n"
                                                  + "   What Row Would You Like to Put the X? ");
                Row[4][0] = Integer.parseInt(Input);
                while (Row[4][0] < 1 || Row[4][0] > 3 )
                {
                    Input = JOptionPane.showInputDialog("Player " + 1 + ": \n"
                                                      + "   What Row Would You Like to Put the X? ");
                    Row[4][0] = Integer.parseInt(Input); 
                }       
        
                Input = JOptionPane.showInputDialog("Player " + 1 + ": \n"
                                                  + "   What Column Would You Like to Put the X? ");
                Column[4][0] = Integer.parseInt(Input);
                while (Column[4][0] < 1 || Column[4][0] > 3 )
                {
                    Input = JOptionPane.showInputDialog("Player " + 1 + ": \n"
                                                      + "    What Column Would You Like to Put the X? ");
                    Column[4][0] = Integer.parseInt(Input);
                }
                
                TTT [(Row[4][0])-1][(Column[4][0])-1] = 'X';
                
        System.out.println("    " + TTT[0][0] + "   " + TTT[0][1] + "   " + TTT[0][2] + "\n"
                          +"    " + TTT[1][0] + "   " + TTT[1][1] + "   " + TTT[1][2] + "\n"
                          +"    " + TTT[2][0] + "   " + TTT[2][1] + "   " + TTT[2][2] + "\n");
    }
}
