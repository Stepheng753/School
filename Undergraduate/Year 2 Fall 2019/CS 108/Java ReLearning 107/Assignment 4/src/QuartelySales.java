
//JOptionPane is the Best!
import javax.swing.JOptionPane;

public class QuartelySales 
{ 
    public static void main(String[] args)
    {
        final int Quarter = 4;
        final int Division = 6;
        double [][] QDiv = new double [Quarter][Division];
        
//Get Inputs
        String String1;
    
        for (int Qtr =0; Qtr< Quarter; Qtr++)
        {
            for (int Div=0; Div< Division; Div++)
            {
                String1 = JOptionPane.showInputDialog(null, "Enter In Quater " + (Qtr +1) + " Division " + (Div +1) + " Sales: " );
                QDiv[Qtr][Div] = Double.parseDouble(String1);
                while (QDiv[Qtr][Div] < 0)
                {
                    String1 = JOptionPane.showInputDialog(null, "Enter In Quater " + (Qtr +1) + " Division " + (Div +1) + " Sales: " );
                    QDiv[Qtr][Div] = Double.parseDouble(String1);
                }
            }
        }

//Gets the DivDiff   
        double DivDiff=0;
        
        for (int Div=0; Div< Division; Div++)
        {
               System.out.println("Division " + (Div+1) + " : ");
            
            for (int Qtr =0; Qtr< Quarter-1; Qtr++)
            {
                DivDiff = QDiv[Qtr+1][Div] - QDiv[Qtr][Div]; 
                
                System.out.println("    Quarter " + (Qtr+1) + " Sales: " + QDiv[Qtr][Div]);
 
                System.out.println("        Difference: " + DivDiff);
            }
        
                System.out.println("    Quarter 4 Sales: " + QDiv[3][Div] + "\n");
        }
        
        System.out.println("---------------------------------------------------------------\n");
        
        
//Gets The Sum and Average
        double[] sum =new double [4];
        double[] Average = new double [4];
        double[] Max =new double [6];
        int HighDiv = 0;
        Max[0] = 0;
        
        for (int Qtr =0; Qtr< Quarter; Qtr++)
        {
            System.out.println("Quarter " + (Qtr+1) + ": ");
            
            for (int Div=0; Div< Division; Div++)
            {
                System.out.println("    Divison " + (Div+1) + " Sales: " + QDiv[Qtr][Div]);
                sum[Qtr] = QDiv[Qtr][Div] + sum[Qtr];
            }
            System.out.println("        Sum: " + sum[Qtr]);
            
            Average[Qtr] = sum[Qtr]/Division;
            System.out.println("        Average: " + Average[Qtr]);
            
            for (int Div=0; Div< Division; Div++)
            {
                if (QDiv[Qtr][Div] >= Max[Qtr])
                {
                    Max[Qtr] = QDiv[Qtr][Div];
                    HighDiv = Div;
                }            
            }
            System.out.println(
                    "        Highest Sale from: Division " + (HighDiv+1) + "\n"+
                    "        Sale = " + Max[Qtr]  + "\n");
        }
        
//Gets the QtrDiff
        double QtrDiff;
        
        for (int Qtr = 0; Qtr < Quarter - 1 ; Qtr++)
        {
          QtrDiff = sum[Qtr+1]- sum[Qtr];
          System.out.println("    Sales Difference from Quarter " + (Qtr+2) + " to " + (Qtr+1) + " : " + QtrDiff);
        }
    }
}

    
      


