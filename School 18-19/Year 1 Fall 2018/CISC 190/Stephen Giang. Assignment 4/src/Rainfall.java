import java.util.Scanner;
public class Rainfall
{
    public static void main(String[] args)  
    {
        Scanner Keyboard = new Scanner(System.in);
        
        double  January,
                February,
                March,
                April,
                May,
                June,
                July,
                August,
                September,
                October,
                November,
                December,
                Sum,
                Average,
                Max,
                Min;
               
                
       
                
        System.out.print("Enter Rainfal for January: ");
        January = Keyboard.nextDouble();
        while (January < 0)
        {   System.out.print("Enter Rainfal for January: ");
            January = Keyboard.nextDouble(); }
        Max = January;
        Min = January;
        

        
        System.out.print("Enter Rainfal for February: ");
        February = Keyboard.nextDouble();
        while (February < 0)
        {   System.out.print("Enter Rainfal for February: ");
            February = Keyboard.nextDouble(); }
        if (February > Max)
            Max = February;
        else if (February < Min)
            Min = February;
         

        
        System.out.print("Enter Rainfal for March: ");
        March = Keyboard.nextDouble();
        while (March < 0)
        {   System.out.print("Enter Rainfal for March: ");
            March = Keyboard.nextDouble(); }
        if (March > Max)
            Max = March;
        else if (March < Min)
            Min = March;
        
        
        
        System.out.print("Enter Rainfal for April: ");
        April = Keyboard.nextDouble();
        while (April < 0)
        {   System.out.print("Enter Rainfal for April: ");
            April = Keyboard.nextDouble(); }
        if (April > Max)
            Max = April;
        else if (April < Min)
            Min = April;
         
        
         
        System.out.print("Enter Rainfal for May: ");
        May = Keyboard.nextDouble();
        while (May < 0)
        {   System.out.print("Enter Rainfal for May: ");
            May = Keyboard.nextDouble(); }
        if (May > Max)
            Max = May;
        else if (May < Min)
            Min = May;
        
        
        
        System.out.print("Enter Rainfal for June: ");
        June = Keyboard.nextDouble();
        while (June < 0)
        {   System.out.print("Enter Rainfal for June: ");
            June = Keyboard.nextDouble(); }
        if (June > Max)
            Max = June;
        else if (June < Min)
            Min = June;
        
        
        
        System.out.print("Enter Rainfal for July: ");
        July = Keyboard.nextDouble();
        while (July < 0)
        {   System.out.print("Enter Rainfal for July: ");
            July = Keyboard.nextDouble(); }
        if (July > Max)
            Max = July;
        else if (July < Min)
            Min = July;
        
        
        
        System.out.print("Enter Rainfal for August: ");
        August = Keyboard.nextDouble();
        while (August < 0)
        {   System.out.print("Enter Rainfal for August: ");
            August = Keyboard.nextDouble(); }
        if (August > Max)
            Max = August;
        else if (August < Min)
            Min = August;
        
        
        
        System.out.print("Enter Rainfal for September: ");
        September = Keyboard.nextDouble();
        while (September < 0)
        {   System.out.print("Enter Rainfal for September: ");
            September = Keyboard.nextDouble(); }
        if (September > Max)
            Max = September;
        else if (September < Min)
            Min = September;
        
        
        
        System.out.print("Enter Rainfal for October: ");
        October = Keyboard.nextDouble();
        while (October < 0)
        {   System.out.print("Enter Rainfal for October: ");
            October = Keyboard.nextDouble(); }
        if (October > Max)
            Max = October;
        else if (October < Min)
            Min = October;
        
        
        
        System.out.print("Enter Rainfal for November: ");
        November = Keyboard.nextDouble();
        while (November < 0)
        {   System.out.print("Enter Rainfal for November: ");
            November = Keyboard.nextDouble(); }
        if (November > Max)
            Max = November;
        else if (November < Min)
            Min = November;
        
        
        System.out.print("Enter Rainfal for December: ");
        December = Keyboard.nextDouble();
        while (December < 0)
        {   System.out.print("Enter Rainfal for December: ");
            December = Keyboard.nextDouble(); }
        if (December > Max)
            Max = December;
        else if (December < Min)
            Min = December;
        
       Sum = January + February + March + April + May + June 
               + July + August + September + October + November + December;
       
       Average = Sum/12;      
        
       System.out.print("The Sum is : ");
       System.out.println(Sum);
       
       System.out.print("The Average Rainfall in the Year was: ");
       System.out.println(Average);
       
       System.out.print("The Most Amount of Rainfall in the Year was: ");
       System.out.println(Max);
       
       System.out.print("The Least Amount of Rainfall in the Year was: ");
       System.out.println(Min);
      
    }
}