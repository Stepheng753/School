
//JOptionPane is #1
import javax.swing.JOptionPane;


public class RainFall 
{
    public static void getSum(double [] Rain)
    {
        double sum=0;
        
        for (int index =0; index <= 11; index++)
        {
            sum = sum + Rain[index];
        }
           
        System.out.println("Total Rainfall this Year: " + sum);
    }
    
     public static void getAverage(double[] Rain)
    {
        double sum=0;
        double Average=0;
        for (int index =0; index <= 11; index++)
        {
            sum = sum + Rain[index];
        }
        
        Average = sum/12;
        System.out.println("Average Rainfall this Year: " + Average);
    }
     
    public static void getMax(double[] Rain, String[] Months)
    {
        
        double Max = 0;
        String MaxMonth = "January";
        
        for (int index =0; index <= 11; index ++)
        {
            if (Rain[index] > Max)
            {
                Max = Rain[index];
                MaxMonth = Months[index];
            }
        }
        System.out.println("The Most Amount of Rainfall was: " + Max + "\n" +
                            "and Happened in: " + MaxMonth);
        
    }
    
    public static void getMin(double[] Rain, String[] Months)
    {
        
        double Min = Rain[0];
        String MinMonth = "January";
        
        for (int index =0; index <= 10; index ++)
        {
            if (Rain[index+1] < Min)
            {
                Min = Rain[index+1];
                MinMonth = Months[index+1];
            }
        }
        System.out.println("The Least Amount of Rainfall was: " + Min + "\n" +
                            "and Happened in: " + MinMonth);
        
    }
    
    
    public static void main (String [] args)
    {
        double [] Rain = new double [12];
        
        String[] Months = {"January", "February", "March", "April", "May", "June", "July", "August", "Septmeber", "October", "November", "December"};
        
        JOptionPane.showMessageDialog(null, "Please Enter in the Rainfall in inches for Every Month of the Year.");
        
        String JanString,
                FebString,
                MarString,
                AprString,
                MayString,
                JunString,
                JulString,
                AugString,
                SepString,
                OctString,
                NovString,
                DecString;             
        
        JanString = JOptionPane.showInputDialog("Enter in the Rainfall for January: ");
        Rain[0] = Double.parseDouble(JanString);
                while (Rain[0] < 0)
        {
            JanString = JOptionPane.showInputDialog("Enter in the Rainfall for January: ");
            Rain[0] = Double.parseDouble(JanString);   
        }
        
        FebString = JOptionPane.showInputDialog("Enter in the Rainfall for February: ");
        Rain[1] = Double.parseDouble(FebString);
                while (Rain[1] < 0)
        {
            FebString = JOptionPane.showInputDialog("Enter in the Rainfall for February: ");
            Rain[1] = Double.parseDouble(FebString);   
        }
                
        MarString = JOptionPane.showInputDialog("Enter in the Rainfall for March: ");
        Rain[2] = Double.parseDouble(MarString);
                while (Rain[2] < 0)
        {
            MarString = JOptionPane.showInputDialog("Enter in the Rainfall for March: ");
            Rain[2] = Double.parseDouble(MarString);   
        }
        
        AprString = JOptionPane.showInputDialog("Enter in the Rainfall for April: ");
        Rain[3] = Double.parseDouble(AprString);
                while (Rain[3] < 0)
        {
            AprString = JOptionPane.showInputDialog("Enter in the Rainfall for April: ");
            Rain[3] = Double.parseDouble(AprString);  
        }
        
        MayString = JOptionPane.showInputDialog("Enter in the Rainfall for May: ");
        Rain[4] = Double.parseDouble(MayString);
                while (Rain[4] < 0)
        {
            MayString = JOptionPane.showInputDialog("Enter in the Rainfall for May: ");
            Rain[4] = Double.parseDouble(MayString);   
        }
        
        JunString = JOptionPane.showInputDialog("Enter in the Rainfall for June: ");
        Rain[5] = Double.parseDouble(JunString);
                while (Rain[5] < 0)
        {
            JunString = JOptionPane.showInputDialog("Enter in the Rainfall for June: ");
            Rain[5] = Double.parseDouble(JunString);  
        }
        
        JulString = JOptionPane.showInputDialog("Enter in the Rainfall for July: ");
        Rain[6] = Double.parseDouble(JulString);
                while (Rain[6] < 0)
        {
            JulString = JOptionPane.showInputDialog("Enter in the Rainfall for July: ");
            Rain[6] = Double.parseDouble(JulString);  
        }
        
        AugString = JOptionPane.showInputDialog("Enter in the Rainfall for August: ");
        Rain[7] = Double.parseDouble(AugString);
                while (Rain[7] < 0)
        {
            AugString = JOptionPane.showInputDialog("Enter in the Rainfall for August: ");
            Rain[7] = Double.parseDouble(AugString);  
        }
        
        SepString = JOptionPane.showInputDialog("Enter in the Rainfall for September: ");
        Rain[8] = Double.parseDouble(SepString);
                while (Rain[8] < 0)
        {
            SepString = JOptionPane.showInputDialog("Enter in the Rainfall for September: ");
            Rain[8] = Double.parseDouble(SepString);   
        }
        
        OctString = JOptionPane.showInputDialog("Enter in the Rainfall for October: ");
        Rain[9] = Double.parseDouble(OctString);
                while (Rain[9] < 0)
        {
            OctString = JOptionPane.showInputDialog("Enter in the Rainfall for October: ");
            Rain[9] = Double.parseDouble(OctString);   
        }
        
        NovString = JOptionPane.showInputDialog("Enter in the Rainfall for November: ");
        Rain[10] = Double.parseDouble(NovString);
                while (Rain[10] < 0)
        {
            NovString = JOptionPane.showInputDialog("Enter in the Rainfall for November: ");
            Rain[10] = Double.parseDouble(NovString);  
        }
        
        DecString = JOptionPane.showInputDialog("Enter in the Rainfall for December: ");
        Rain[11] = Double.parseDouble(DecString);
                while (Rain[11] < 0)
        {
            DecString = JOptionPane.showInputDialog("Enter in the Rainfall for December: ");
            Rain[11] = Double.parseDouble(DecString);   
        }
        
        
        for (int index =0; index <= 11; index++)
        {
           System.out.println("Rainfal in " + Months[index] + ": " + Rain[index]);
        }     
        
        getSum(Rain);
        getAverage(Rain);
        getMax(Rain, Months);
        getMin(Rain, Months);
        
    }
    
    
}
