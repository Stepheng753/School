

public class BiggerThan 
{
    public static void Bigger1(int[] Array1, int n1)
    {
        System.out.print("The Numbers Greater than " + n1 + " In the Array {");
        
                for (int index=0;index <=5; index++)
                {
                   System.out.print(Array1[index] + ", " );
                }
                
        System.out.print(Array1[6] + "} are: \n");
        
        for (int index = 0; index <= 6; index++ )
        {
            
            if (Array1[index] > n1)
            {
                System.out.println(Array1[index]);
            }
        }
    }
    
    public static void Bigger2(int[] Array2, int n2)
    {
        System.out.print("The Numbers Greater than " + n2 + " In the Array {");
        
                for (int index=0;index <=2; index++)
                {
                   System.out.print(Array2[index] + ", " );
                }
                
        System.out.print(Array2[3] + "} are: \n");
        
        for (int index = 0; index <= 3; index++ )
        {
            if (Array2[index] > n2)
            {
                System.out.println(Array2[index]);
            }
        }
    }
    
    public static void main(String[] args)
    {
        int n1 = 3;
        int[] Array1 = {1,5,10,2,4,-3,6};
        
        int n2 = 12;
        int[] Array2 = {10,12,15,24};
        
        Bigger1(Array1, n1);        
        Bigger2(Array2, n2);        
    }
    
}
