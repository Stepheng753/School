
import javax.swing.JOptionPane;

public class GradeBook 
{
    public static void getInfo(int[][] Grades, String[] Names)
    {
        int[] sum = new int[5];
        
        for (int stud = 0; stud < 5; stud++)
        {
            System.out.println("Student Name: " + Names[stud]);
            
            for (int tst=0; tst < 4; tst++)
            {
                sum[stud] = Grades[stud][tst] + sum[stud];
            }
            
            System.out.println("    Sum of Test Scores: " + sum[stud]);
            int Average = (sum[stud]/4);
            System.out.println("    Average of Test Scores: " + Average);
            
            if (Average >= 90 && Average <= 100)
                System.out.println("    Letter Grade: A");
            else if (Average >= 80 && Average <= 89)
                System.out.println("    Letter Grade: B");
            else if (Average >= 70 && Average <= 79)
                System.out.println("    Letter Grade: C");
            else if (Average >= 60 && Average <= 69)
                System.out.println("    Letter Grade: D");
            else if (Average >= 0 && Average <= 59)
                System.out.println("    Letter Grade: F");
            
        }
    }
    
    public static void main(String[] args)
    {
        final int Students = 5;
        final int Tests = 4;
        int[][] Grades = new int [Students][Tests];
        String[] Names = new String[Students];
        String String;
        
        for (int index = 0; index < Students; index++)
        {
            Names[index] = JOptionPane.showInputDialog(null, "Enter Each Student's Name: ");
        }
        for (int stud = 0; stud < Students; stud++)
        {
            for (int tst=0; tst < Tests; tst++)
            {
            String = JOptionPane.showInputDialog(null, "Enter Test Score " + (tst+1) + " for: " + Names[stud]);  
            Grades [stud][tst] = Integer.parseInt(String);
            while (Grades [stud][tst] < 0 || Grades [stud][tst] > 100 )
            {
                String = JOptionPane.showInputDialog(null, "Enter Test Score " + (tst+1) + " for: " + Names[stud]);  
                Grades [stud][tst] = Integer.parseInt(String);
            }
            }
        }
        
        getInfo(Grades, Names);
    }
}


