
//Program 1B

/*
Write a program called Digits that has the following NON-STATIC methods:

int firstDigit(int n) which returns the first digit of the argument n
int lastDigit(int n) which returns the last digit of the argument n
int digits(int n) which returns the number of digits of the argument.

For example, firstDigit(1729) is 1, lastDigit(1729) is 9, and digits(1729) is 4.

You will need a program to test your methods.
This should be a separate program file, called something like DigitTester.java.
Use this program to create a new instance of Digits, and then call the methods with various values to ensure the program works correctly.
 */

//CS 108 - 2

//Due: September 9

//@Stephen Giang
import java.lang.Math;
public class Digits
{
    public int firstDigit(int number)
    {
        while (Math.abs(number) >= 10)
        {
            number = Math.abs(number) / 10;
        }
        return Math.abs(number);
    }

    public int lastDigit(int number)
    {
        number = number % 10;
        return Math.abs(number);
    }

    public int digits(int number)
    {
        int count = String.valueOf(Math.abs(number)).length();
        return count;
    }
}
