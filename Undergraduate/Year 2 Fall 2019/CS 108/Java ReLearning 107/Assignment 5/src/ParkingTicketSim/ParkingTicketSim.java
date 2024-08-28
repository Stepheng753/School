package ParkingTicketSim;

import javax.swing.JOptionPane;

public class ParkingTicketSim 
{
    public static void main(String[] args)
    {
        String MainMake,
                MainModel,
                MainColor,
                MainLicNum,
                MainMinParkedStr;
        int     MainMinParked;
        
        MainMake = JOptionPane.showInputDialog("Enter the Make of the Vehicle: ");
        MainModel = JOptionPane.showInputDialog("Enter the Model of the Vehicle: ");
        MainColor = JOptionPane.showInputDialog("Enter the Color of the Vehicle: ");
        MainLicNum = JOptionPane.showInputDialog("Enter the License Number of the Vehicle: ");
        MainMinParkedStr = JOptionPane.showInputDialog("Enter the Minutes Parked of the Vehicle: ");
        MainMinParked = Integer.parseInt(MainMinParkedStr);
        while (MainMinParked < 0)
        {
            MainMinParkedStr = JOptionPane.showInputDialog("Enter the Minutes Parked of the Vehicle: ");
            MainMinParked = Integer.parseInt(MainMinParkedStr);
        }
        ParkedCar PC = new ParkedCar(MainMake, MainModel, MainColor, MainLicNum, MainMinParked);
    
//------------------------------------------------------------------------------------------------------------------------------------------------------------//        
        String  MainMinPurchasedStr;
        int     MainMinPurchased;
        
        MainMinPurchasedStr = JOptionPane.showInputDialog("Enter the Minutes Purchased of the Vehicle: ");
        MainMinPurchased = Integer.parseInt(MainMinPurchasedStr);
        while (MainMinPurchased < 0)
        {
            MainMinPurchasedStr = JOptionPane.showInputDialog("Enter the Minutes Purchased of the Vehicle: ");
            MainMinPurchased = Integer.parseInt(MainMinPurchasedStr);
        }
        ParkingMeter PM = new ParkingMeter (MainMinPurchased);        
        
//------------------------------------------------------------------------------------------------------------------------------------------------------------//
       
        ParkingTicket PT = new ParkingTicket(MainMake, MainModel, MainColor, MainLicNum, MainMinParked, MainMinPurchased);
        
//------------------------------------------------------------------------------------------------------------------------------------------------------------//

        String  MainName,
                MainBadgeNumber;
        
        MainName = JOptionPane.showInputDialog("Enter in Officer's Name: ");
        MainBadgeNumber = JOptionPane.showInputDialog("Enter in Officer's Badge Number: ");
        
        Officer PO = new Officer(MainName, MainBadgeNumber);

//------------------------------------------------------------------------------------------------------------------------------------------------------------//

        System.out.println(PC.DisplayInfo());
        System.out.println(PM.DisplayInfo());
        System.out.println(PT.Report());
        System.out.println(PO.DisplayInfo());
    }
    
}
