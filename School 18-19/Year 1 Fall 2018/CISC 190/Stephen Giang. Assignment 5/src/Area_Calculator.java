import java.lang.Math;
import java.util.Scanner;

class Area_Calculator {
  
  public static void main(String[] args) {
    
    // Variables
    double radius, width, length, height, area;
    int choice = 0;
    
    // Asks user for input.
    System.out.println("Choose which shape to calculate the area for.");
    System.out.print(" (Circle = 1, Rectangle = 2, Cylinder = 3): ");
    
    // Creates new scanner object for input
    Scanner keyboard = new Scanner(System.in);
    
    choice = keyboard.nextInt(); 
    
    // Loops until input is one of  the shapes
    while (choice < 1 || choice > 3){
      System.out.println("Please select from the selection.");
      System.out.print(" (Circle = 1, Rectangle = 2, Cylinder = 3): ");
      choice = keyboard.nextInt();
    }
    
    // Circle Area
    if (choice == 1){
      System.out.println("\nYou have selected the circle.");
      
      System.out.print("Enter the radius: ");
      radius = keyboard.nextDouble();
      
      area = Math.PI * radius * radius;
      
      System.out.printf("The area is %.2f.", area);
    }
    
    // Rectangle area
    if (choice == 2){
      System.out.println("\nYou have selected the rectangle.");
      
      System.out.print("Enter the length: ");
      length = keyboard.nextDouble();
      
      System.out.print("Enter the width: ");
      width = keyboard.nextDouble();
      
      area = length * width;
      
      System.out.printf("The area is %.2f.", area);
    }    
    
    // Cylinder area
    if (choice == 3){
      System.out.println("\nYou have selected the cylinder.");
      
      System.out.print("Enter the radius: ");
      radius = keyboard.nextDouble();
      
      System.out.print("Enter the height: ");
      height = keyboard.nextDouble();    
      
      area = Math.PI * radius * radius * height ;
      
      System.out.printf("The area is %.2f.", area);
    }        
    
  }
  
}
