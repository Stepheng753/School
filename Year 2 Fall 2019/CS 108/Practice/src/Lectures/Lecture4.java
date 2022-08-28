package Lectures;

public class Lecture4
{
    public static void main (String [] args)
    {
        Test Constructor = new Test();  // Constructor
        Test OConstructor = new Test(5);    // Overloaded Constructor
        Test Trial = new Test();

        Constructor.printName();
        OConstructor.printName();
        Trial.setName("Henry");
        Trial.printName();


    }
}

class Test
{
    private String name;
    // All Encapsulated in Class Test

    public Test()       // Constructor
    {
        name = "Bob";
    }

    public Test(int n)  // Overloaded Constructor
    {
        name = "Bobby";
    }

    // Setter
    public void setName (String name)
    {
        this.name = name;
        // This. - Reference
        // = Pass By Value - copies 'name' into 'this.name'
    }

    // Getter + Private Helper Method
    private String getName ()
    {
        return name;
    }

    public void printName()
    {
        System.out.println(getName());
        trueOrFalse();
    }

    // Private Helper Method
    private void trueOrFalse()
    {
        if (name == "Henry")
        {
            System.out.println("Correct Name! ");
        }
        else
        {
            System.out.println("Fake Name! ");
        }
    }

}

class Lecture4Vocab
{
    /**
     *  Class - constructs a NEW TYPE that can GROUP DATA AND METHODS to form an OBJECT
     *  Class Public Member Methods - all OPERATIONS a class user perform on the object
     *  NEW operator - explicitly ALLOCATES AN OBJECT of the specified CLASS TYPE
     *  the "." (Dot) Operator - known as the member access operator - invokes a method on an object
     *
     *  A class can contain PRIVATE or PUBLIC variables - Fields
     *  Variables + Members - Class Members
     *
     *  Private - Only Accessible within own Class
     *  Package - DEFAULT - Only Accessible within own Package
     *  Public - Accessible from any class
     *
     *  Abstraction - Have the User interact with an item at a high level
     *              - Lower level internal details are hidden from User
     *  Encapsulation - Wrapping of data and code (Variables and Methods) under a single unit (a class)
     *
     * Mutators and Accessors - Getters and Setters
     *      - Getter - Accessors - returns certain values
     *      - Setter - Mutator - void return type - sets Value for variable
     * Allow Access to hidden Data
     *
     * Private Helper Method - Methods with private access modifier
     *      - The type of method usually is used to help a public method carry out a task
     *
     * Constructors - block of code within a class that only gets called when an object get INITIALLY created
     *      - Looks very similar to a method
     *      - Lacks a return type - Always has same name as class
     *      - Initializes all variables
     *          - Default Constructors - No Input Parameters
     *          - Constructor Overloading - has Input Parameters
     *
     * Reference - a variable type that refers to an object
     *      - can be thought as storing the memory address of an object
     *
     * New Operator - allocates memory for an object, then returns a reference to the objects location in memory
     *
     * Primitive type - variables DIRECTLY STORES the data for that variable type such as int, double, char
     *      - Ex: int num = 20; - declares an int that directly stores the data 20
     *
     * Reference type - variable can REFER TO AN INSTANCE OF A CLASS (OBJECT) via the objects memory address
     *
     * When assigning a variable to another variable, the value at the memory location of the first variable
     *                                                  get copied to the memory location of the second variable
     *
     * This also occurs when passing a variable as an input to a method
     *
     **/
}

