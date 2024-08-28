package Lectures;

public class Lecture2
{
    public static void main(String[] args)
    {
        // Branches
        {
            int x;
            x = 2;

            if (x < 0) {
                System.out.println("X is less than 0");
            } else if (x < 3) {
                System.out.println("X is less than 3 and greater than 0");
            } else {
                System.out.println("X is greater than 0");
            }
        }

        // Loops
        {
        boolean b = true;
        int y = 0;

        while (b) {
            if (y > 5) {
                System.out.println("Y is now 6");
                b = false;
            } else {
                System.out.println("The value of y is: " + y);
                y++;
            }
        }
        }

        // More Loops
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("The Value of i is: " + i);
            }
            // int i = 0    |   Initializes Loop Value  (Start)
            // i < 5        |   Condition  (End)
            // i++          |   Updater
        }

        // Nested Loops
        {
            int k = 1;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.println(k + ": How many Times Do I Print?");
                    k++;
                }
            }
        }

        // Arrays
        {
            // Type [Dimensions] Name = {Contents of Type};
            String[] Array1 = {"Hello World", "FooBar", "Something Else"};

            // Type [Dimensions] Name = new Type [Count of Contents];
            String[] Array2 = new String[3];
            Array2[0] = "Hello World";
            Array2[1] = "FooBar";
            Array2[2] = "Something Else";

            int[] intArray = new int[]{1, 2, 3, 4};
            System.out.println(intArray[0]);   //  Print Index 0
//          System.out.println(intArray [4]);   |  ArrayIndexOutOfBoundsException

            for (int i = 0; i < 4; i++) {
                System.out.println("Element at index: " + i + " is: " + intArray[i]);
            }
        }

        //Method Tester
        {
            Lecture2 instant = new Lecture2();
            System.out.println(instant.addFive(800000000));
        }
    }

    //Methods
    public long addFive ( long a)
    {
        a += 5;
        return a;
    }
    // Access Modifier  - Public
    // Return Type      - Int
    // Method Name      - addFive
    // Parameter        - int a



}
