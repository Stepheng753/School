package ParkingTicketSim;

public class ParkedCar 
{
    String  PCMake,
            PCModel,
            PCColor,
            PCLicNum;
    int     PCMinParked;
    
    public String DisplayInfo()
            {
                return ("Car Information: " + "\n" 
                       +"Make: " + PCMake + "\n"
                       +"Model: " + PCModel + "\n"
                       +"Color: " + PCColor + "\n"
                       +"License Number: " + PCLicNum + "\n\n"
                       +"Minutes Parked: " + PCMinParked);
            }
    
    ParkedCar(String Mk, String Ml, String C, String LN, int MPkd)
    {
        PCMake = Mk;
        PCModel = Ml;
        PCColor = C;
        PCLicNum = LN;
        PCMinParked = MPkd;
    }
            
}
