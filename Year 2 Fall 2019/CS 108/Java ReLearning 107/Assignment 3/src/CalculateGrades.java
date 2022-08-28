
//JOptionPane is my Favorite
import javax.swing.JOptionPane;

public class CalculateGrades 
{

public static void calcAverage(double Test1,double Test2,double Test3,double Test4,double Test5)
{

    double Average;
    
    Average = Math.round (((Test1 + Test2 + Test3 + Test4 + Test5)/5)*100)/100.0;
    
    JOptionPane.showMessageDialog(null, "Test Score 1: " + Test1 + "\n" +
                                        "Test Score 2: " + Test2 + "\n" +
                                        "Test Score 3: " + Test3 + "\n" +
                                        "Test Score 4: " + Test4 + "\n" +
                                        "Test Score 5: " + Test5 + "\n" +
                                        "The Average is: " + Average );
  
}

public static void determineGrade(double Test1,double Test2,double Test3,double Test4,double Test5)
{
    String LetterGrade1 = "No Grade",
            LetterGrade2 = "No Grade",
            LetterGrade3 = "No Grade",
            LetterGrade4 = "No Grade",
            LetterGrade5 = "No Grade";
    
    if (90 <= Test1 && Test1 <= 100 )
        LetterGrade1 = "A";
    
    else if (80 <= Test1 && Test1 < 90 )
        LetterGrade1 = "B";
    
    else if (70 <= Test1 && Test1 < 80 )
        LetterGrade1 = "C";
    
    else if (60 <= Test1 && Test1 < 70 )
        LetterGrade1 = "D";
    
    else if (Test1 < 60)
        LetterGrade1 = "F";

    if (90 <= Test2 && Test2 <= 100 )
        LetterGrade2 = "A";
    
    else if (80 <= Test2 && Test2 < 90 )
        LetterGrade2 = "B";
    
    else if (70 <= Test2 && Test2 < 80 )
        LetterGrade2 = "C";
    
    else if (60 <= Test2 && Test2 < 70 )
        LetterGrade2 = "D";
    
    else if (Test2 < 60)
        LetterGrade2 = "F";
    
    if (90 <= Test3 && Test3 <= 100 )
        LetterGrade3 = "A";
    
    else if (80 <= Test3 && Test3 < 90 )
        LetterGrade3 = "B";
    
    else if (70 <= Test3 && Test3 < 80 )
        LetterGrade3 = "C";
    
    else if (60 <= Test3 && Test3 < 70 )
        LetterGrade3 = "D";
    
    else if (Test3 < 60)
        LetterGrade3 = "F";
    
    if (90 <= Test4 && Test4 <= 100 )
        LetterGrade4 = "A";
    
    else if (80 <= Test4 && Test4 < 90 )
        LetterGrade4 = "B";
    
    else if (70 <= Test4 && Test4 < 80 )
        LetterGrade4 = "C";
    
    else if (60 <= Test4 && Test4 < 70 )
        LetterGrade4 = "D";
    
    else if (Test4 < 60)
        LetterGrade4 = "F";
    
    if (90 <= Test5 && Test5 <= 100 )
        LetterGrade5 = "A";
    
    else if (80 <= Test5 && Test5 < 90 )
        LetterGrade5 = "B";
    
    else if (70 <= Test5 && Test5 < 80 )
        LetterGrade5 = "C";
    
    else if (60 <= Test5 && Test5 < 70 )
        LetterGrade5 = "D";
    
    else if (Test5 < 60)
        LetterGrade5 = "F";  
    
    JOptionPane.showMessageDialog(null, "Test Score 1: " + Test1 + "\n" +
                                        "   LetterGrade: " + LetterGrade1 + "\n" +
                                        "Test Score 2: " + Test2 + "\n" +
                                        "   LetterGrade: " + LetterGrade2 + "\n" +
                                        "Test Score 3: " + Test3 + "\n" +
                                        "   LetterGrade: " + LetterGrade3 + "\n" +
                                        "Test Score 4: " + Test4 + "\n" +
                                        "   LetterGrade: " + LetterGrade4 + "\n" +
                                        "Test Score 5: " + Test5 + "\n" +
                                        "   LetterGrade: " + LetterGrade5 + "\n");
    
}
    public static void main (String [] args)
    {
        String Test1String,
            Test2String,
            Test3String,
            Test4String,
            Test5String;
        
        double Test1,
                Test2,
                Test3,
                Test4,
                Test5;
    
    Test1String = JOptionPane.showInputDialog("Enter Test Score #1: ");
    Test2String = JOptionPane.showInputDialog("Enter Test Score #2: ");
    Test3String = JOptionPane.showInputDialog("Enter Test Score #3: ");
    Test4String = JOptionPane.showInputDialog("Enter Test Score #4: ");
    Test5String = JOptionPane.showInputDialog("Enter Test Score #5: ");
    
    Test1 = Double.parseDouble(Test1String);
    Test2 = Double.parseDouble(Test2String);
    Test3 = Double.parseDouble(Test3String);
    Test4 = Double.parseDouble(Test4String);
    Test5 = Double.parseDouble(Test5String);
    
        calcAverage(Test1, Test2, Test3, Test4, Test5);
        determineGrade(Test1, Test2, Test3, Test4, Test5);
        
    }
}
