
//Scanner Sucks
import javax.swing.JOptionPane;

public class LandTract 
{
    public static void getArea(int Length, int Width, String LandTract)
    {
        int Area;
        Area = Length * Width;
        System.out.println("The Area of the " + LandTract + " Tract of Land: " + Area);
    }
    public static void Equals(int Length1, int Width1, int Length2, int Width2)
    {
        if (Length1 == Length2 && Width1 == Width2)
        {
            System.out.println("The Two Tracts of Land are the Same Size!");
        }
        if (Length1 == Width2 && Width1 == Length2)
        {
            System.out.println("The Two Tracts of Land are the Same Size!");
        }
        else 
        {
            System.out.println("The Two Tracts of Land are NOT the Same Size!");
        }
    }
    public static void getInfo(int Length, int Width, String LandTract)
    {
        System.out.println("The " + LandTract + " Tract of Land has a \n"
                          +"    Length of: " + Length + " and a Width of: " + Width);
    }
    public static void main (String[] args)
    {
        String LengthStr1,
                WidthStr1,
                LengthStr2,
                WidthStr2,
                LandTract1 = "First",
                LandTract2 = "Second";
        
        int    Length1,
                Width1,
                Length2,
                Width2;     
        
        JOptionPane.showMessageDialog(null, "We Will Compare 2 Land Tracts");
        
        LengthStr1 = JOptionPane.showInputDialog("Please Enter The Integer Length of the First Tract of Land: ");
        Length1 = Integer.parseInt(LengthStr1);
        while (Length1 < 0)
        {
            LengthStr1 = JOptionPane.showInputDialog("Please Enter The Integer Length of the First Tract of Land: ");
            Length1 = Integer.parseInt(LengthStr1);
        }
        
        WidthStr1 = JOptionPane.showInputDialog("Please Enter The Integer Width of the First Tract of Land: ");
        Width1 = Integer.parseInt(WidthStr1);
        while (Width1 < 0)
        {
            WidthStr1 = JOptionPane.showInputDialog("Please Enter The Integer Width of the First Tract of Land: ");
            Width1 = Integer.parseInt(WidthStr1);
        }
        
        LengthStr2 = JOptionPane.showInputDialog("Please Enter The Integer Length of the Second Tract of Land: ");
        Length2 = Integer.parseInt(LengthStr2);
        while (Length2 < 0)
        {
            LengthStr2 = JOptionPane.showInputDialog("Please Enter The Integer Length of the Second Tract of Land: ");
            Length2 = Integer.parseInt(LengthStr2);
        }
        
        WidthStr2 = JOptionPane.showInputDialog("Please Enter The Integer Width of the Second Tract of Land: ");
        Width2 = Integer.parseInt(WidthStr2);
        while (Width2 < 0)
        {
            WidthStr2 = JOptionPane.showInputDialog("Please Enter The Integer Width of the Second Tract of Land: ");
            Width2 = Integer.parseInt(WidthStr2);
        }
        
        getInfo(Length1, Width1, LandTract1);
        getInfo(Length2,Width2,LandTract2);
        getArea(Length1,Width1,LandTract1);
        getArea(Length2,Width2,LandTract2);
        Equals(Length1, Width1, Length2, Width2);      
    }
}
