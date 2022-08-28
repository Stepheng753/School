
//JOptionPane4Lyfe
import javax.swing.JOptionPane;

public class SpeedOfSound {
    
    public static void main (String[] arg){
        
        JOptionPane.showMessageDialog(null, "Hello!  This Program Will Tell You How Long it Takes for \nSound to Travel Through Certain Objects over a Specified Time");
        
        String Option,
                DistanceString;
        Double Time,
                Distance;
        
        int    Velocity = 0;
        
        Option = JOptionPane.showInputDialog("Would You Like to know about Air, Water, Or Steel");
        
        DistanceString = JOptionPane.showInputDialog("Please Enter a Distance in Feet for Sound to travel through: " + Option);
        
        Distance = Double.parseDouble(DistanceString);
        
        if (Option.equalsIgnoreCase("air")){
            
            Velocity = 1100;
            Time = Distance / Velocity; 
            
            JOptionPane.showMessageDialog(null,
                "For sound to travel " + Distance + " Feet through " + Option + "\n" +
                "It will take " + Time + "Seconds.");
            
            }
            
            else if (Option.equalsIgnoreCase("water")){
            
            Velocity = 4900;
            Time = Distance / Velocity; 
            
            JOptionPane.showMessageDialog(null,
                "For sound to travel " + Distance + " Feet through " + Option + "\n" +
                "It will take " + Time + "Seconds.");
            
            }
    
            else if (Option.equalsIgnoreCase("steel")){
            
            Velocity = 16400;
            Time = Distance / Velocity; 
            
        JOptionPane.showMessageDialog(null,
                "For sound to travel " + Distance + " Feet through " + Option + "\n" +
                "It will take " + Time + "Seconds.");
        
            }
                
            else 
        
        JOptionPane.showMessageDialog(null, "Sorry, You Must Enter either Air, Water, or Steel.");    
            
        }
    }
            

