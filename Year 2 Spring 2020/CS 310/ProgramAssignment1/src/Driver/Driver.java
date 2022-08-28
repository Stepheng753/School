package Driver;
import Container.*;
import Data.*;

import java.util.Scanner;

public class Driver {

    Scanner input = new Scanner (System.in);
    StackQ <DataClass> queue = new StackQ <>();

    public Driver () {
        displayMenu();
    }

    public void displayMenu () {
        System.out.println("a) Enqueue in the Queue");
        System.out.println("b) Dequeue in the Queue");
        System.out.println("c) Peek in the Queue");
        System.out.println("d) Display the Queue");
        System.out.println("e) Display Size of Queue");
        System.out.println("f) Exit");
        System.out.println();
        System.out.print("Insert Letter (A - F): ");
        choices();
    }

    public void choices() {
        String choice = input.next();
        input.nextLine();
        System.out.println();
        try {
            if (choice.equalsIgnoreCase("A")) {
                System.out.print("Enter in the Data Name to Enqueue: ");
                String dataName = input.nextLine();
                System.out.print("Enter in the Data Int to Enqueue: ");
                if (input.hasNextInt()) {
                    int dataInt = input.nextInt();
                    System.out.println();
                    queue.enqueue(new DataClass(dataName, dataInt));
                }
                else {
                    throw new Exception("\nInput Not Recognized! Please Try Again!\n");
                }
            } else if (choice.equalsIgnoreCase("B")) {
                System.out.println("Dequeue Value: [ " + queue.dequeue() + " ]\n");
            } else if (choice.equalsIgnoreCase("C")) {
                System.out.println("Peek Value: [ " + queue.peek() + " ]\n");
            } else if (choice.equalsIgnoreCase("D")) {
                System.out.println("Queue: ");
                System.out.println(queue);
                System.out.println();
            } else if (choice.equalsIgnoreCase("E")) {
                System.out.println("Size of Queue: " + queue.getStackQSize() + "\n");
            } else if (choice.equalsIgnoreCase("F")) {
                System.out.println("Thank You!");
                System.exit(0);
            } else {
                throw new Exception("Input Not Recognized! Please Try Again \n");
            }
            displayMenu();
        } catch (Exception unknownInput) {
            System.out.println(unknownInput.getMessage());
            input = new Scanner(System.in);
            displayMenu();
        }
    }

    public static void main(String[] args) {
        new Driver();
    }

}
