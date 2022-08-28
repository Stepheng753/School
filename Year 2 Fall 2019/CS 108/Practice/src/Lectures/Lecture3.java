package Lectures;

public class Lecture3
{
    public static void main(String [] args)
    {

        // Comments
        {
            char letter1 = 'a';
            char letter2;       // The value of this variable will exclusively alternate between a, b, and c

            //Loop until letter1 has reached the end of the alphabet
            while (letter1 <= 'z') {
                letter2 = 'a';

                //Loop through all possible combinations with Letter1 with a,b,c
                while (letter2 <= 'c') {
                    System.out.println("" + letter1 + letter2 + "");
                    letter2++;
                }

                ++letter1;
            }
        }

        // 2D Arrays
        {
            int numOfArrays = 2;
            int numOfElementsPerArray = 3;
            int[][] x = new int[numOfArrays][numOfElementsPerArray];

            int[][] y = {{1, 2, 3}, {6, 5, 4}};
            y[0][0] = 1;
            y[0][1] = 2;
            y[0][2] = 3;
            y[1][0] = 6;
            y[1][1] = 5;
            y[1][2] = 4;
        }

        // Classes v Objects
        {
            // Class = Blueprint for many buildings     (Blueprint for Instances)
            // Object = Different Buildings             (Instances)

            // All Objects
            Lecture3 Example = new Lecture3();
            Lecture3 Object = new Lecture3();
            Lecture3 Instance = new Lecture3();

                // Scope - Wherever the object has control of:
                // For Example: A variable declared at the top of Class - Has Scope of Everything Below
                           //   A variable declared in a Method - Has Scope of Everything in the Method
        }

    }
}
