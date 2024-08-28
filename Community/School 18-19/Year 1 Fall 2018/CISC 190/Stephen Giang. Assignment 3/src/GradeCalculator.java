import java.util.Scanner;
public class GradeCalculator  
{
    public static void main(String[] args)  
    {
        Scanner Keyboard = new Scanner(System.in);
        
        double score1,
                score2,
                score3,
                score4,
                score5,
                calcAverage;
        
        System.out.print("Enter Test Score 1: ");
        score1 = Keyboard.nextDouble();
        if (score1<60)
            System.out.println("Test Score Grade: F");
        else if (score1<70)
            System.out.println("Test Score Grade: D");
        else if (score1<80)
            System.out.println("Test Score Grade: C");
        else if (score1<90)
            System.out.println("Test Score Grade: B");
        else if (score1 >= 90)
            System.out.println("Test Score Grade: A");
        
        System.out.print("Enter Test Score 2: ");
        score2 = Keyboard.nextDouble();
         if (score2<60)
            System.out.println("Test Score Grade: F");
        else if (score2<70)
            System.out.println("Test Score Grade: D");
        else if (score2<80)
            System.out.println("Test Score Grade: C");
        else if (score2<90)
            System.out.println("Test Score Grade: B");
        else if (score2 >= 90)
            System.out.println("Test Score Grade: A");
         
        System.out.print("Enter Test Score 3: ");
        score3 = Keyboard.nextDouble();
         if (score3<60)
            System.out.println("Test Score Grade: F");
        else if (score3<70)
            System.out.println("Test Score Grade: D");
        else if (score3<80)
            System.out.println("Test Score Grade: C");
        else if (score3<90)
            System.out.println("Test Score Grade: B");
        else if (score3 >= 90)
            System.out.println("Test Score Grade: A");
         
        System.out.print("Enter Test Score 4: ");
        score4 = Keyboard.nextDouble();
         if (score4<60)
            System.out.println("Test Score Grade: F");
        else if (score4<70)
            System.out.println("Test Score Grade: D");
        else if (score4<80)
            System.out.println("Test Score Grade: C");
        else if (score4<90)
            System.out.println("Test Score Grade: B");
        else if (score4 >= 90)
            System.out.println("Test Score Grade: A");
         
        System.out.print("Enter Test Score 5: ");
        score5 = Keyboard.nextDouble();
         if (score5<60)
            System.out.println("Test Score Grade: F");
        else if (score5<70)
            System.out.println("Test Score Grade: D");
        else if (score5<80)
            System.out.println("Test Score Grade: C");
        else if (score5<90)
            System.out.println("Test Score Grade: B");
        else if (score5 >= 90)
            System.out.println("Test Score Grade: A");
        
        calcAverage = (score1 + score2 + score3 + score4 + score5)/5;
        
        if (calcAverage<60)
            System.out.println("Average Test Score: " + calcAverage + "%" + "\nAverage Test Grade: F");
        else if (calcAverage<70)
            System.out.println("Average Test Score: " + calcAverage + "%" + "\nAverage Test Grade: D");
        else if (calcAverage<80)
            System.out.println("Average Test Score: " + calcAverage + "%" + "\nAverage Test Grade: C");
        else if (calcAverage<90)
            System.out.println("Average Test Score: " + calcAverage + "%" + "\nAverage Test Grade: B");
        else if (calcAverage >= 90)
            System.out.println("Average Test Score: " + calcAverage + "%" + "\nAverage Test Grade: A");      
       
    }
}