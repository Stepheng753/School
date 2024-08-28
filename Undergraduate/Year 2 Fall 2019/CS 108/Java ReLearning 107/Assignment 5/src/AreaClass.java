
//JOptionPane bc I dont understand Scanner
import javax.swing.JOptionPane;


public class AreaClass 
{
    public static void getArea(double Radius)
    {
        double Area;
        Area = (Math.PI)* Math.pow(Radius, 2);
        System.out.printf("The Area of the Circle with Radius " + Radius + " is: %.4f\n" , Area);
    }
    public static void getArea(double Length, double Width)
    {
        double Area;
        Area = Length * Width;
        System.out.printf("The Area of the Retangle \n"
                        + "   with Length " + Length + " and Width " + Width + " is: %.4f\n", Area);
    }
    public static void getArea1(double Radius, double Height)
    {
        double Area;
        Area = (Math.PI)* Math.pow(Radius, 2) * Height;
        System.out.printf("The Area of the Cylinder \n"
                        + "   with Radius " + Radius + " and Height " + Height + " is: %.4f\n" , Area);
    }
    public static void main(String[] args)
    {
        String Choice,
                RadiusStr,
                LengthStr,
                WidthStr,
                HeightStr;
        double Radius,
                Length,
                Width,
                Height;
        
        Choice = JOptionPane.showInputDialog("What Would You Like to Know the Area of?\n"
                                            +"Circle, Rectangle, or Cylinder?");
        
        if (Choice.equalsIgnoreCase("Circle"))
        {
            RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
            Radius = Double.parseDouble(RadiusStr);
            while (Radius < 0)
            {
               RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
               Radius = Double.parseDouble(RadiusStr); 
            }
            getArea(Radius);
        }
        
        if (Choice.equalsIgnoreCase("Rectangle"))
        {
            LengthStr = JOptionPane.showInputDialog("Please Enter the Length: ");
            Length = Double.parseDouble(LengthStr);
            while (Length < 0)
            {
               LengthStr = JOptionPane.showInputDialog("Please Enter the Length: ");
               Length = Double.parseDouble(LengthStr);
            }
            
            WidthStr = JOptionPane.showInputDialog("Please Enter the Width: ");
            Width = Double.parseDouble(WidthStr);
            while (Width < 0)
            {
               WidthStr = JOptionPane.showInputDialog("Please Enter the Width: ");
               Width = Double.parseDouble(WidthStr);
            }
            getArea(Length, Width);
        }
        
        if (Choice.equalsIgnoreCase("Cylinder"))
        {
            RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
            Radius = Double.parseDouble(RadiusStr);
            while (Radius < 0)
            {
               RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
               Radius = Double.parseDouble(RadiusStr); 
            }
            
            HeightStr = JOptionPane.showInputDialog("Please Enter the Height: ");
            Height = Double.parseDouble(HeightStr);
            while (Height < 0)
            {
               HeightStr = JOptionPane.showInputDialog("Please Enter the Height: ");
               Height = Double.parseDouble(HeightStr);
            }
            getArea1(Radius, Height);
        }
        else
            while (!Choice.equalsIgnoreCase("Circle") && !Choice.equalsIgnoreCase("Rectangle") && !Choice.equalsIgnoreCase("Cylinder") )
            {
            Choice = JOptionPane.showInputDialog("What Would You Like to Know the Area of?\n"
                                            +"Circle, Rectangle, or Cylinder?");
        
            if (Choice.equalsIgnoreCase("Circle"))
            {
            RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
            Radius = Double.parseDouble(RadiusStr);
            while (Radius < 0)
            {
               RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
               Radius = Double.parseDouble(RadiusStr); 
            }
            getArea(Radius);
            }
        
            if (Choice.equalsIgnoreCase("Rectangle"))
            {
            LengthStr = JOptionPane.showInputDialog("Please Enter the Length: ");
            Length = Double.parseDouble(LengthStr);
            while (Length < 0)
            {
               LengthStr = JOptionPane.showInputDialog("Please Enter the Length: ");
               Length = Double.parseDouble(LengthStr);
            }
            
            WidthStr = JOptionPane.showInputDialog("Please Enter the Width: ");
            Width = Double.parseDouble(WidthStr);
            while (Width < 0)
            {
               WidthStr = JOptionPane.showInputDialog("Please Enter the Width: ");
               Width = Double.parseDouble(WidthStr);
            }
            getArea(Length, Width);
            }
        
            if (Choice.equalsIgnoreCase("Cylinder"))
            {
            RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
            Radius = Double.parseDouble(RadiusStr);
            while (Radius < 0)
            {
               RadiusStr = JOptionPane.showInputDialog("Please Enter the Radius: ");
               Radius = Double.parseDouble(RadiusStr); 
            }
            
            HeightStr = JOptionPane.showInputDialog("Please Enter the Height: ");
            Height = Double.parseDouble(HeightStr);
            while (Height < 0)
            {
               HeightStr = JOptionPane.showInputDialog("Please Enter the Height: ");
               Height = Double.parseDouble(HeightStr);
            }
            getArea1(Radius, Height);
            }
            }  
    }
}
