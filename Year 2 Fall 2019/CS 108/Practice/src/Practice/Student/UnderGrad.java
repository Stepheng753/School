package Practice.Student;

public class UnderGrad extends Student
{
    String Yes,
            No;

    public void setInfo(int numOfClasses, long debt, Character burnOut )
    {
        try
        {
            if (numOfClasses < 0)
            {
                throw new Exception("You cannot have negative classes");
            }
            if (numOfClasses ==0)
            {
                throw new ArithmeticException("Can't divide by 0");
            }
        }
        catch (ArithmeticException AEx)
        {
            System.out.println(AEx.getMessage());
        }
        catch (Exception Ex)
        {
            System.out.println(Ex.getMessage());
        }

        this.numOfClasses = numOfClasses;
        this.debt = debt;
        this.burnOut = Character.toUpperCase(burnOut);
        hoursTotal = 40;
        this.hoursPerClass = hoursTotal/numOfClasses;


    }

    public void printInfo()
    {
        System.out.println("Number of Classes: " + numOfClasses);
        System.out.println("Debt: " + debt);
        System.out.println("Burnout: " + burnOut);
        System.out.println("HoursTotal: " + hoursTotal);
        System.out.println("Hours Per Class: " + hoursPerClass);


    }


}
