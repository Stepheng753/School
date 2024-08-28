package ParkingTicketSim;

public class Officer 
{
    String  OName,
            OBadgeNum;
    
    public String DisplayInfo()
    {
        return ("Police Officer Information: " + "\n"
               +"Name: " + OName + "\n"
               +"Badge Number: " + OBadgeNum);
    }
    
    Officer(String Name, String BdgNum)
    {
        OName = Name;
        OBadgeNum = BdgNum;
    }
}
