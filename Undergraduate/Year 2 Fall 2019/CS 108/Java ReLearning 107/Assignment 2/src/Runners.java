
//JOptionPane is King
import javax.swing.JOptionPane;
        
        
public class Runners {
    
    public static void main (String[] args){
        
        String FirstName,
                SecondName,
                ThirdName;
        
        String FirstTimeString,
                SecondTimeString,
                ThirdTimeString;
        
        Double FirstTime, 
                SecondTime,
                ThirdTime;
        
        JOptionPane.showMessageDialog(null, "Please Input the Times and Names of all the Runners\nThank You!");
        
        FirstName = JOptionPane.showInputDialog("Please Input the Name of the First Runner");
    
        FirstTimeString = JOptionPane.showInputDialog("Please Input the Time of the First Runner");
 
        FirstTime = Double.parseDouble(FirstTimeString);
        
        SecondName = JOptionPane.showInputDialog("Please Input the Name of the Second Runner");
    
        SecondTimeString = JOptionPane.showInputDialog("Please Input the Time of the Second Runner");
 
        SecondTime = Double.parseDouble(SecondTimeString);
        
        ThirdName = JOptionPane.showInputDialog("Please Input the Name of the Third Runner");
    
        ThirdTimeString = JOptionPane.showInputDialog("Please Input the Time of the Third Runner");
 
        ThirdTime = Double.parseDouble(ThirdTimeString);
        
        if (FirstTime < SecondTime && SecondTime < ThirdTime)
        
        JOptionPane.showMessageDialog(null,
                "First: " + FirstName + " at " + FirstTime + " Minutes.\n" +
                "Second: " + SecondName + " at " + SecondTime + " Minutes.\n" +
                "Third: " + ThirdName + " at " + ThirdTime + " Minutes.\n");
        
        else if (FirstTime < ThirdTime && ThirdTime < SecondTime)
        
        JOptionPane.showMessageDialog(null,
                "First: " + FirstName + " at " + FirstTime + " Minutes.\n" +
                "Second: " + ThirdName + " at " + ThirdTime + " Minutes.\n"+
                "Third: " + SecondName + " at " + SecondTime + " Minutes.\n");
        
        else if (SecondTime < FirstTime && FirstTime <ThirdTime)
        
        JOptionPane.showMessageDialog(null,
                "First: " + SecondName + " at " + SecondTime + " Minutes.\n" +
                "Second: " + FirstName + " at " + FirstTime + " Minutes.\n"+
                "Third: " + ThirdName + " at " + ThirdTime + " Minutes.\n");
        
        else if (SecondTime < ThirdTime && ThirdTime < FirstTime )
        
        JOptionPane.showMessageDialog(null,
                "First: " + SecondName + " at " + SecondTime + " Minutes.\n" +
                "Second: " + ThirdName + " at " + ThirdTime + " Minutes.\n"+
                "Third: " + FirstName + " at " + FirstTime + " Minutes.\n");
        
        else if (ThirdTime < FirstTime && FirstTime < SecondTime)
        
        JOptionPane.showMessageDialog(null,
                "First: " + ThirdName + " at " + ThirdTime + " Minutes.\n" +
                "Second: " + FirstName + " at " + FirstTime + " Minutes.\n"+
                "Third: " + SecondName + " at " + SecondTime + " Minutes.\n");
        
        else if (ThirdTime < SecondTime && SecondTime < FirstTime)
        
        JOptionPane.showMessageDialog(null,
                "First: " + ThirdName + " at " + ThirdTime + " Minutes.\n" +
                "Second: " + SecondName + " at " + SecondTime + " Minutes.\n" +
                "Third: " + FirstName + " at " + FirstTime + " Minutes.\n");
        
        
    } 
    
}
