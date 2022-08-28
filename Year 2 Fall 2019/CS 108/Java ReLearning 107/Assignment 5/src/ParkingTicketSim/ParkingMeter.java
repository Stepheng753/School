package ParkingTicketSim;

public class ParkingMeter 
{
    int PMMinPurchased;
    
    public String DisplayInfo()
    {
        return("Minutes Purchased: " + PMMinPurchased + "\n");
    }
    
    ParkingMeter(int MPrsh)
    {
        PMMinPurchased = MPrsh;
    }
}