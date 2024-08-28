
// Option Pane is best
import javax.swing.JOptionPane;
        
        
public class SoftwareSales {
    
    public static void main (String[] args){
        
        int NumberOfPackages;
        String StringInput;
        double Discount =0,
               Total = 0,
               PriceOfPackage = 99; 
                
        
        JOptionPane.showMessageDialog
        (null, "Hello, Thank you for choosing Sky Net!\n"
                + "We Offer Packages Starting at $99\n"
                + "And We Offer Amazing Discounts!");
        
        StringInput = JOptionPane.showInputDialog("How Many Packages will you like to Purchase?");
        
        NumberOfPackages = Integer.parseInt(StringInput);
        
        if (0<= NumberOfPackages & NumberOfPackages <= 9)
            
           Discount = 0;
        
        if (10<= NumberOfPackages & NumberOfPackages <= 19)
            
           Discount = .2;
        
        if (20<= NumberOfPackages & NumberOfPackages <= 49)
           
           Discount = .3;
        
        if (50 <= NumberOfPackages & NumberOfPackages <= 99)

           Discount = .4;
        
        if (NumberOfPackages >= 100)
        
           Discount = .5;
        
        else if (NumberOfPackages <= 0)
        
            JOptionPane.showMessageDialog(null, "INVALID NUMBER");
        
        Total = (PriceOfPackage * NumberOfPackages) * (1 - Discount);
        
        JOptionPane.showMessageDialog(null, "Each Package Cost:" + PriceOfPackage + "\n" +
                                            "You Ordered " + NumberOfPackages + " Packages" + "\n" +
                                            "So you are eligible for a " + (Discount * 100) + "% Discount." + "\n" +
                                            "You're Total is: " + Total + "\n" +
                                            "You saved " + (PriceOfPackage * NumberOfPackages * Discount) + " Dollars.");
        
        System.exit(0);
    }    
    }
   

