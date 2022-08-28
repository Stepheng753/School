
import java.util.Scanner;
public class DigitTester
{
    public static void main (String[] args)
    {
        Guidelines getInfo = new Guidelines();
        Digits Test = new Digits();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter in Number: ");
        int number = input.nextInt();

        System.out.println("First Digit of " + number + " is: " + Test.firstDigit( number ));
        System.out.println("Last Digit of " + number + " is: " + Test.lastDigit( number ));
        System.out.println("Count of Digits of " + number + " is: " + Test.digits(number));

    }
}
