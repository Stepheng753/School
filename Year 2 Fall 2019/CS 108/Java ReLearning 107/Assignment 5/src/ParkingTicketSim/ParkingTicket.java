package ParkingTicketSim;

public class ParkingTicket 
{
    String  PTMake,
            PTModel,
            PTColor,
            PTLicNum;
    int     PTMinParked,
            PTMinPurchased;
    
    ParkingTicket(String Mk, String Ml, String C, String LN, int MPkd, int MPrsh )
    {
        PTMake = Mk;
        PTModel = Ml;
        PTColor = C;
        PTLicNum = LN;
        PTMinParked = MPkd;
        PTMinPurchased = MPrsh;
    }
    
    public String Report()
    {
        int Fine;
        int Diff = PTMinParked - PTMinPurchased;
        Double DDiff = new Double (Diff);
        
        for (int x=0; x<=24; x ++)
        {
            if ((DDiff/60) > x && (DDiff/60) <= x+1)
            {
                Fine = (10*x) + 25;
                String Str = "Vehicle is ILLEGALLY PARKED" + "\n" 
                           +"    Fine: $" + Fine + "\n";
                return Str;
            }
            else if (DDiff <= 0) 
                    {
                       return ("No Crime Committed \n"); 
                    }
        }
        return ("Parked Overnight, TOW AWAY" + "\n");
    }   
//------------------------------------------------------------------------------------------------------------------------------------------------------------//


 
 
}    

